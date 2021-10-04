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
	
	/**
	 * Account Holder data transfer object
	 */
	public AccountHolderDTO(String firstName, String lastName, String username, String password, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.age = age;
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

	@Override
	public String toString() {
		return "AccountHolderDTO [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
	}

}
