package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TransactionTypeTest {
	@Test
	void testConstructor() {
		TransactionType actualTransactionType = new TransactionType();
		actualTransactionType.setSourceDescription("Source Description");
		actualTransactionType.setTargetDescription("Target Description");
		actualTransactionType.setTypeDescription("Type Description");
		actualTransactionType.setTypeId(123);
		actualTransactionType.setTypeName("Type Name");
		assertEquals("Source Description", actualTransactionType.getSourceDescription());
		assertEquals("Target Description", actualTransactionType.getTargetDescription());
		assertEquals("Type Description", actualTransactionType.getTypeDescription());
		assertEquals(123, actualTransactionType.getTypeId());
		assertEquals("Type Name", actualTransactionType.getTypeName());
		assertEquals("Type Name", actualTransactionType.toString());
	}

	@Test
	void testConstructor2() {
		TransactionType actualTransactionType = new TransactionType(123, "Type Name", "Type Description",
				"Source Description", "Target Description");
		actualTransactionType.setSourceDescription("Source Description");
		actualTransactionType.setTargetDescription("Target Description");
		actualTransactionType.setTypeDescription("Type Description");
		actualTransactionType.setTypeId(123);
		actualTransactionType.setTypeName("Type Name");
		assertEquals("Source Description", actualTransactionType.getSourceDescription());
		assertEquals("Target Description", actualTransactionType.getTargetDescription());
		assertEquals("Type Description", actualTransactionType.getTypeDescription());
		assertEquals(123, actualTransactionType.getTypeId());
		assertEquals("Type Name", actualTransactionType.getTypeName());
		assertEquals("Type Name", actualTransactionType.toString());
	}

	@Test
	void testEquals() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");
		assertFalse(transactionType.equals(null));
	}

	@Test
	void testEquals2() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");
		assertFalse(transactionType.equals("Different type to TransactionType"));
	}

	@Test
	void testEquals3() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");
		assertTrue(transactionType.equals(transactionType));
		int expectedHashCodeResult = transactionType.hashCode();
		assertEquals(expectedHashCodeResult, transactionType.hashCode());
	}

	@Test
	void testEquals4() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");

		TransactionType transactionType1 = new TransactionType();
		transactionType1.setTypeId(123);
		transactionType1.setTargetDescription("Target Description");
		transactionType1.setTypeDescription("Type Description");
		transactionType1.setTypeName("Type Name");
		transactionType1.setSourceDescription("Source Description");
		assertTrue(transactionType.equals(transactionType1));
		int expectedHashCodeResult = transactionType.hashCode();
		assertEquals(expectedHashCodeResult, transactionType1.hashCode());
	}

	@Test
	void testEquals5() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(0);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");

		TransactionType transactionType1 = new TransactionType();
		transactionType1.setTypeId(123);
		transactionType1.setTargetDescription("Target Description");
		transactionType1.setTypeDescription("Type Description");
		transactionType1.setTypeName("Type Name");
		transactionType1.setSourceDescription("Source Description");
		assertFalse(transactionType.equals(transactionType1));
	}

	@Test
	void testEquals6() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription(null);
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");

		TransactionType transactionType1 = new TransactionType();
		transactionType1.setTypeId(123);
		transactionType1.setTargetDescription("Target Description");
		transactionType1.setTypeDescription("Type Description");
		transactionType1.setTypeName("Type Name");
		transactionType1.setSourceDescription("Source Description");
		assertFalse(transactionType.equals(transactionType1));
	}

	@Test
	void testEquals7() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription(null);
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription("Source Description");

		TransactionType transactionType1 = new TransactionType();
		transactionType1.setTypeId(123);
		transactionType1.setTargetDescription("Target Description");
		transactionType1.setTypeDescription("Type Description");
		transactionType1.setTypeName("Type Name");
		transactionType1.setSourceDescription("Source Description");
		assertFalse(transactionType.equals(transactionType1));
	}

	@Test
	void testEquals8() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName(null);
		transactionType.setSourceDescription("Source Description");

		TransactionType transactionType1 = new TransactionType();
		transactionType1.setTypeId(123);
		transactionType1.setTargetDescription("Target Description");
		transactionType1.setTypeDescription("Type Description");
		transactionType1.setTypeName("Type Name");
		transactionType1.setSourceDescription("Source Description");
		assertFalse(transactionType.equals(transactionType1));
	}

	@Test
	void testEquals9() {
		TransactionType transactionType = new TransactionType();
		transactionType.setTypeId(123);
		transactionType.setTargetDescription("Target Description");
		transactionType.setTypeDescription("Type Description");
		transactionType.setTypeName("Type Name");
		transactionType.setSourceDescription(null);

		TransactionType transactionType1 = new TransactionType();
		transactionType1.setTypeId(123);
		transactionType1.setTargetDescription("Target Description");
		transactionType1.setTypeDescription("Type Description");
		transactionType1.setTypeName("Type Name");
		transactionType1.setSourceDescription("Source Description");
		assertFalse(transactionType.equals(transactionType1));
	}
}

