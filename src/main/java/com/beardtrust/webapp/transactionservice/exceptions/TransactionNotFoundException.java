package com.beardtrust.webapp.transactionservice.exceptions;

public class TransactionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 7153122023145462495L;

	/**
	 * Instantiates a new IncorrectTransactionSpecializationException entry exception.
	 *
	 * @param msg String the associated error message
	 */
	public TransactionNotFoundException(String msg){
		super(msg);
	}
}
