package com.beardtrust.webapp.transactionservice.controllers;

import com.beardtrust.webapp.transactionservice.entities.AccountTransaction;
import com.beardtrust.webapp.transactionservice.entities.CardTransaction;
import com.beardtrust.webapp.transactionservice.entities.FinancialTransaction;
import com.beardtrust.webapp.transactionservice.services.TransactionService;
import lombok.RequiredArgsConstructor;
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
		ResponseEntity<String> response = null;

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
	public Page<FinancialTransaction> getAllTransactions(Pageable page) {
		return transactionService.getAllTransactions(page);
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/account
	 * endpoint and returns the requested Page of Account Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<AccountTransaction> object
	 */
	@GetMapping(path = "/transactions/account")
	public Page<AccountTransaction> getAccountTransactions(Pageable page) {
		return transactionService.getAccountTransactions(page);
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/card
	 * endpoint and returns the requested Page of Card Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<CardTransaction> object
	 */
	@GetMapping(path = "/transactions/card")
	public Page<CardTransaction> getCardTransactions(Pageable page) {
		return transactionService.getCardTransactions(page);
	}
}
