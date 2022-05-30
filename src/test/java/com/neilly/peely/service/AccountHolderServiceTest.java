/**
 * 
 */
package com.neilly.peely.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDetails;
import com.neilly.peely.repository.AccountHolderRepository;

import java.util.Optional;

/**
 * @author neill
 *
 */
@ExtendWith(MockitoExtension.class)
public class AccountHolderServiceTest {

	@Mock
	AccountHolderRepository accountHolderRepository;

	@InjectMocks
	AccountHolderServiceImpl accountHolderService;

	public final String TEST_NAME = "testname";
	public final String TEST_USERNAME = "testname";
	public final String TEST_VALID_PASSWORD = "P@ssword";
	public final String TEST_VALID_EMAIL = "testemail@testemail.com";
	public final int TEST_VALID_AGE = 24;
	public final String TEST_INVALID_PASSWORD = "test";
	public final String TEST_INVALID_EMAIL = "test";
	public final int TEST_INVALID_AGE = 17;

	@Test
	public void testCreateAccountHolderWithInvalidEmail() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new AccountHolder(TEST_NAME, TEST_NAME, TEST_USERNAME, TEST_VALID_PASSWORD, TEST_VALID_AGE,
					TEST_INVALID_EMAIL);
		});

		String expectedMessage = "Invalid Email";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);

	}

	@Test
	public void testCreateAccountHolderWithInvalidPassword() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new AccountHolder(TEST_NAME, TEST_NAME, TEST_USERNAME, TEST_INVALID_PASSWORD, TEST_VALID_AGE,
					TEST_VALID_EMAIL);
		});

		String expectedMessage = "Password must be a minimum of 6 characters and contain a special character";
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void testCreateAccountWithInvalidAge() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			new AccountHolder(TEST_NAME, TEST_NAME, TEST_USERNAME, TEST_VALID_PASSWORD, TEST_INVALID_AGE,
					TEST_VALID_EMAIL);
		});

		String expectedMessage = "Account Holders must be over " + AccountHolder.MINIMUM_ACCOUNTHOLDER_AGE;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);

	}

	@Test
	public void testLoadUserByUsername() {
		AccountHolder testAccountHolder = new AccountHolder(TEST_NAME, TEST_NAME, TEST_USERNAME, TEST_VALID_PASSWORD,
				TEST_VALID_AGE, TEST_VALID_EMAIL);
		
		AccountHolderDetails testAccountHolderDetails = new AccountHolderDetails(testAccountHolder);

		Mockito.when(accountHolderRepository.findByUsername(TEST_USERNAME)).thenReturn(Optional.of(testAccountHolder));

		assertThat(accountHolderService.loadUserByUsername(TEST_USERNAME)).usingRecursiveComparison().isEqualTo(testAccountHolderDetails);
	}

	@Test
	public void testLoadUserByUsernameEmpty() {
		AccountHolder accountHolder = null;
		Mockito.when(accountHolderRepository.findByUsername(TEST_USERNAME)).thenReturn(Optional.ofNullable(accountHolder));
		
		Exception exception = assertThrows(UsernameNotFoundException.class, () -> accountHolderService.loadUserByUsername(TEST_USERNAME));
		String expectedMessage = "Could not find user";
		String actualMessage = exception.getMessage();
		
		assertEquals(expectedMessage, actualMessage);
	}

}
