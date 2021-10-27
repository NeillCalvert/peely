/**
 * 
 */
package com.neilly.peely.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neilly.peely.exception.UsernameAlreadyTakenException;
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
	private AccountHolderRepository accountHolderRepository;
	
	public Iterable<AccountHolderDTO> getAllAccounts(){
		return accountHolderRepository.findAllAccountHolders();
	}
	
	public void createAccountHolder(AccountHolderDTO accountHolder){
		if(getByUsername(accountHolder.getUsername()) != null) {
			throw new UsernameAlreadyTakenException("Username already exists");
		}
		
		AccountHolder persistentAccountHolder = new AccountHolder(accountHolder.getFirstName(), accountHolder.getLastName(), accountHolder.getUsername(), accountHolder.getPassword(), accountHolder.getAge(), accountHolder.getEmail());
		accountHolderRepository.save(persistentAccountHolder);
	}
	
	public void deleteAccountHolderById(Long id) {
		accountHolderRepository.deleteById(id);
	}
	
	public AccountHolderDTO getByUsername(String username) {
		return accountHolderRepository.findByUsername(username);
	}
	
	public AccountHolderDTO getByEmail(String email) {
		return accountHolderRepository.findByEmail(email);
	}

	@Override
	public AccountHolderDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountHolderDTO accountHolder = accountHolderRepository.findByUsername(username);
		if(accountHolder == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new AccountHolderDetails(accountHolder);
	}	

}
