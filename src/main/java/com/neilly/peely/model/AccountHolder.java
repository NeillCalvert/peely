/**
 * 
 */
package com.neilly.peely.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mysql.cj.util.StringUtils;

/**
 * @author neill
 *
 */
@Entity
public class AccountHolder {
	
	public static final int MINIMUM_ACCOUNTHOLDER_AGE = 18;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	@Column(unique = true)
	private String username;
	private String password;
	
	public AccountHolder() {
		
	}
	
	public AccountHolder(String firstName, String lastName, String username, String password, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setUsername(username);
		setPassword(password);
		setAge(age);
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
		if(StringUtils.isNullOrEmpty(password)) {
			throw new IllegalArgumentException("Password cannot be empty");
		}
		this.password = password;
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

	@Override
	public String toString() {
		return "AccountHolder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
