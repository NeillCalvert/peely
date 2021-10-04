/**
 * 
 */
package com.neilly.peely.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.neilly.peely.model.AccountHolder;
import com.neilly.peely.service.AccountHolderService;

/**
 * @author mcalv
 *
 */
@WebMvcTest(AccountHolderController.class)
class AccountHolderControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountHolderService accountHolderService;

	@Test
	void getByIdTest() throws Exception {
		AccountHolder accountHolder = new AccountHolder("firstName", "lastName", null, null, 1);
		accountHolder.setId(1L);
		when(accountHolderService.getById(1L)).thenReturn(Optional.of(accountHolder));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/account/accountById/").queryParam("id", "1"); // with id url path = 3
		System.out.println(requestBuilder.toString());
		ResultMatcher expectedStatus = MockMvcResultMatchers.status().is(HttpStatus.OK.value()); // status = 200
		
		this.mockMvc.perform(requestBuilder).andExpect(expectedStatus).andExpect(content().json("{\"id\":1, \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"age\" : 1}"));
	}

}
