package com.beardtrust.webapp.transactionservice.repos;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import com.beardtrust.webapp.transactionservice.entities.FinancialTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

/**
 * This is the repository for Financial Transactions.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@Repository
public interface FinancialTransactionRepository extends JpaRepository<FinancialTransaction, String> {
    /**
     * This method returns a Page of financial transactions where the source's id
     * matches the sourceUserId argument or the target's id matches the
     * targetUserId argument.
     *
     * @param sourceUserId the source's userId
     * @param targetUserId the target's userId
     * @param page         the pageable object defining the page request
     * @return the requested page
     */
    Page<FinancialTransaction> findAllBySource_IdOrTarget_IdIs(String sourceUserId, String targetUserId,
                                                               Pageable page);

    /**
     * This method returns a Page of financial transactions where the status date is
     * between the specified local date times.
     *
     * @param startDate the earliest local date time to look for
     * @param endDate   the latest local date time to look for
     * @param page      the pageable object defining the page request
     * @return the requested page
     */
    Page<FinancialTransaction> findAllByStatusTimeBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable page);

    /**
     * This method returns a Page of financial transactions where the amount is equal
     * to the currencyValue argument.
     *
     * @param currencyValue the amount to look for
     * @param page          the pageable object defining the page request
     * @return the requested page
     */
    Page<FinancialTransaction> findAllByTransactionAmountEquals(CurrencyValue currencyValue, Pageable page);

    /**
     * This method returns a Page of financial transactions matching the given status,
     * source, target, or notes.
     *
     * @param status   the status to match
     * @param sourceId the source id to match
     * @param targetId the target id to match
     * @param notes    the notes to match
     * @param page     the Pageable object defining the page request
     * @return the requested page
     */
    Page<FinancialTransaction> findAllByTransactionStatus_StatusNameOrSource_IdOrTarget_IdEqualsOrNotesContainsIgnoreCase(String status,
                                                                                                                          String sourceId,
                                                                                                                          String targetId,
                                                                                                                          String notes,
                                                                                                                          Pageable page);

    Page<FinancialTransaction> findAllBySource_IdAndStatusTimeBetweenOrTarget_IdAndStatusTimeBetween(String assetId1,
                                                                                                     LocalDateTime startDate1,
                                                                                                     LocalDateTime endDate1,
                                                                                                     String assetId2,
                                                                                                     LocalDateTime startDate2,
                                                                                                     LocalDateTime endDate2,
                                                                                                     Pageable page);

    Page<FinancialTransaction> findAllBySource_IdAndTransactionAmountOrTarget_IdAndTransactionAmount(String assetId,
                                                                                                     CurrencyValue transactionAmount,
                                                                                                     String assetId1,
                                                                                                     CurrencyValue transactionAmount1,
                                                                                                     Pageable page);

    Page<FinancialTransaction> findAllBySource_IdAndTransactionStatus_StatusNameOrTarget_IdAndTransactionStatus_StatusNameOrSource_IdAndTarget_IdOrTarget_IdAndSource_IdOrSource_IdAndNotesContainsIgnoreCaseOrTarget_IdAndNotesContainsIgnoreCase(String source_id, String transactionStatus_statusName, String target_id, String transactionStatus_statusName2, String source_id2, String target_id2, String target_id3, String source_id3, String source_id4, String notes, String target_id4, String notes2, Pageable pageable);

    Page<FinancialTransaction> findAllBySource_IdAndTransactionAmount_DollarsOrTransactionAmount_CentsOrTarget_IdAndTransactionAmount(String assetId, Integer search, Integer search1, String assetId1, CurrencyValue transactionAmount, Pageable page);
}
