package com.beardtrust.webapp.transactionservice.controllers;

import static org.mockito.Mockito.when;

import com.beardtrust.webapp.transactionservice.services.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {TransactionController.class})
@ExtendWith(SpringExtension.class)
class TransactionControllerTest {
	@Autowired
	private TransactionController transactionController;

	@MockBean
	private TransactionService transactionService;

	@Test
	void testCheckHealth() throws Exception {
		when(this.transactionService.checkHealth()).thenReturn("Check Health");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/health");
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.transactionController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().is(503))
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(MockMvcResultMatchers.content().string("Check Health"));
	}

	@Test
	void testCheckHealth2() throws Exception {
		when(this.transactionService.checkHealth()).thenReturn("Healthy");
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/health");
		MockMvcBuilders.standaloneSetup(this.transactionController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(MockMvcResultMatchers.content().string("Healthy"));
	}

	@Test
	void testGetAccountTransactions() throws Exception {
		SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.transactionController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testGetAllTransactions() throws Exception {
		SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.transactionController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testGetCardTransactions() throws Exception {
		SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.transactionController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	void testGetLoanTransactions() throws Exception {
		SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
		ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.transactionController)
				.build()
				.perform(requestBuilder);
		actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}

