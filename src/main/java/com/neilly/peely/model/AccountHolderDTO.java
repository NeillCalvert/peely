/**
 * 
 */
package com.neilly.peely.model;

/**
 * @author mcalv
 *
 */
public class AccountHolderDTO {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int age;
	private String email;
	
	public AccountHolderDTO() {}
	
	/**
	 * Account Holder data transfer object
	 */
	public AccountHolderDTO(String firstName, String lastName, String username, String password, int age, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.age = age;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "AccountHolderDTO [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", email=" + email + "]";
	}

}
