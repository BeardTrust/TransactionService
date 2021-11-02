package com.beardtrust.webapp.transactionservice.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class IncorrectTransactionSpecializationExceptionTest {
	@Test
	void testConstructor() {
		IncorrectTransactionSpecializationException actualIncorrectTransactionSpecializationException = new IncorrectTransactionSpecializationException(
				"Msg");
		assertNull(actualIncorrectTransactionSpecializationException.getCause());
		assertEquals("com.beardtrust.webapp.transactionservice.exceptions.IncorrectTransactionSpecializationException: Msg",
				actualIncorrectTransactionSpecializationException.toString());
		assertEquals(0, actualIncorrectTransactionSpecializationException.getSuppressed().length);
		assertEquals("Msg", actualIncorrectTransactionSpecializationException.getMessage());
		assertEquals("Msg", actualIncorrectTransactionSpecializationException.getLocalizedMessage());
	}
}

