package com.beardtrust.webapp.transactionservice.models;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewTransactionModel {
	TransactionSpecialization transactionSpecialization;
	CurrencyValue amount;
	String transactionStatusName;
	String sourceId;
	String targetId;
	String transactionTypeName;
	String notes;
}
