package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.dtos.FinancialTransactionDTO;
import com.beardtrust.webapp.transactionservice.models.NewTransactionModel;
import com.beardtrust.webapp.transactionservice.models.UpdateTransactionModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This interface defines the API for the Transaction Service.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
public interface TransactionService {
	/**
	 * This method performs any required logic to check the application's health
	 * and returns a String indicating the service is healthy or unhealthy.
	 *
	 * @return a String, "Healthy" or "Unhealthy"
	 */
	String checkHealth();

	/**
	 * This method returns a Page of Financial Transactions in the database.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a Page<FinancialTransaction> object
	 */
	Page<FinancialTransactionDTO> getAllTransactions(Pageable page);

	/**
	 * This method returns a Page of Account Transactions in the database.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a Page<AccountTransaction> object
	 */
	Page<FinancialTransactionDTO> getAccountTransactions(Pageable page);

	/**
	 * This method returns a Page of Card Transactions in the database.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a Page<CardTransaction> object
	 */
	Page<FinancialTransactionDTO> getCardTransactions(Pageable page);

	Page<FinancialTransactionDTO> getLoanTransactions(Pageable page);

	FinancialTransactionDTO createTransaction(NewTransactionModel transaction);

	FinancialTransactionDTO updateTransaction(UpdateTransactionModel transaction);

	Page<FinancialTransactionDTO> getTransactionsByAssetId(String assetId, String search, Pageable page);
}
