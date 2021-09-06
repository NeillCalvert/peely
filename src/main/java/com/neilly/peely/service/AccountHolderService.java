/**
 * 
 */
package com.neilly.peely.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDTO;
import com.neilly.peely.repository.AccountHolderRepository;

/**
 * @author neill
 *
 */
@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	public Optional<AccountHolder> getById(Long id){
		return accountHolderRepository.findById(id);
	}
	
	public Iterable<AccountHolder> getAllAccounts(){
		return accountHolderRepository.findAll();
	}
	
	public AccountHolder createAccountHolder(AccountHolderDTO accountHolder){
		AccountHolder persistentAccountHolder = new AccountHolder(accountHolder.getFirstName(), accountHolder.getLastName(), accountHolder.getAge());
		return accountHolderRepository.save(persistentAccountHolder);
	}
	
	public void deleteAccountHolderById(Long id) {
		accountHolderRepository.deleteById(id);
	}

}
