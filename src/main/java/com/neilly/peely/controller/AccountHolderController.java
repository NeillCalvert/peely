/**
 * 
 */
package com.neilly.peely.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neilly.peely.aspect.GenericLogger;
import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDTO;
import com.neilly.peely.service.AccountHolderService;
import com.neilly.peely.service.PasswordResetTokenService;

/**
 * @author neill
 *
 */
@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountHolderController {
	
	@Autowired
	private AccountHolderService accountHolderService;
	
	@Autowired
	private PasswordResetTokenService passwordResetTokenService;
	
	@GetMapping("/allAccounts")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Finding all accounts", logMethodArgs = true)
	public Iterable<AccountHolder> getAllAccounts() {
		return accountHolderService.getAllAccounts();
	}
	
	@PostMapping("/createAccount")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Creating account", logMethodArgs = true)
	public void addAccount(@RequestBody AccountHolderDTO accountHolder) {		
		accountHolderService.createAccountHolder(accountHolder);
	}
	
	@DeleteMapping("/deleteAccount")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Deleting Account", logMethodArgs = true)
	public void deleteAccountById(@RequestParam Long id) {
		accountHolderService.deleteAccountHolderById(id);
	}
	
	@PostMapping("/getPasswordResetToken")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Sending password reset token to user", logMethodArgs = true)
	public void sendResetPasswordToken(@RequestParam("email") String userEmail) {
		passwordResetTokenService.sendEmailWithPasswordResetToken(userEmail);
	}
	
	@PostMapping("/resetPassword")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Resetting password", logMethodArgs = true)
	public void resetPassword(@RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("passwordResetToken") String passwordResetToken, @RequestParam("newPassword") String newPassword) {
		passwordResetTokenService.updatePassword(email, username, passwordResetToken, newPassword);
	}
	
	@GetMapping("/user")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Logging in user", logMethodArgs = true)
	public boolean user(Principal user) {
		return true;
	}

}
