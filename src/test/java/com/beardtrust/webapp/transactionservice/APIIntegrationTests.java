package com.beardtrust.webapp.transactionservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class APIIntegrationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	/**
	 * This method tests the health check endpoint for a status code of 200.
	 *
	 * @throws Exception if exception encountered accessing database
	 */
	@Test
	void test_healthCheck_statusIsOk() throws Exception {
		mockMvc.perform(get("/transactions/health"))
				.andExpect(status().isOk());
	}
}
