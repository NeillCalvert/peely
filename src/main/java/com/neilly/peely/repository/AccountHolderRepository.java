/**
 * 
 */
package com.neilly.peely.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neilly.peely.model.AccountHolder;

/**
 * @author neill
 *
 */
public interface AccountHolderRepository extends CrudRepository<AccountHolder, Long>{
	List<AccountHolder> findByFirstName(String firstName);

	Optional<AccountHolder> findByUsername(String username);
	
	@Query("SELECT a FROM AccountHolder a")
	List<AccountHolder> findAllAccountHolders();
	
	AccountHolder findByEmail(String email);

}
