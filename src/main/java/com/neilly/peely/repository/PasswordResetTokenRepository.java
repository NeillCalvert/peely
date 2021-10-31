package com.neilly.peely.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neilly.peely.model.PasswordResetToken;

/**
 * 
 */

/**
 * @author mcalv
 *
 */
public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long>{
	PasswordResetToken findByToken(String token);
}
