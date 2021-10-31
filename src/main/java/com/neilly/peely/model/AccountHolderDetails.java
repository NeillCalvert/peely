/**
 * 
 */
package com.neilly.peely.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author mcalv
 *
 */
public class AccountHolderDetails implements UserDetails {
	
	private AccountHolder accountHolder;
	
	public AccountHolderDetails(AccountHolder accountHolder2) {
		this.accountHolder = accountHolder2;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}
	
	public String getFirstName() {
		return accountHolder.getFirstName();
	}
	
	public String getLastName() {
		return accountHolder.getLastName();
	}
	
	public String getUsername() {
		return accountHolder.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return accountHolder.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
