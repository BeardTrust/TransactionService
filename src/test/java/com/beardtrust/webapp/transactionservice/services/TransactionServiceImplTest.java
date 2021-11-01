package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.entities.*;
import com.beardtrust.webapp.transactionservice.models.NewTransactionModel;
import com.beardtrust.webapp.transactionservice.models.TransactionSpecialization;
import com.beardtrust.webapp.transactionservice.repos.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TransactionServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class TransactionServiceImplTest {

	private NewTransactionModel mockTransactionModel;
	private UserEntity mockUser;
	private AccountEntity mockAccount;
	private CardEntity mockCard;

	@MockBean
	private AccountTransactionRepository accountTransactionRepository;

	@MockBean
	private CardTransactionRepository cardTransactionRepository;

	@MockBean
	private FinancialAssetRepository financialAssetRepository;

	@MockBean
	private FinancialTransactionRepository financialTransactionRepository;

	@MockBean
	private LoanTransactionRepository loanTransactionRepository;

	@Autowired
	private TransactionServiceImpl transactionServiceImpl;

	@MockBean
	private TransactionStatusRepository transactionStatusRepository;

	@MockBean
	private TransactionTypeRepository transactionTypeRepository;

	@Test
	void testCheckHealth() {
		assertEquals("Healthy", this.transactionServiceImpl.checkHealth());
	}

	@BeforeEach
	void createTransaction(){
		this.mockTransactionModel = NewTransactionModel.builder()
				.transactionStatusName("Pending")
				.amount(new CurrencyValue(9, 99))
				.notes("Work middle middle middle paid")
				.sourceId("ABC-123")
				.targetId("123-ABC")
				.transactionSpecialization(TransactionSpecialization.ACCOUNT)
				.transactionTypeName("Deposit")
				.build();
	}

	@BeforeEach
	void createUser(){
		this.mockUser = new UserEntity();
		mockUser.setUserId("ABC-123-S37-M3F-R33");
		mockUser.setDateOfBirth(LocalDate.now());
		mockUser.setEmail("fake@email.com");
		mockUser.setPhone("1234567890");
		mockUser.setUsername("351LD34D");
		mockUser.setFirstName("Mock");
		mockUser.setLastName("User");
		mockUser.setRole("user");
		mockUser.setPassword("Test!123");
	}

	@BeforeEach
	void createAccount(){
		// TODO: finish creating account object.
		this.mockAccount = new AccountEntity();
		this.mockAccount.setInterest(4);
		this.mockAccount.setNickname("MockAccount");
//		this.mockAccount.setType();
//		this.mockAccount.setCreateDate();
//		this.mockAccount.setActiveStatus();
//		this.mockAccount.setBalance();
//		this.mockAccount.setId();
//		this.mockAccount.setUser();
	}

	@Test
	void testCreateAccountTransaction() {
		when(this.accountTransactionRepository.save(ArgumentMatchers.any())).thenReturn("");
		var results = this.transactionServiceImpl.createTransaction(mockTransactionModel);
		System.out.println(mockTransactionModel);
		System.out.println(mockUser);
		System.out.println(results);
		assertNull(results);
	}
}
