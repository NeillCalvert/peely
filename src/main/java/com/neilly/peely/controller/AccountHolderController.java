/**
 * 
 */
package com.neilly.peely.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

/**
 * @author neill
 *
 */
@RestController
@RequestMapping("/account")
public class AccountHolderController {
	
	@Autowired
	private AccountHolderService accountHolderService;

	@GetMapping("/accountById")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Finding account by ID", logMethodArgs = true)
	public Optional<AccountHolder> getById(@RequestParam Long id) {
		return accountHolderService.getById(id);
	}
	
	@GetMapping("/allAccounts")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Finding all accounts", logMethodArgs = true)
	public Iterable<AccountHolder> getAllAccounts() {
		return accountHolderService.getAllAccounts();
	}
	
	@PostMapping("/createAccount")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Creating account", logMethodArgs = true)
	public AccountHolder addAccount(@RequestBody AccountHolderDTO accountHolder) {		
		return accountHolderService.createAccountHolder(accountHolder);
	}
	
	@DeleteMapping("/deleteAccount")
	@ResponseStatus(HttpStatus.OK)
	@GenericLogger(logCustomMessage = true, customMessage = "Deleting Account", logMethodArgs = true)
	public void deleteAccountById(@RequestParam Long id) {
		accountHolderService.deleteAccountHolderById(id);
	}

}
