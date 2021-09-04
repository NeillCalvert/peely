/**
 * 
 */
package com.neilly.peely.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.service.AccountHolderService;

/**
 * @author neill
 *
 */
@RestController
@RequestMapping("/account")
public class AccountHolderController {
	
	private static final Logger logger = LogManager.getLogger(AccountHolderController.class);
	
	@Autowired
	private AccountHolderService accountHolderService;

	/**
	 * 
	 */
	public AccountHolderController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/accountById")
	public Optional<AccountHolder> getById(@RequestParam Long id) {
		logger.info("Id is : " + id);
		return accountHolderService.getById(id);
	}
	
	@PostMapping("/create")
	public AccountHolder addAccount(@RequestBody AccountHolder accountHolder){
		return accountHolderService.createAccountHolder(accountHolder);
		
	}
	
	

}
