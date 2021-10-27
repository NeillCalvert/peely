/**
 * 
 */
package com.neilly.peely.model;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mysql.cj.util.StringUtils;

/**
 * @author neill
 *
 */
@Entity
public class AccountHolder {
	
	public static final int MINIMUM_ACCOUNTHOLDER_AGE = 18;
	public static final int MINIMUM_PASSWORD_LENGTH = 6;
	public static final Pattern SPECIAL_CHARACTERS = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	
	public AccountHolder() {
		
	}
	
	public AccountHolder(String firstName, String lastName, String username, String password, int age, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setPassword(password);
		setAge(age);
		setEmail(email);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(StringUtils.isNullOrEmpty(firstName)) {
			throw new IllegalArgumentException("First name cannot be empty");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(StringUtils.isNullOrEmpty(lastName)) {
			throw new IllegalArgumentException("Last name cannot be empty");
		}
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < MINIMUM_ACCOUNTHOLDER_AGE) {
			StringBuilder sb = new StringBuilder("Account Holders must be over ");
			sb.append(MINIMUM_ACCOUNTHOLDER_AGE);
			throw new IllegalArgumentException(sb.toString());
		}
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(StringUtils.isNullOrEmpty(password) || password.length() < 6 || !SPECIAL_CHARACTERS.matcher(password).find()) {
			throw new IllegalArgumentException("Password must be a minimum of 6 characters and contain a special character");
		}
		this.password = passwordEncoder.encode(password);;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(StringUtils.isNullOrEmpty(username)) {
			throw new IllegalArgumentException("Username cannot be empty");
		}
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(!StringUtils.isNullOrEmpty(email) && VALID_EMAIL_ADDRESS_REGEX.matcher(email).find()) {
			this.email = email;
		} else {
			throw new IllegalArgumentException("Invalid Email");
		}
		
	}

	@Override
	public String toString() {
		return "AccountHolder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
