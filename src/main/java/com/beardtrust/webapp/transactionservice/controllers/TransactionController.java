package com.beardtrust.webapp.transactionservice.controllers;

import com.beardtrust.webapp.transactionservice.dtos.FinancialTransactionDTO;
import com.beardtrust.webapp.transactionservice.entities.LoanTransaction;
import com.beardtrust.webapp.transactionservice.models.NewTransactionModel;
import com.beardtrust.webapp.transactionservice.models.UpdateTransactionModel;
import com.beardtrust.webapp.transactionservice.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

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
//	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(path = "/transactions")
	@Produces({MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Page<FinancialTransactionDTO>> getAllTransactions(Pageable page) {
		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getAllTransactions(page), HttpStatus.OK);

		return response;
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/account
	 * endpoint and returns the requested Page of Account Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<AccountTransaction> object
	 */
//	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(path = "/transactions/account")
	public ResponseEntity<Page<FinancialTransactionDTO>> getAccountTransactions(Pageable page) {
		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getAccountTransactions(page), HttpStatus.OK);

		return response;
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/card
	 * endpoint and returns the requested Page of Card Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<CardTransaction> object
	 */
//	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(path = "/transactions/card")
	public ResponseEntity<Page<FinancialTransactionDTO>> getCardTransactions(Pageable page) {
		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getCardTransactions(page), HttpStatus.OK);

		return response;
	}

	/**
	 * This method accepts an HTTP GET request on the /transactions/loan
	 * endpoint and returns the requested Page of Laon Transactions.
	 *
	 * @param page a Pageable object to request a page of transactions
	 * @return a Page<LoanTransaction> object
	 */
//	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(path = "/transactions/loan")
	public ResponseEntity<Page<FinancialTransactionDTO>> getLoanTransactions(Pageable page) {
		ResponseEntity<Page<FinancialTransactionDTO>> response;

		response = new ResponseEntity<>(transactionService.getLoanTransactions(page), HttpStatus.OK);

		return response;
	}

//	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(path = "/transactions/{id}")
	public ResponseEntity<Page<FinancialTransactionDTO>> getTransactionsByAssetId(@PathVariable(name = "id")String assetId,
																			@RequestParam(name = "search", required = false)String search,
																				  Pageable page){
		return new ResponseEntity<>(transactionService.getTransactionsByAssetId(assetId, search, page), HttpStatus.OK);
	}

//	@PreAuthorize("hasAuthority('admin')")
	@PostMapping(path = "/transactions")
	public ResponseEntity<FinancialTransactionDTO> createTransaction(@RequestBody() NewTransactionModel transaction) {
		log.info("Transaction Model: " + transaction.toString());

		ResponseEntity<FinancialTransactionDTO> response;
		response = new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);

		return response;
	}

//	@PreAuthorize("hasAuthority('admin')")
	@PutMapping(path = "/transactions")
	@Consumes({MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@Produces({MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<FinancialTransactionDTO> updateTransaction(@RequestBody() UpdateTransactionModel transaction){
		ResponseEntity<FinancialTransactionDTO> response;
		response = new ResponseEntity<>(transactionService.updateTransaction(transaction), HttpStatus.OK);

		return response;
	}
}