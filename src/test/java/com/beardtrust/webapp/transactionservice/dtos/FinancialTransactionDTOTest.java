package com.beardtrust.webapp.transactionservice.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.beardtrust.webapp.transactionservice.entities.AccountEntity;
import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import com.beardtrust.webapp.transactionservice.entities.TransactionStatus;
import com.beardtrust.webapp.transactionservice.entities.TransactionType;
import org.junit.jupiter.api.Test;

class FinancialTransactionDTOTest {
	@Test
	void testEquals() {
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		assertFalse((new FinancialTransactionDTO("42", amount, transactionStatus, source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes"))
				.equals(null));
	}

	@Test
	void testEquals2() {
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		assertFalse((new FinancialTransactionDTO("42", amount, transactionStatus, source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes"))
				.equals("Different type to FinancialTransactionDTO"));
	}

	@Test
	void testEquals3() {
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO("42", amount, transactionStatus,
				source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes");
		assertTrue(financialTransactionDTO.equals(financialTransactionDTO));
		int expectedHashCodeResult = financialTransactionDTO.hashCode();
		assertEquals(expectedHashCodeResult, financialTransactionDTO.hashCode());
	}

	@Test
	void testEquals4() {
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO("42", amount, transactionStatus,
				source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes");
		CurrencyValue amount1 = new CurrencyValue();
		TransactionStatus transactionStatus1 = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source1 = new AccountEntity();
		AccountEntity target1 = new AccountEntity();
		assertFalse(financialTransactionDTO.equals(new FinancialTransactionDTO("42", amount1, transactionStatus1, source1,
				target1, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes")));
	}

	@Test
	void testEquals5() {
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO(null, amount, transactionStatus,
				source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes");
		CurrencyValue amount1 = new CurrencyValue();
		TransactionStatus transactionStatus1 = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source1 = new AccountEntity();
		AccountEntity target1 = new AccountEntity();
		assertFalse(financialTransactionDTO.equals(new FinancialTransactionDTO("42", amount1, transactionStatus1, source1,
				target1, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes")));
	}

	@Test
	void testEquals6() {
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO("Id", amount, transactionStatus,
				source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes");
		CurrencyValue amount1 = new CurrencyValue();
		TransactionStatus transactionStatus1 = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source1 = new AccountEntity();
		AccountEntity target1 = new AccountEntity();
		assertFalse(financialTransactionDTO.equals(new FinancialTransactionDTO("42", amount1, transactionStatus1, source1,
				target1, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes")));
	}

	@Test
	void testEquals7() {
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO("42", null, transactionStatus, source,
				target, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes");
		CurrencyValue amount = new CurrencyValue();
		TransactionStatus transactionStatus1 = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source1 = new AccountEntity();
		AccountEntity target1 = new AccountEntity();
		assertFalse(financialTransactionDTO.equals(new FinancialTransactionDTO("42", amount, transactionStatus1, source1,
				target1, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes")));
	}

	@Test
	void testEquals8() {
		CurrencyValue amount = new CurrencyValue(1, 1);

		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO("42", amount, transactionStatus,
				source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes");
		CurrencyValue amount1 = new CurrencyValue();
		TransactionStatus transactionStatus1 = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source1 = new AccountEntity();
		AccountEntity target1 = new AccountEntity();
		assertFalse(financialTransactionDTO.equals(new FinancialTransactionDTO("42", amount1, transactionStatus1, source1,
				target1, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes")));
	}

	@Test
	void testEquals9() {
		CurrencyValue amount = mock(CurrencyValue.class);
		TransactionStatus transactionStatus = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source = new AccountEntity();
		AccountEntity target = new AccountEntity();
		FinancialTransactionDTO financialTransactionDTO = new FinancialTransactionDTO("42", amount, transactionStatus,
				source, target,
				new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"), "Notes");
		CurrencyValue amount1 = new CurrencyValue();
		TransactionStatus transactionStatus1 = new TransactionStatus(123, "Status Name", "Status Description");

		AccountEntity source1 = new AccountEntity();
		AccountEntity target1 = new AccountEntity();
		assertFalse(financialTransactionDTO.equals(new FinancialTransactionDTO("42", amount1, transactionStatus1, source1,
				target1, new TransactionType(123, "Type Name", "Type Description", "Source Description", "Target Description"),
				"Notes")));
	}
}

