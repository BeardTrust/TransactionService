package com.beardtrust.webapp.transactionservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransactionSpecializationTest {
	@Test
	void testValueOf() {
		assertEquals(TransactionSpecialization.ACCOUNT, TransactionSpecialization.valueOf("ACCOUNT"));
	}

	@Test
	void testValues() {
		TransactionSpecialization[] actualValuesResult = TransactionSpecialization.values();
		assertEquals(3, actualValuesResult.length);
		assertEquals(TransactionSpecialization.ACCOUNT, actualValuesResult[0]);
		assertEquals(TransactionSpecialization.CARD, actualValuesResult[1]);
		assertEquals(TransactionSpecialization.LOAN, actualValuesResult[2]);
	}
}

