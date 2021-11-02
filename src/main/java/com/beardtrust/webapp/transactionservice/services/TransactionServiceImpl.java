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

	/**
	 * This method accesses each transaction repository to check the application's
	 * health and returns a String indicating the service is healthy or unhealthy.
	 *
	 * @return a String, "Healthy" or "Unhealthy"
	 */
	@Override
	public String checkHealth() {
		log.trace("Start of TransactionService.checkHealth()");

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

		log.trace("Start of TransactionService.checkHealth()");
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
		log.trace("Start of TransactionService.getAllTransactions(" + page + ")");

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

		log.trace("End of TransactionService.getAllTransactions(" + page + ")");
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
		log.trace("End of TransactionService.getAccountTransactions(" + page + ")");

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

		log.trace("End of TransactionService.getAccountTransactions(" + page + ")");
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
		log.trace("End of TransactionService.getCardTransactions(" + page + ")");

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

		log.trace("End of TransactionService.getCardTransactions(" + page + ")");
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
		log.trace("Start of TransactionService.getLoanTransactions(" + page + ")");

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		Page<FinancialTransactionDTO> loanTransactions = null;

		try {
			loanTransactions = loanTransactionRepository.findAll(page)
					.map(transaction -> modelMapper.map(transaction,
							FinancialTransactionDTO.class));

			log.info("Retrieved loan transactions");
		} catch (Exception e) {
			log.debug("Exception encountered while retrieving loan transactions:\n" + e.getMessage());
		}

		log.trace("End of TransactionService.getLoanTransactions(" + page + ")");
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
		log.trace("Start of TransactionService.createTransaction(<redacted transaction details>)");

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

		log.trace("End of TransactionService.createTransaction(<redacted transaction details>)");

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
		log.trace("Start of TransactionService.updateTransaction(<redacted transaction details>)");

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

		log.trace("End of TransactionService.updateTransaction(<redacted transaction details>)");
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
		log.trace("Start of TransactionService.getTransactionsByAssetId(<redacted request information>)");
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
				log.debug("Search criteria is a number");

				String[] values = search.split(",");
				CurrencyValue transactionAmount = new CurrencyValue();

				if (values.length == 2) {
					log.debug("Search criteria has two integer values");
					transactionAmount.setDollars(Integer.parseInt(values[0]));
					transactionAmount.setCents(Integer.parseInt(values[1]));
				} else {
					log.debug("Search criteria has one integer value");
					transactionAmount.setCents(Integer.parseInt(values[0]));
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


		log.trace("End of TransactionService.getTransactionsByAssetId(<redacted request information>)");

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
		log.trace("Start of TransactionService.createAccountTransaction(<redacted transaction details>)");
		if (transaction.getTransactionSpecialization() != TransactionSpecialization.ACCOUNT) {
			throw new IncorrectTransactionSpecializationException("Unable to create AccountTransaction from " +
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

			AccountTransaction newTransaction = new AccountTransaction();

			newTransaction.setId(UUID.randomUUID().toString());
			newTransaction.setStatusTime(LocalDateTime.now());
			newTransaction.setSource(source.orElse(null));
			newTransaction.setTarget(target.orElse(null));
			newTransaction.setTransactionStatus(transactionStatus.orElse(null));
			newTransaction.setTransactionType(transactionType.orElse(null));
			newTransaction.setTransactionAmount(transaction.getAmount());
			newTransaction.setNotes(transaction.getNotes());

			result = modelMapper.map(accountTransactionRepository.save(newTransaction), FinancialTransactionDTO.class);
		} catch (Exception e) {
			log.warn(e.getMessage());
		}

		log.trace("End of TransactionService.createAccountTransaction(<redacted transaction details>)");

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
		log.trace("Start of TransactionService.createCardTransaction(<redacted transaction details>)");
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

			newTransaction.setId(UUID.randomUUID().toString());
			newTransaction.setStatusTime(LocalDateTime.now());
			newTransaction.setSource(source.orElse(null));
			newTransaction.setTarget(target.orElse(null));
			newTransaction.setTransactionStatus(transactionStatus.orElse(null));
			newTransaction.setTransactionType(transactionType.orElse(null));
			newTransaction.setTransactionAmount(transaction.getAmount());
			newTransaction.setNotes(transaction.getNotes());

			result = modelMapper.map(cardTransactionRepository.save(newTransaction), FinancialTransactionDTO.class);
		} catch (Exception e) {
			log.warn(e.getMessage());
		}

		log.trace("End of TransactionService.createCardTransaction(<redacted transaction details>)");

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
		log.trace("Start of TransactionService.createCardTransaction(<redacted transaction details>)");

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

			newTransaction.setId(UUID.randomUUID().toString());
			newTransaction.setStatusTime(LocalDateTime.now());
			newTransaction.setSource(source.orElse(null));
			newTransaction.setTarget(target.orElse(null));
			newTransaction.setTransactionStatus(transactionStatus.orElse(null));
			newTransaction.setTransactionType(transactionType.orElse(null));
			newTransaction.setTransactionAmount(transaction.getAmount());
			newTransaction.setNotes(transaction.getNotes());

			result = modelMapper.map(loanTransactionRepository.save(newTransaction), FinancialTransactionDTO.class);
		} catch (Exception e) {
			log.warn(e.getMessage());
		}

		log.trace("End of TransactionService.createLoanTransaction(<redacted transaction details>)");

		return result;
	}
}
