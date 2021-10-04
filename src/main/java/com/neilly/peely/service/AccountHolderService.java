/**
 * 
 */
package com.neilly.peely.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDTO;
import com.neilly.peely.model.AccountHolderDetails;
import com.neilly.peely.repository.AccountHolderRepository;

/**
 * @author neill
 *
 */
@Service
public class AccountHolderService implements UserDetailsService{
	
	@Autowired
	AccountHolderRepository accountHolderRepository;
	
	public Optional<AccountHolder> getById(Long id){
		return accountHolderRepository.findById(id);
	}
	
	public Iterable<AccountHolder> getAllAccounts(){
		return accountHolderRepository.findAll();
	}
	
	public AccountHolder createAccountHolder(AccountHolderDTO accountHolder){
		AccountHolder persistentAccountHolder = new AccountHolder(accountHolder.getFirstName(), accountHolder.getLastName(), accountHolder.getUsername(), accountHolder.getPassword(), accountHolder.getAge());
		return accountHolderRepository.save(persistentAccountHolder);
	}
	
	public void deleteAccountHolderById(Long id) {
		accountHolderRepository.deleteById(id);
	}
	
	public AccountHolder getByUsername(String username) {
		return accountHolderRepository.findByUsername(username);
	}

	@Override
	public AccountHolderDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountHolder accountHolder = accountHolderRepository.findByUsername(username);
		if(accountHolder == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new AccountHolderDetails(accountHolder);
	}
	
	

}
