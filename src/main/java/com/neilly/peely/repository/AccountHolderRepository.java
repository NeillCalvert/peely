/**
 * 
 */
package com.neilly.peely.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.neilly.peely.model.AccountHolder;

/**
 * @author neill
 *
 */
public interface AccountHolderRepository extends CrudRepository<AccountHolder, Long>{
	List<AccountHolder> findByFirstName(String firstName);
}
