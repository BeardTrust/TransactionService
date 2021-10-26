package com.beardtrust.webapp.transactionservice.exceptions;

public class IncorrectTransactionSpecializationException extends RuntimeException{
	private static final long serialVersionUID = 660414964533244247L;
	/**
	 * Instantiates a new IncorrectTransactionSpecializationException entry exception.
	 *
	 * @param msg String the associated error message
	 */
	public IncorrectTransactionSpecializationException(String msg){
		super(msg);
	}
}
