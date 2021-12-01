package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.dtos.FinancialTransactionDTO;
import com.beardtrust.webapp.transactionservice.entities.*;
import com.beardtrust.webapp.transactionservice.exceptions.IncorrectTransactionSpecializationException;
import com.beardtrust.webapp.transactionservice.exceptions.TransactionNotFoundException;
import com.beardtrust.webapp.transactionservice.models.NewTransactionModel;
import com.beardtrust.webapp.transactionservice.models.TransactionSpecialization;
import com.beardtrust.webapp.transactionservice.models.UpdateTransactionModel;
import com.beardtrust.webapp.transactionservice.repos.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.GenericValidator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.apache.commons.lang3.math.NumberUtils.isCreatable;

/**
 * This class provides the implementation of the Transaction Service.
 *
 * @author Matthew.Crowell@Smoothstack.com
 */
@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final AccountTransactionRepository accountTransactionRepository;
    private final CardTransactionRepository cardTransactionRepository;
    private final FinancialAssetRepository financialAssetRepository;
    private final FinancialTransactionRepository financialTransactionRepository;
    private final LoanTransactionRepository loanTransactionRepository;
    private final TransactionStatusRepository transactionStatusRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final AccountRepository accountRepository;

    /**
     * This method accesses each transaction repository to check the application's
     * health and returns a String indicating the service is healthy or unhealthy.
     *
     * @return a String, "Healthy" or "Unhealthy"
     */
    @Override
    public String checkHealth() {
        StringBuilder healthStatus = new StringBuilder();
        Pageable page = PageRequest.of(0, 1);

        try {
            Page<FinancialTransaction> financialTransactions = financialTransactionRepository.findAll(page);
            Page<AccountTransaction> accountTransaction = accountTransactionRepository.findAll(page);
            Page<CardTransaction> cardTransactions = cardTransactionRepository.findAll(page);
            Page<LoanTransaction> loanTransactions = loanTransactionRepository.findAll(page);
            log.info("Health check completed with healthy status.");
            healthStatus.append("Healthy");
        } catch (Exception e) {
            log.debug("Exception encountered during health check:\n" + e.getMessage());
            healthStatus.append("Unhealthy");
        }


        return healthStatus.toString();
    }

    /**
     * This method retrieves a page of financial transactions from the database, converts
     * the financial transactions to financial transaction data transfer objects, and
     * returns the page of financial transaction data transfer objects.
     *
     * @param page a Pageable object to request a Page
     * @return a page of financial transaction DTOs
     */
    @Override
    public Page<FinancialTransactionDTO> getAllTransactions(Pageable page) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Page<FinancialTransactionDTO> financialTransactions = null;

        try {
            financialTransactions =
                    financialTransactionRepository.findAll(page).map((transaction) -> modelMapper.map(transaction,
                            FinancialTransactionDTO.class));

            log.info("Retrieved financial transactions");
        } catch (Exception e) {
            log.debug("Exception encountered while retrieving financial transactions:\n" +
                    e.getMessage());
        }


        return financialTransactions;
    }

    /**
     * This method retrieves a page of account transactions from the database, converts
     * the account transactions to financial transaction data transfer objects, and
     * returns the page of financial transaction data transfer objects.
     *
     * @param page a Pageable object to request a Page
     * @return a page of financial transaction DTOs
     */
    @Override
    public Page<FinancialTransactionDTO> getAccountTransactions(Pageable page) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Page<FinancialTransactionDTO> accountTransactions = null;

        try {
            accountTransactions = accountTransactionRepository.findAll(page)
                    .map(transaction -> modelMapper.map(transaction,
                            FinancialTransactionDTO.class));

            log.info("Retrieved account transactions");
        } catch (Exception e) {
            log.debug("Exception encountered while retrieving account transactions:\n" + e.getMessage());
        }


        return accountTransactions;
    }

    /**
     * This method retrieves a page of card transactions from the database, converts
     * the card transactions to financial transaction data transfer objects, and
     * returns the page of financial transaction data transfer objects.
     *
     * @param page a Pageable object to request a Page
     * @return a page of financial transaction DTOs
     */
    @Override
    public Page<FinancialTransactionDTO> getCardTransactions(Pageable page) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Page<FinancialTransactionDTO> cardTransactions = null;

        try {
            cardTransactions = cardTransactionRepository.findAll(page)
                    .map(transaction -> modelMapper.map(transaction,
                            FinancialTransactionDTO.class));

            log.info("Retrieved card transactions");
        } catch (Exception e) {
            log.debug("Exception encountered while retrieving card transactions:\n" + e.getMessage());
        }


        return cardTransactions;
    }

    /**
     * This method retrieves a page of loan transactions from the database, converts
     * the loan transactions to financial transaction data transfer objects, and
     * returns the page of financial transaction data transfer objects.
     *
     * @param page a Pageable object to request a Page
     * @return a page of financial transaction DTOs
     */
    @Override
    public Page<FinancialTransactionDTO> getLoanTransactions(Pageable page) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Page<FinancialTransactionDTO> loanTransactions = null;

        try {
            loanTransactions = loanTransactionRepository.findAll(page)
                    .map(transaction -> modelMapper.map(transaction, FinancialTransactionDTO.class));

            log.info("Retrieved loan transactions");
        } catch (Exception e) {
            log.debug("Exception encountered while retrieving loan transactions:\n" + e.getMessage());
        }

        return loanTransactions;
    }

    /**
     * This method takes a NewTransactionModel object, creates the specified transaction,
     * and saves the transaction to the database.
     *
     * @param transaction NewTransactionModel object containing the transaction details
     * @return FinancialTransactionDTO object for the created transaction
     */
    @Override
    public FinancialTransactionDTO createTransaction(NewTransactionModel transaction) {
        FinancialTransactionDTO result = null;
        try {
            switch (transaction.getTransactionSpecialization()) {
                case ACCOUNT:
                    log.debug("Calling TransactionService.createAccountTransaction(<redacted transaction details>)");
                    result = createAccountTransaction(transaction);
                    break;
                case CARD:
                    log.debug("Calling TransactionService.createCardTransaction(<redacted transaction details>)");
                    result = createCardTransaction(transaction);
                    break;
                case LOAN:
                    log.debug("Calling TransactionService.createLoanTransaction(<redacted transaction details>)");
                    result = createLoanTransaction(transaction);
                    break;
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }


        return result;
    }

    /**
     * This method takes an UpdateTransactionModel object and attempts to update
     * the specified transaction's notes, status, and status time.  It throws a
     * TransactionNotFoundException if the specified transaction cannot be located
     * in the database.
     *
     * @param transaction UpdateTransactionModel the entity containing updated data
     * @return FinancialTransactionDTO the DTO for the updated transaction
     */
    @Override
    public FinancialTransactionDTO updateTransaction(UpdateTransactionModel transaction) {
        FinancialTransactionDTO result = null;

        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            Optional<FinancialTransaction> updatedTransaction =
                    financialTransactionRepository.findById(transaction.getTransactionId());
            Optional<TransactionStatus> transactionStatus =
                    transactionStatusRepository.findByStatusName(transaction.getTransactionStatusName());

            if (updatedTransaction.isPresent() && transactionStatus.isPresent()) {
                updatedTransaction.get().setTransactionStatus(transactionStatus.get());
                updatedTransaction.get().setNotes(transaction.getNotes());
                updatedTransaction.get().setStatusTime(LocalDateTime.now());
                result = modelMapper.map(financialTransactionRepository.save(updatedTransaction.get()),
                        FinancialTransactionDTO.class);
            } else {
                throw new TransactionNotFoundException("Transaction update failed; transaction not found");
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }


        return result;
    }

    /**
     * This method takes two String arguments - the first being an asset's id and the second being
     * a string to search by - and a Pageable object and returns the requested page of transactions
     * associated with the provided asset id from the database.
     *
     * @param assetId String	the id of the associated asset
     * @param search  String	the string object to search the database for
     * @param page    Pageable	the pageable object with the requested page data
     * @return Page<FinancialTransactionDTO>	the requested page of transactions
     */
    @Override
    public Page<FinancialTransactionDTO> getTransactionsByAssetId(String assetId, String search, Pageable page) {
        Page<FinancialTransaction> transactions;
        Page<FinancialTransactionDTO> results = null;

        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            if (search == null) {
                log.debug("No search parameter provided");

                transactions =
                        financialTransactionRepository.findAllBySource_IdOrTarget_IdIs(assetId, assetId, page);
            } else if (isCreatable(search)) {
                log.info("Search criteria is a number");

                String[] values = new String[2];
                if (search.contains(".")) {
                    values = search.split("\\.");
                }
                CurrencyValue transactionAmount = new CurrencyValue();

                if (values.length == 2) {
                    log.info("Search criteria has two integer values");
                    transactionAmount.setDollars(Integer.parseInt(values[0]));
                    transactionAmount.setCents(Integer.parseInt(values[1]));
                } else {
                    log.info("Search criteria has one integer value");
                    transactionAmount.setCents(Integer.parseInt(search));
                }

                transactions =
                        financialTransactionRepository.findAllBySource_IdAndTransactionAmountOrTarget_IdAndTransactionAmount(assetId, transactionAmount, assetId, transactionAmount, page);
            } else if (GenericValidator.isDate(search, "yyyy-MM-dd", true)) {
                log.debug("Search criteria is a date");
                LocalDate searchDate = LocalDate.parse(search);

                LocalDateTime startDate = searchDate.atStartOfDay();
                LocalDateTime endDate = startDate.plusDays(1);

                transactions =
                        financialTransactionRepository.findAllBySource_IdAndStatusTimeBetweenOrTarget_IdAndStatusTimeBetween(assetId, startDate, endDate, assetId, startDate, endDate,
                                page);

            } else {
                log.debug("Search criteria is a string");
                transactions =
                        financialTransactionRepository.findAllBySource_IdAndTransactionStatus_StatusNameOrTarget_IdAndTransactionStatus_StatusNameOrSource_IdAndTarget_IdOrTarget_IdAndSource_IdOrSource_IdAndNotesContainsIgnoreCaseOrTarget_IdAndNotesContainsIgnoreCase(assetId, search, assetId, search, assetId, search, assetId, search, assetId, search, assetId, search, page);

            }

            results = transactions.map((transaction) -> modelMapper.map(transaction, FinancialTransactionDTO.class));
        } catch (Exception e) {
            log.warn(e.getMessage());
        }


        return results;
    }

    /**
     * This method takes a NewTransactionModel object with the desired transaction details
     * and returns a FinancialTransactionDTO object for the new account transaction.
     *
     * @param transaction NewTransactionModel object containing the transaction details
     * @return FinancialTransactionDTO object for the created transaction
     */
    private FinancialTransactionDTO createAccountTransaction(NewTransactionModel transaction) throws IncorrectTransactionSpecializationException {
        if (transaction.getTransactionSpecialization() != TransactionSpecialization.ACCOUNT) {
            throw new IncorrectTransactionSpecializationException("Unable to create AccountTransaction from " +
                    "NewTransactionModel with " + transaction.getTransactionSpecialization().toString() +
                    " specialization");
        }

        FinancialTransactionDTO result = null;

        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Optional<FinancialAsset> source;
            List<FinancialAsset> sources;
            Optional<FinancialAsset> target;
            List<FinancialAsset> targets;
            if (transaction.getSourceId().equals("Deposit")) {
                sources = accountRepository.findAllByType_IdAndBalance_DollarsGreaterThanAndBalance_IsNegativeIs("3", transaction.getAmount().getDollars(), false);
                source = financialAssetRepository.findById(sources.get(0).getId());
                for (int i = 0; i < sources.size(); i++) {
                    if (sources.get(i).getBalance().getDollars() > source.get().getBalance().getDollars()) {
                        source = financialAssetRepository.findById(sources.get(i).getId());
                    }
                }
            } else {
                source = financialAssetRepository.findById(transaction.getSourceId());
            }
            if (transaction.getTargetId().equals("Withdrawal")) {
                targets = accountRepository.findAllByType_IdAndBalance_DollarsGreaterThanAndBalance_IsNegativeIs("3", transaction.getAmount().getDollars(), false);
                target = financialAssetRepository.findById(targets.get(0).getId());
                for (int i = 0; i < targets.size(); i++) {
                    if (targets.get(i).getBalance().getDollars() > target.get().getBalance().getDollars()) {
                        target = financialAssetRepository.findById(targets.get(i).getId());
                    }
                }
            } else {
                target = financialAssetRepository.findById(transaction.getTargetId());
            }
            Optional<TransactionStatus> transactionStatus =
                    transactionStatusRepository.findByStatusName(transaction.getTransactionStatusName());
            Optional<TransactionType> transactionType = transactionTypeRepository.findByTypeName(transaction.getTransactionTypeName());

            AccountTransaction newTransaction = new AccountTransaction();

            try {
                newTransaction.setTransactionStatus(transactionStatusRepository.findByStatusId(2).get());
            } catch (Exception e) {
                log.warn("Error setting transaction status. Message:" + e.getMessage());
            }
            newTransaction.setId(UUID.randomUUID().toString());
            newTransaction.setStatusTime(LocalDateTime.now());
            newTransaction.setSource(source.orElse(null));
            newTransaction.setTarget(target.orElse(null));
            newTransaction.setTransactionStatus(transactionStatus.orElse(null));
            newTransaction.setTransactionType(transactionType.orElse(null));
            newTransaction.setTransactionAmount(transaction.getAmount());
            newTransaction.setNotes(transaction.getNotes());

            FinancialTransaction temp = processTransaction(newTransaction);

            AccountTransaction processedTransaction = modelMapper.map(temp, AccountTransaction.class);

            result = modelMapper.map(accountTransactionRepository.save(processedTransaction), FinancialTransactionDTO.class);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        System.out.println("Outbound result: " + result);
        return result;
    }

    /**
     * This method takes a NewTransactionModel object with the desired transaction details
     * and returns a FinancialTransactionDTO object for the new card transaction.
     *
     * @param transaction NewTransactionModel object containing the transaction details
     * @return FinancialTransactionDTO object for the created transaction
     */
    private FinancialTransactionDTO createCardTransaction(NewTransactionModel transaction) throws IncorrectTransactionSpecializationException {
        if (transaction.getTransactionSpecialization() != TransactionSpecialization.CARD) {
            throw new IncorrectTransactionSpecializationException("Unable to create CardTransaction from " +
                    "NewTransactionModel with " + transaction.getTransactionSpecialization().toString() +
                    " specialization");
        }
        FinancialTransactionDTO result = null;

        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            Optional<FinancialAsset> source = financialAssetRepository.findById(transaction.getSourceId());
            Optional<FinancialAsset> target = financialAssetRepository.findById(transaction.getTargetId());
            Optional<TransactionStatus> transactionStatus =
                    transactionStatusRepository.findByStatusName(transaction.getTransactionStatusName());
            Optional<TransactionType> transactionType = transactionTypeRepository.findByTypeName(transaction.getTransactionTypeName());

            CardTransaction newTransaction = new CardTransaction();

            try {
                newTransaction.setTransactionStatus(transactionStatusRepository.findByStatusId(2).get());
            } catch (Exception e) {
                log.warn("Error setting transaction status. Message:" + e.getMessage());
            }

            newTransaction.setId(UUID.randomUUID().toString());
            newTransaction.setStatusTime(LocalDateTime.now());
            newTransaction.setSource(source.orElse(null));
            newTransaction.setTarget(target.orElse(null));
            newTransaction.setTransactionStatus(transactionStatus.orElse(null));
            newTransaction.setTransactionType(transactionType.orElse(null));
            newTransaction.setTransactionAmount(transaction.getAmount());
            newTransaction.setNotes(transaction.getNotes());

            FinancialTransaction temp = processTransaction(newTransaction);

            CardTransaction processedTransaction = modelMapper.map(temp, CardTransaction.class);

            result = modelMapper.map(cardTransactionRepository.save(processedTransaction), FinancialTransactionDTO.class);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        return result;
    }

    /**
     * This method takes a NewTransactionModel object with the desired transaction details
     * and returns a FinancialTransactionDTO object for the new loan transaction.
     *
     * @param transaction NewTransactionModel object containing the transaction details
     * @return FinancialTransactionDTO object for the created transaction
     */
    private FinancialTransactionDTO createLoanTransaction(NewTransactionModel transaction) throws IncorrectTransactionSpecializationException {
        if (transaction.getTransactionSpecialization() != TransactionSpecialization.LOAN) {
            throw new IncorrectTransactionSpecializationException("Unable to create LoanTransaction from " +
                    "NewTransactionModel with " + transaction.getTransactionSpecialization().toString() +
                    " specialization");
        }
        FinancialTransactionDTO result = null;

        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

            Optional<FinancialAsset> source = financialAssetRepository.findById(transaction.getSourceId());
            Optional<FinancialAsset> target = financialAssetRepository.findById(transaction.getTargetId());
            Optional<TransactionStatus> transactionStatus =
                    transactionStatusRepository.findByStatusName(transaction.getTransactionStatusName());
            Optional<TransactionType> transactionType = transactionTypeRepository.findByTypeName(transaction.getTransactionTypeName());

            LoanTransaction newTransaction = new LoanTransaction();

            try {
                newTransaction.setTransactionStatus(transactionStatusRepository.findByStatusId(2).get());
            } catch (Exception e) {
                log.warn("Error setting transaction status. Message:" + e.getMessage());
            }

            newTransaction.setId(UUID.randomUUID().toString());
            newTransaction.setStatusTime(LocalDateTime.now());
            newTransaction.setSource(source.orElse(null));
            newTransaction.setTarget(target.orElse(null));
            newTransaction.setTransactionStatus(transactionStatus.orElse(null));
            newTransaction.setTransactionType(transactionType.orElse(null));
            newTransaction.setTransactionAmount(transaction.getAmount());
            newTransaction.setNotes(transaction.getNotes());

            FinancialTransaction temp = processTransaction(newTransaction);

            LoanTransaction processedTransaction = modelMapper.map(temp, LoanTransaction.class);

            result = modelMapper.map(loanTransactionRepository.save(processedTransaction), FinancialTransactionDTO.class);

        } catch (Exception e) {
            log.warn(e.getMessage());
        }

        return result;
    }

    private FinancialTransaction processTransaction(FinancialTransaction transaction) {
        log.trace("Process Transaction service start...");
        log.debug("Process Transaction redceived: " + transaction);
        FinancialTransaction result = transaction;

        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            Integer sourceBalance = (transaction.getSource().getBalance().getDollars() + transaction.getSource().getBalance().getCents() / 100);
            Integer targetBalance = (transaction.getTarget().getBalance().getDollars() + transaction.getTarget().getBalance().getCents() / 100);
            Integer amount = (transaction.getTransactionAmount().getDollars() + transaction.getTransactionAmount().getCents() / 100);
            log.info("target: " + transaction.getTarget());
            if (sourceBalance >= amount && amount <= targetBalance || transaction.getTransactionType().getTypeName().equals("Deposit")) {
                log.trace("Transaction resolved as acceptable");
                try {
                    result.setTransactionStatus(transactionStatusRepository.findByStatusId(3).get());
                } catch (Exception e) {
                    log.warn("Error setting transaction status. Message:" + e.getMessage());
                }
            } else {
                log.info("Transaction resolved as unacceptable");
                try {
                    result.setTransactionStatus(transactionStatusRepository.findByStatusId(1).get());
                    if (sourceBalance < amount) {
                        log.info("Transaction declined due to lack of funds.");
                        result.setNotes("You attempted to pay " + transaction.getTransactionAmount().toString() + " from a source with " + transaction.getSource().getBalance().toString() + ". Due to lack of funds, the transaction has been declined.");
                    }
                    if (amount > targetBalance && !transaction.getTransactionType().getTypeName().equals("Deposit")) {
                        log.info("Transaction declined due to overpayment.");
                        log.info("target balance: " + targetBalance);
                        result.setNotes("You attempted to pay " + transaction.getTransactionAmount().toString() + " towards a balance of " + transaction.getTarget().getBalance().toString() + ". This is greater than what was owed, so the transaction was declined.");
                    }
                } catch (Exception e) {
                    log.warn("Error setting transaction status. Message:" + e.getMessage());
                }
            }
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        log.trace("Transaction processor finished...");
        return result;

    }
}
