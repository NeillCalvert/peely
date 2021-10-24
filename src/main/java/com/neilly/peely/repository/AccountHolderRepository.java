/**
 * 
 */
package com.neilly.peely.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDTO;

/**
 * @author neill
 *
 */
public interface AccountHolderRepository extends CrudRepository<AccountHolder, Long>{
	List<AccountHolderDTO> findByFirstName(String firstName);
	
	@Query("SELECT new com.neilly.peely.model.AccountHolderDTO(a.firstName, a.lastName, a.username, a.password, a.age) FROM AccountHolder a WHERE a.username = ?1")
	AccountHolderDTO findByUsername(String username);
	
	@Query ("SELECT new com.neilly.peely.model.AccountHolderDTO(a.firstName, a.lastName, a.username, a.password, a.age) from AccountHolder a")
	List<AccountHolderDTO> findAllAccountHolders();
	
}
