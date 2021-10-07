package com.beardtrust.webapp.transactionservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class represents transactions related to a BeardTrust account.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@Entity
@Table(name = "account_transactions")
public class AccountTransaction extends FinancialTransaction{
	private static final long serialVersionUID = 4628434455108292689L;
}
