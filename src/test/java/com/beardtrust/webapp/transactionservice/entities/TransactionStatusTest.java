package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TransactionStatusTest {
	@Test
	void testConstructor() {
		TransactionStatus actualTransactionStatus = new TransactionStatus();
		actualTransactionStatus.setStatusDescription("Status Description");
		actualTransactionStatus.setStatusId(123);
		actualTransactionStatus.setStatusName("Status Name");
		assertEquals("Status Description", actualTransactionStatus.getStatusDescription());
		assertEquals(123, actualTransactionStatus.getStatusId());
		assertEquals("Status Name", actualTransactionStatus.getStatusName());
		assertEquals("Status Name", actualTransactionStatus.toString());
	}

	@Test
	void testConstructor2() {
		TransactionStatus actualTransactionStatus = new TransactionStatus(123, "Status Name", "Status Description");
		actualTransactionStatus.setStatusDescription("Status Description");
		actualTransactionStatus.setStatusId(123);
		actualTransactionStatus.setStatusName("Status Name");
		assertEquals("Status Description", actualTransactionStatus.getStatusDescription());
		assertEquals(123, actualTransactionStatus.getStatusId());
		assertEquals("Status Name", actualTransactionStatus.getStatusName());
		assertEquals("Status Name", actualTransactionStatus.toString());
	}

	@Test
	void testEquals() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription("Status Description");
		transactionStatus.setStatusName("Status Name");
		transactionStatus.setStatusId(123);
		assertFalse(transactionStatus.equals(null));
	}

	@Test
	void testEquals2() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription("Status Description");
		transactionStatus.setStatusName("Status Name");
		transactionStatus.setStatusId(123);
		assertFalse(transactionStatus.equals("Different type to TransactionStatus"));
	}

	@Test
	void testEquals3() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription("Status Description");
		transactionStatus.setStatusName("Status Name");
		transactionStatus.setStatusId(123);
		assertTrue(transactionStatus.equals(transactionStatus));
		int expectedHashCodeResult = transactionStatus.hashCode();
		assertEquals(expectedHashCodeResult, transactionStatus.hashCode());
	}

	@Test
	void testEquals4() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription("Status Description");
		transactionStatus.setStatusName("Status Name");
		transactionStatus.setStatusId(123);

		TransactionStatus transactionStatus1 = new TransactionStatus();
		transactionStatus1.setStatusDescription("Status Description");
		transactionStatus1.setStatusName("Status Name");
		transactionStatus1.setStatusId(123);
		assertTrue(transactionStatus.equals(transactionStatus1));
		int expectedHashCodeResult = transactionStatus.hashCode();
		assertEquals(expectedHashCodeResult, transactionStatus1.hashCode());
	}

	@Test
	void testEquals5() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription(null);
		transactionStatus.setStatusName("Status Name");
		transactionStatus.setStatusId(123);

		TransactionStatus transactionStatus1 = new TransactionStatus();
		transactionStatus1.setStatusDescription("Status Description");
		transactionStatus1.setStatusName("Status Name");
		transactionStatus1.setStatusId(123);
		assertFalse(transactionStatus.equals(transactionStatus1));
	}

	@Test
	void testEquals6() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription("Status Description");
		transactionStatus.setStatusName(null);
		transactionStatus.setStatusId(123);

		TransactionStatus transactionStatus1 = new TransactionStatus();
		transactionStatus1.setStatusDescription("Status Description");
		transactionStatus1.setStatusName("Status Name");
		transactionStatus1.setStatusId(123);
		assertFalse(transactionStatus.equals(transactionStatus1));
	}

	@Test
	void testEquals7() {
		TransactionStatus transactionStatus = new TransactionStatus();
		transactionStatus.setStatusDescription("Status Description");
		transactionStatus.setStatusName("Status Name");
		transactionStatus.setStatusId(0);

		TransactionStatus transactionStatus1 = new TransactionStatus();
		transactionStatus1.setStatusDescription("Status Description");
		transactionStatus1.setStatusName("Status Name");
		transactionStatus1.setStatusId(123);
		assertFalse(transactionStatus.equals(transactionStatus1));
	}
}

