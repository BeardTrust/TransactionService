package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.dtos.FinancialTransactionDTO;
import com.beardtrust.webapp.transactionservice.entities.AccountTransaction;
import com.beardtrust.webapp.transactionservice.entities.CardTransaction;
import com.beardtrust.webapp.transactionservice.entities.FinancialTransaction;
import com.beardtrust.webapp.transactionservice.entities.LoanTransaction;
import com.beardtrust.webapp.transactionservice.repos.AccountTransactionRepository;
import com.beardtrust.webapp.transactionservice.repos.CardTransactionRepository;
import com.beardtrust.webapp.transactionservice.repos.FinancialTransactionRepository;
import com.beardtrust.webapp.transactionservice.repos.LoanTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
	private final LoanTransactionRepository loanTransactionRepository;
	private final ModelMapper modelMapper;

	/**
	 * This method accesses each transaction repository to check the application's
	 * health and returns a String indicating the service is healthy or unhealthy.
	 *
	 * @return a String, "Healthy" or "Unhealthy"
	 */
	@Override
	public String checkHealth() {
		log.trace("Start of TransactionService.checkHealth()");

		StringBuilder healthStatus = new StringBuilder();
		Pageable page = PageRequest.of(0, 1);

		try {
			Page<FinancialTransaction> financialTransactions = financialTransactionRepository.findAll(page);
			Page<AccountTransaction> accountTransaction = accountTransactionRepository.findAll(page);
			Page<CardTransaction> cardTransactions = cardTransactionRepository.findAll(page);
			Page<LoanTransaction> loanTransactions = loanTransactionRepository.findAll(page);
			log.info("Health check completed with healthy status.");
			healthStatus.append("Healthy");
		} catch (Exception e) {
			log.debug("Exception encountered during health check:\n" + e.getMessage());
			healthStatus.append("Unhealthy");
		}

		log.trace("Start of TransactionService.checkHealth()");
		return healthStatus.toString();
	}

	/**
	 * This method retrieves a page of financial transactions from the database, converts
	 * the financial transactions to financial transaction data transfer objects, and
	 * returns the page of financial transaction data transfer objects.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a page of financial transaction DTOs
	 */
	@Override
	public Page<FinancialTransactionDTO> getAllTransactions(Pageable page) {
		log.trace("Start of TransactionService.getAllTransactions(" + page + ")");

		Page<FinancialTransactionDTO> financialTransactions = null;

		try {
			financialTransactions = financialTransactionRepository.findAll(page)
					.map(transaction -> modelMapper.map(transaction,
							FinancialTransactionDTO.class));

			log.info("Retrieved financial transactions");
		} catch (Exception e) {
			log.debug("Exception encountered while retrieving financial transactions:\n" +
					e.getMessage());
		}

		log.trace("End of TransactionService.getAllTransactions(" + page + ")");
		return financialTransactions;
	}

	/**
	 * This method retrieves a page of account transactions from the database, converts
	 * the account transactions to financial transaction data transfer objects, and
	 * returns the page of financial transaction data transfer objects.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a page of financial transaction DTOs
	 */
	@Override
	public Page<FinancialTransactionDTO> getAccountTransactions(Pageable page) {
		log.trace("End of TransactionService.getAccountTransactions(" + page + ")");

		Page<FinancialTransactionDTO> accountTransactions = null;

		try {
			accountTransactions = accountTransactionRepository.findAll(page)
					.map(transaction -> modelMapper.map(transaction,
							FinancialTransactionDTO.class));

			log.info("Retrieved account transactions");
		} catch (Exception e) {
			log.debug("Exception encountered while retrieving account transactions:\n" + e.getMessage());
		}

		log.trace("End of TransactionService.getAccountTransactions(" + page + ")");
		return accountTransactions;
	}

	/**
	 * This method retrieves a page of card transactions from the database, converts
	 * the card transactions to financial transaction data transfer objects, and
	 * returns the page of financial transaction data transfer objects.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a page of financial transaction DTOs
	 */
	@Override
	public Page<FinancialTransactionDTO> getCardTransactions(Pageable page) {
		log.trace("End of TransactionService.getCardTransactions(" + page + ")");

		Page<FinancialTransactionDTO> cardTransactions = null;

		try {
			cardTransactions = cardTransactionRepository.findAll(page)
					.map(transaction -> modelMapper.map(transaction,
							FinancialTransactionDTO.class));

			log.info("Retrieved card transactions");
		} catch (Exception e) {
			log.debug("Exception encountered while retrieving card transactions:\n" + e.getMessage());
		}

		log.trace("End of TransactionService.getCardTransactions(" + page + ")");
		return cardTransactions;
	}

	/**
	 * This method retrieves a page of loan transactions from the database, converts
	 * the loan transactions to financial transaction data transfer objects, and
	 * returns the page of financial transaction data transfer objects.
	 *
	 * @param page a Pageable object to request a Page
	 * @return a page of financial transaction DTOs
	 */
	@Override
	public Page<FinancialTransactionDTO> getLoanTransactions(Pageable page) {
		log.trace("Start of TransactionService.getLoanTransactions(" + page + ")");

		Page<FinancialTransactionDTO> loanTransactions = null;

		try {
			loanTransactions = loanTransactionRepository.findAll(page)
					.map(transaction -> modelMapper.map(transaction,
							FinancialTransactionDTO.class));

			log.info("Retrieved loan transactions");
		} catch (Exception e) {
			log.debug("Exception encountered while retrieving loan transactions:\n" + e.getMessage());
		}

		log.trace("End of TransactionService.getLoanTransactions(" + page + ")");
		return loanTransactions;
	}
}
