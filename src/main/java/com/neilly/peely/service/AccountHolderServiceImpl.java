/**
 * 
 */
package com.neilly.peely.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neilly.peely.exception.EmailAlreadyTakenException;
import com.neilly.peely.exception.UsernameAlreadyTakenException;
import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDetails;
import com.neilly.peely.repository.AccountHolderRepository;

/**
 * @author neill
 *
 */
@Service
public class AccountHolderServiceImpl implements UserDetailsService, AccountHolderService{
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;
	
	public List<AccountHolder> getAllAccounts(){
		return accountHolderRepository.findAllAccountHolders();
	}
	
	public void createAccountHolder(AccountHolder accountHolder){
		
		if(getByUsername(accountHolder.getUsername()).isPresent()) {
			throw new UsernameAlreadyTakenException("Username already exists");
		}
		
		if(null != getByEmail(accountHolder.getEmail())) {
			throw new EmailAlreadyTakenException("Email already taken");
		}

		accountHolderRepository.save(accountHolder);
	}
	
	public void deleteAccountHolderById(Long id) {
		accountHolderRepository.deleteById(id);
	}
	
	public Optional<AccountHolder> getByUsername(String username) {
		return accountHolderRepository.findByUsername(username);
	}
	
	public AccountHolder getByEmail(String email) {
		return accountHolderRepository.findByEmail(email);
	}
	
	public Optional<AccountHolder> getById(Long id) {
		return accountHolderRepository.findById(id);
	}

	@Override
	public AccountHolderDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AccountHolder> accountHolder = accountHolderRepository.findByUsername(username);
		if (!accountHolder.isPresent()) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new AccountHolderDetails(accountHolder.get());
	}	

}
