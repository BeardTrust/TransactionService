package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.entities.AccountTransaction;
import com.beardtrust.webapp.transactionservice.entities.CardTransaction;
import com.beardtrust.webapp.transactionservice.entities.FinancialTransaction;
import com.beardtrust.webapp.transactionservice.repos.AccountTransactionRepository;
import com.beardtrust.webapp.transactionservice.repos.CardTransactionRepository;
import com.beardtrust.webapp.transactionservice.repos.FinancialTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class provides the implementation of the Transaction Service.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final AccountTransactionRepository accountTransactionRepository;
	private final CardTransactionRepository cardTransactionRepository;
	private final FinancialTransactionRepository financialTransactionRepository;

	/**
	 * This method accesses each transaction repository to check the application's
	 * health and returns a String indicating the service is healthy or unhealthy.
	 *
	 * @return a String, "Healthy" or "Unhealthy"
	 */
	@Override
	public String checkHealth() {
		StringBuilder healthStatus = new StringBuilder();
		Pageable page = PageRequest.of(0, 1);

		try {
			Page<FinancialTransaction> financialTransactions = financialTransactionRepository.findAll(page);
			Page<AccountTransaction> accountTransaction = accountTransactionRepository.findAll(page);
			Page<CardTransaction> cardTransactions = cardTransactionRepository.findAll(page);
			log.info("Health check completed with healthy status.");
			healthStatus.append("Healthy");
		} catch (Exception e) {
			log.error(e.getMessage());
			healthStatus.append("Unhealthy");
		}

		return healthStatus.toString();
	}

	/**
	 * This method returns a Page of Financial Transactions in the database.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a Page<FinancialTransaction> object
	 */
	@Override
	public Page<FinancialTransaction> getAllTransactions(Pageable page) {
		Page<FinancialTransaction> financialTransactions = null;

		try {
			financialTransactions = financialTransactionRepository.findAll(page);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return financialTransactions;
	}

	/**
	 * This method returns a Page of Account Transactions in the database.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a Page<AccountTransaction> object
	 */
	@Override
	public Page<AccountTransaction> getAccountTransactions(Pageable page) {
		Page<AccountTransaction> accountTransactions = null;

		try {
			accountTransactions = accountTransactionRepository.findAll(page);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return accountTransactions;
	}

	/**
	 * This method returns a Page of Card Transactions in the database.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a Page<CardTransaction> object
	 */
	@Override
	public Page<CardTransaction> getCardTransactions(Pageable page) {
		Page<CardTransaction> cardTransactions = null;

		try {
			cardTransactions = cardTransactionRepository.findAll(page);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return cardTransactions;
	}
}
