package com.beardtrust.webapp.transactionservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UpdateTransactionModelTest {
	@Test
	void testCanEqual() {
		assertFalse((new UpdateTransactionModel("42", "Transaction Status Name", "Notes")).canEqual("Other"));
	}

	@Test
	void testCanEqual2() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name",
				"Notes");
		assertTrue(updateTransactionModel.canEqual(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testConstructor() {
		UpdateTransactionModel actualUpdateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name",
				"Notes");
		actualUpdateTransactionModel.setNotes("Notes");
		actualUpdateTransactionModel.setTransactionId("42");
		actualUpdateTransactionModel.setTransactionStatusName("Transaction Status Name");
		assertEquals("Notes", actualUpdateTransactionModel.getNotes());
		assertEquals("42", actualUpdateTransactionModel.getTransactionId());
		assertEquals("Transaction Status Name", actualUpdateTransactionModel.getTransactionStatusName());
		assertEquals("UpdateTransactionModel(transactionId=42, transactionStatusName=Transaction Status Name, notes=Notes)",
				actualUpdateTransactionModel.toString());
	}

	@Test
	void testEquals() {
		assertFalse((new UpdateTransactionModel("42", "Transaction Status Name", "Notes")).equals(null));
		assertFalse((new UpdateTransactionModel("42", "Transaction Status Name", "Notes"))
				.equals("Different type to UpdateTransactionModel"));
	}

	@Test
	void testEquals2() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name",
				"Notes");
		assertTrue(updateTransactionModel.equals(updateTransactionModel));
		int expectedHashCodeResult = updateTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, updateTransactionModel.hashCode());
	}

	@Test
	void testEquals3() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name",
				"Notes");
		UpdateTransactionModel updateTransactionModel1 = new UpdateTransactionModel("42", "Transaction Status Name",
				"Notes");

		assertTrue(updateTransactionModel.equals(updateTransactionModel1));
		int expectedHashCodeResult = updateTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, updateTransactionModel1.hashCode());
	}

	@Test
	void testEquals4() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("Transaction Status Name",
				"Transaction Status Name", "Notes");
		assertFalse(updateTransactionModel.equals(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testEquals5() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel(null, "Transaction Status Name",
				"Notes");
		assertFalse(updateTransactionModel.equals(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testEquals6() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "42", "Notes");
		assertFalse(updateTransactionModel.equals(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testEquals7() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", null, "Notes");
		assertFalse(updateTransactionModel.equals(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testEquals8() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name", "42");
		assertFalse(updateTransactionModel.equals(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testEquals9() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name", null);
		assertFalse(updateTransactionModel.equals(new UpdateTransactionModel("42", "Transaction Status Name", "Notes")));
	}

	@Test
	void testEquals10() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel(null, "Transaction Status Name",
				"Notes");
		UpdateTransactionModel updateTransactionModel1 = new UpdateTransactionModel(null, "Transaction Status Name",
				"Notes");

		assertTrue(updateTransactionModel.equals(updateTransactionModel1));
		int expectedHashCodeResult = updateTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, updateTransactionModel1.hashCode());
	}

	@Test
	void testEquals11() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", null, "Notes");
		UpdateTransactionModel updateTransactionModel1 = new UpdateTransactionModel("42", null, "Notes");

		assertTrue(updateTransactionModel.equals(updateTransactionModel1));
		int expectedHashCodeResult = updateTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, updateTransactionModel1.hashCode());
	}

	@Test
	void testEquals12() {
		UpdateTransactionModel updateTransactionModel = new UpdateTransactionModel("42", "Transaction Status Name", null);
		UpdateTransactionModel updateTransactionModel1 = new UpdateTransactionModel("42", "Transaction Status Name", null);

		assertTrue(updateTransactionModel.equals(updateTransactionModel1));
		int expectedHashCodeResult = updateTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, updateTransactionModel1.hashCode());
	}
}

