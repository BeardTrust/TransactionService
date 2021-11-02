package com.beardtrust.webapp.transactionservice.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateTransactionModel {
	String transactionId;
	String transactionStatusName;
	String notes;
}

