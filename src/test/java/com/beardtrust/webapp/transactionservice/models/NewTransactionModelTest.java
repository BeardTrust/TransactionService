package com.beardtrust.webapp.transactionservice.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import org.junit.jupiter.api.Test;

class NewTransactionModelTest {
	@Test
	void testCanEqual() {
		assertFalse((new NewTransactionModel(TransactionSpecialization.ACCOUNT, new CurrencyValue(),
				"Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")).canEqual("Other"));
	}

	@Test
	void testCanEqual2() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertTrue(newTransactionModel.canEqual(new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")));
	}

	@Test
	void testConstructor() {
		NewTransactionModel actualNewTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);
		actualNewTransactionModel.setAmount(currencyValue);
		actualNewTransactionModel.setNotes("Notes");
		actualNewTransactionModel.setSourceId("42");
		actualNewTransactionModel.setTargetId("42");
		actualNewTransactionModel.setTransactionSpecialization(TransactionSpecialization.ACCOUNT);
		actualNewTransactionModel.setTransactionStatusName("Transaction Status Name");
		actualNewTransactionModel.setTransactionTypeName("Transaction Type Name");
		assertSame(currencyValue, actualNewTransactionModel.getAmount());
		assertEquals("Notes", actualNewTransactionModel.getNotes());
		assertEquals("42", actualNewTransactionModel.getSourceId());
		assertEquals("42", actualNewTransactionModel.getTargetId());
		assertEquals(TransactionSpecialization.ACCOUNT, actualNewTransactionModel.getTransactionSpecialization());
		assertEquals("Transaction Status Name", actualNewTransactionModel.getTransactionStatusName());
		assertEquals("Transaction Type Name", actualNewTransactionModel.getTransactionTypeName());
		assertEquals(
				"NewTransactionModel(transactionSpecialization=ACCOUNT, amount=-$1.01, transactionStatusName=Transaction"
						+ " Status Name, sourceId=42, targetId=42, transactionTypeName=Transaction Type Name, notes=Notes)",
				actualNewTransactionModel.toString());
	}

	@Test
	void testEquals() {
		assertFalse((new NewTransactionModel(TransactionSpecialization.ACCOUNT, new CurrencyValue(),
				"Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")).equals(null));
		assertFalse(
				(new NewTransactionModel(TransactionSpecialization.ACCOUNT, new CurrencyValue(), "Transaction Status Name",
						"42", "42", "Transaction Type Name", "Notes")).equals("Different type to NewTransactionModel"));
	}

	@Test
	void testEquals2() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertTrue(newTransactionModel.equals(newTransactionModel));
		int expectedHashCodeResult = newTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, newTransactionModel.hashCode());
	}

	@Test
	void testEquals3() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		NewTransactionModel newTransactionModel1 = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");

		assertTrue(newTransactionModel.equals(newTransactionModel1));
		int expectedHashCodeResult = newTransactionModel.hashCode();
		assertEquals(expectedHashCodeResult, newTransactionModel1.hashCode());
	}

	@Test
	void testEquals4() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(null, new CurrencyValue(),
				"Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertFalse(newTransactionModel.equals(new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")));
	}

	@Test
	void testEquals5() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.CARD,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertFalse(newTransactionModel.equals(new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")));
	}

	@Test
	void testEquals6() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT, null,
				"Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertFalse(newTransactionModel.equals(new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")));
	}

	@Test
	void testEquals7() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(1, 1), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertFalse(newTransactionModel.equals(new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")));
	}

	@Test
	void testEquals8() {
		NewTransactionModel newTransactionModel = new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				mock(CurrencyValue.class), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes");
		assertFalse(newTransactionModel.equals(new NewTransactionModel(TransactionSpecialization.ACCOUNT,
				new CurrencyValue(), "Transaction Status Name", "42", "42", "Transaction Type Name", "Notes")));
	}
}

