package com.beardtrust.webapp.transactionservice.dtos;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import com.beardtrust.webapp.transactionservice.entities.FinancialAsset;
import com.beardtrust.webapp.transactionservice.entities.TransactionStatus;
import com.beardtrust.webapp.transactionservice.entities.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * This is the Data Transfer Object for Financial Transactions.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialTransactionDTO {
	String id;
	CurrencyValue transactionAmount;
	TransactionStatus transactionStatus;
	FinancialAsset source;
	FinancialAsset target;
	TransactionType transactionType;
	String notes;
	LocalDateTime statusTime;
}
