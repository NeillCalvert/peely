/**
 * 
 */
package com.neilly.peely.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author mcalv
 *
 */
@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String token;
 
    @OneToOne(targetEntity = AccountHolder.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "account_holder_id")
    private AccountHolder accountHolder;
 
    private Date expiryDate;

}
