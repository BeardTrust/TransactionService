package com.beardtrust.webapp.transactionservice.repos;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import com.beardtrust.webapp.transactionservice.entities.LoanTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * This is the repository for Loan Transactions.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@Repository
public interface LoanTransactionRepository extends JpaRepository<LoanTransaction, String> {
	/**
	 * This method returns a Page of loan transactions where the source's id
	 * matches the sourceUserId argument or the target's id matches the
	 * targetUserId argument.
	 *
	 * @param sourceUserId the source's userId
	 * @param targetUserId the target's userId
	 * @param page         the pageable object defining the page request
	 * @return the requested page
	 */
	Page<LoanTransaction> findAllBySource_IdOrTarget_IdIs(String sourceUserId, String targetUserId,
														  Pageable page);

	/**
	 * This method returns a Page of loan transactions where the status date is
	 * between the specified local date times.
	 *
	 * @param startDate the earliest local date time to look for
	 * @param endDate   the latest local date time to look for
	 * @param page      the pageable object defining the page request
	 * @return the requested page
	 */
	Page<LoanTransaction> findAllByStatusTimeBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable page);

	/**
	 * This method returns a Page of loan transactions where the amount is equal
	 * to the currencyValue argument.
	 *
	 * @param currencyValue the amount to look for
	 * @param page          the pageable object defining the page request
	 * @return the requested page
	 */
	Page<LoanTransaction> findAllByTransactionAmountEquals(CurrencyValue currencyValue, Pageable page);

	/**
	 * This method returns a Page of loan transactions matching the given status,
	 * source, target, or notes.
	 *
	 * @param status   the status to match
	 * @param sourceId the source id to match
	 * @param targetId the target id to match
	 * @param notes    the notes to match
	 * @param page     the Pageable object defining the page request
	 * @return the requested page
	 */
	Page<LoanTransaction> findAllByTransactionStatus_StatusNameOrSource_IdOrTarget_IdEqualsOrNotesContainsIgnoreCase(String status,
																													 String sourceId,
																													 String targetId,
																													 String notes,
																													 Pageable page);
}