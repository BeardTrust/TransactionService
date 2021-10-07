package com.beardtrust.webapp.transactionservice;

import com.beardtrust.webapp.transactionservice.dtos.FinancialTransactionDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@Sql(scripts = "classpath:transactions.sql")
@Transactional
class APIIntegrationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	/**
	 * This method tests the health check endpoint for a status code of 200.
	 *
	 * @throws Exception
	 */
	@Test
	void test_healthCheck_statusIsOk() throws Exception {
		mockMvc.perform(get("/transactions/health"))
				.andExpect(status().isOk());
	}

	/** This method tests that when accessing the endpoint for a specific transaction, returns a json object
	 * containing a String id, a CurrencyValue amount, a TransactionStatus transactionStatus, a FinancialAsset
	 * source, a FinancialAsset target, a TransactionType transactionType, and a String notes with a status
	 * code of 200.
	 **/
//	@Test
//	void test_getTransactionById_statusIsOk_payloadIsFinancialTransactionDTO() throws Exception {
//
//		FinancialTransactionDTO dto = FinancialTransactionDTO.builder()
//				.id("12323")
//				.build();
//
//		String jsonPayload = objectMapper.writeValueAsString(dto);
//
//		mockMvc.perform(get("/transactions/12323"))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(content().string(jsonPayload));
//	}

}
