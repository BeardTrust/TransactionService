package com.beardtrust.webapp.transactionservice.controllers;

import com.beardtrust.webapp.transactionservice.dtos.FinancialTransactionDTO;
import com.beardtrust.webapp.transactionservice.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents the controller of the RESTful API for transactions.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

	private final TransactionService transactionService;

	/**
	 * This method accepts an HTTP GET request on the /transactions/health
	 * endpoint and returns a String, "Healthy," and a status code of 200
	 * if healthy or a String, "Unhealthy," and a status code of 503 if
	 * not healthy.
	 *
	 * @return a ResponseEntity<String> with HttpStatus.OK
	 */
	@GetMapping(path = "/transactions/health")
	public ResponseEntity<String> checkHealth() {
		String status = transactionService.checkHealth();
		ResponseEntity<String> response;

		if (status.equals("Healthy")) {
			response = new ResponseEntity<>(status, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(status, HttpStatus.SERVICE_UNAVAILABLE);
		}

		return response;
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions
	 * endpoint and returns the requested Page of Financial Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<FinancialTransaction> object
	 */
	@GetMapping(path = "/transactions")
	public ResponseEntity<Page<FinancialTransactionDTO>> getAllTransactions(Pageable page) {
		log.trace("Start of TransactionController.getAllTransactions(" + page + ")");

		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getAllTransactions(page), HttpStatus.OK);

		log.trace("End of TransactionController.getAllTransactions(" + page + ")");

		return response;
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/account
	 * endpoint and returns the requested Page of Account Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<AccountTransaction> object
	 */
	@GetMapping(path = "/transactions/account")
	public ResponseEntity<Page<FinancialTransactionDTO>> getAccountTransactions(Pageable page) {
		log.trace("Start of TransactionController.getAccountTransactions(" + page + ")");

		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getAccountTransactions(page), HttpStatus.OK);

		log.trace("End of TransactionController.getAccountTransactions(" + page + ")");

		return response;
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/card
	 * endpoint and returns the requested Page of Card Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<CardTransaction> object
	 */
	@GetMapping(path = "/transactions/card")
	public ResponseEntity<Page<FinancialTransactionDTO>> getCardTransactions(Pageable page) {
		log.trace("Start of TransactionController.getCardTransactions(" + page + ")");

		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getCardTransactions(page), HttpStatus.OK);

		log.trace("End of TransactionController.getCardTransactions(" + page + ")");

		return response;
	}

	@GetMapping(path = "/transactions/loan")
	public ResponseEntity<Page<FinancialTransactionDTO>> getLoanTransactions(Pageable page) {
		log.trace("Start of TransactionController.getLoanTransactions(" + page + ")");

		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getLoanTransactions(page), HttpStatus.OK);

		log.trace("End of TransactionController.getLoanTransactions(" + page + ")");
		return response;
	}
}
