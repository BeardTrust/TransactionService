package com.beardtrust.webapp.transactionservice.advisors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.beardtrust.webapp.transactionservice.exceptions.IncorrectTransactionSpecializationException;
import com.beardtrust.webapp.transactionservice.exceptions.TransactionNotFoundException;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;

class TransactionControllerAdvisorTest {
	@Test
	void testHandleIncorrectTransactionSpecializationException() {
		TransactionControllerAdvisor transactionControllerAdvisor = new TransactionControllerAdvisor();
		IncorrectTransactionSpecializationException e = new IncorrectTransactionSpecializationException("Msg");
		ResponseEntity<Object> actualHandleIncorrectTransactionSpecializationExceptionResult = transactionControllerAdvisor
				.handleIncorrectTransactionSpecializationException(e, new ServletWebRequest(new MockHttpServletRequest()));
		assertEquals(2,
				((Map<String, LocalDateTime>) actualHandleIncorrectTransactionSpecializationExceptionResult.getBody()).size());
		assertTrue(actualHandleIncorrectTransactionSpecializationExceptionResult.hasBody());
		assertEquals(HttpStatus.BAD_REQUEST, actualHandleIncorrectTransactionSpecializationExceptionResult.getStatusCode());
		assertTrue(actualHandleIncorrectTransactionSpecializationExceptionResult.getHeaders().isEmpty());
	}

	@Test
	void testHandleTransactionNotfoundException() {
		TransactionControllerAdvisor transactionControllerAdvisor = new TransactionControllerAdvisor();
		TransactionNotFoundException e = new TransactionNotFoundException("Msg");
		ResponseEntity<Object> actualHandleTransactionNotfoundExceptionResult = transactionControllerAdvisor
				.handleTransactionNotfoundException(e, new ServletWebRequest(new MockHttpServletRequest()));
		assertEquals(2, ((Map<String, LocalDateTime>) actualHandleTransactionNotfoundExceptionResult.getBody()).size());
		assertTrue(actualHandleTransactionNotfoundExceptionResult.hasBody());
		assertEquals(HttpStatus.BAD_REQUEST, actualHandleTransactionNotfoundExceptionResult.getStatusCode());
		assertTrue(actualHandleTransactionNotfoundExceptionResult.getHeaders().isEmpty());
	}
}

