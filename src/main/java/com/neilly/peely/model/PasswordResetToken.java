/**
 * 
 */
package com.neilly.peely.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @author mcalv
 *
 */
@Entity
public class PasswordResetToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String token;
 
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = AccountHolder.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "account_holder_id")
    private AccountHolder accountHolder;
 
    private Date expiryDate;
    
    public PasswordResetToken() {}
    
	public PasswordResetToken(String token, AccountHolder accountHolder, Date expiryDate) {
		this.token = token;
		this.accountHolder = accountHolder;
		this.expiryDate = expiryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AccountHolder accountHolder) {
		this.accountHolder = accountHolder;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
