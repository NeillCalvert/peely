package com.neilly.peely.controller;

import com.neilly.peely.service.AccountHolderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.model.AccountHolderDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountHolderControllerTest {
	
	public static final String TEST_EMAIL = "testuser@test.com";
	public static final String TEST_NAME = "test";
	public static final String TEST_PASSWORD = "Test!234";
	public static final int TEST_AGE = 18;

	private ModelMapper modelMapper = new ModelMapper();

	@Mock
	private AccountHolderServiceImpl accountHolderService;

	@Test
	public void testConvertToDTO() {
		AccountHolder accountHolder = new AccountHolder();
		
		accountHolder.setId(1L);
		accountHolder.setEmail(TEST_EMAIL);
		accountHolder.setFirstName(TEST_NAME);
		accountHolder.setLastName(TEST_NAME);
		accountHolder.setUsername(TEST_NAME);
		accountHolder.setPassword(TEST_PASSWORD);
		accountHolder.setAge(TEST_AGE);
		
		AccountHolderDTO accountHolderDTO = modelMapper.map(accountHolder, AccountHolderDTO.class);
		
		assertEquals(accountHolder.getId(), accountHolderDTO.getId());
		assertEquals(accountHolder.getEmail(), accountHolderDTO.getEmail());
		assertEquals(accountHolder.getFirstName(), accountHolderDTO.getFirstName());
		assertEquals(accountHolder.getLastName(), accountHolderDTO.getLastName());
		assertEquals(accountHolder.getUsername(), accountHolderDTO.getUsername());
		assertEquals(accountHolder.getPassword(), accountHolderDTO.getPassword());
		assertEquals(accountHolder.getAge(), accountHolderDTO.getAge());
		
	}
	
	@Test
	public void testConvertToEntity() {
		AccountHolderDTO accountHolderDTO = new AccountHolderDTO();

		accountHolderDTO.setEmail(TEST_EMAIL);
		accountHolderDTO.setFirstName(TEST_NAME);
		accountHolderDTO.setLastName(TEST_NAME);
		accountHolderDTO.setUsername(TEST_NAME);
		accountHolderDTO.setPassword(TEST_PASSWORD);
		accountHolderDTO.setAge(TEST_AGE);

		AccountHolder accountHolder = modelMapper.map(accountHolderDTO, AccountHolder.class);

		assertEquals(accountHolderDTO.getEmail(), accountHolder.getEmail());
		assertEquals(accountHolderDTO.getFirstName(), accountHolder.getFirstName());
		assertEquals(accountHolderDTO.getLastName(), accountHolder.getLastName());
		assertEquals(accountHolderDTO.getUsername(), accountHolder.getUsername());
		assertEquals(accountHolderDTO.getAge(), accountHolder.getAge());

	}


}
