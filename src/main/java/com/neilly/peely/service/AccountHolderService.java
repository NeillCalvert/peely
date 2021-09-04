/**
 * 
 */
package com.neilly.peely.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.repository.AccountHolderRepository;

/**
 * @author neill
 *
 */
@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	/**
	 * 
	 */
	public AccountHolderService() {
		// TODO Auto-generated constructor stub
	}
	
	public Optional<AccountHolder> getById(Long id) {
		return accountHolderRepository.findById(id);
	}
	
	public Iterable<AccountHolder> getAll(){
		return accountHolderRepository.findAll();
	}
	
	public AccountHolder createAccountHolder(AccountHolder accountHolder){
		return accountHolderRepository.save(accountHolder);
	}

}
