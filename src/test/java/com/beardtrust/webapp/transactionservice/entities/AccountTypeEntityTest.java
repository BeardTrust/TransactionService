package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class AccountTypeEntityTest {
	@Test
	void testConstructor() {
		AccountTypeEntity actualAccountTypeEntity = new AccountTypeEntity();
		HashSet<AccountEntity> accountEntitySet = new HashSet<AccountEntity>();
		actualAccountTypeEntity.setAccounts(accountEntitySet);
		actualAccountTypeEntity.setActive(true);
		LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
		actualAccountTypeEntity.setCreatedDate(ofResult);
		actualAccountTypeEntity.setDescription("The characteristics of someone or something");
		LocalDateTime ofResult1 = LocalDateTime.of(1, 1, 1, 1, 1);
		actualAccountTypeEntity.setExpireDate(ofResult1);
		actualAccountTypeEntity.setId("42");
		actualAccountTypeEntity.setName("Name");
		assertSame(accountEntitySet, actualAccountTypeEntity.getAccounts());
		assertSame(ofResult, actualAccountTypeEntity.getCreatedDate());
		assertEquals("The characteristics of someone or something", actualAccountTypeEntity.getDescription());
		assertSame(ofResult1, actualAccountTypeEntity.getExpireDate());
		assertEquals("42", actualAccountTypeEntity.getId());
		assertEquals("Name", actualAccountTypeEntity.getName());
		assertTrue(actualAccountTypeEntity.isActive());
		assertEquals("Name: The characteristics of someone or something", actualAccountTypeEntity.toString());
	}

	@Test
	void testConstructor2() {
		LocalDateTime createdDate = LocalDateTime.of(1, 1, 1, 1, 1);
		AccountTypeEntity actualAccountTypeEntity = new AccountTypeEntity("Name",
				"The characteristics of someone or something", true, createdDate, LocalDateTime.of(1, 1, 1, 1, 1));

		assertTrue(actualAccountTypeEntity.getAccounts().isEmpty());
		assertTrue(actualAccountTypeEntity.isActive());
		assertEquals("Name", actualAccountTypeEntity.getName());
		assertEquals("The characteristics of someone or something", actualAccountTypeEntity.getDescription());
		assertEquals("01:01", actualAccountTypeEntity.getExpireDate().toLocalTime().toString());
		assertEquals("0001-01-01", actualAccountTypeEntity.getCreatedDate().toLocalDate().toString());
	}

	@Test
	void testEquals() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(null));
	}

	@Test
	void testEquals2() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals("Different type to AccountTypeEntity"));
	}

	@Test
	void testEquals3() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");
		assertTrue(accountTypeEntity.equals(accountTypeEntity));
		int expectedHashCodeResult = accountTypeEntity.hashCode();
		assertEquals(expectedHashCodeResult, accountTypeEntity.hashCode());
	}

	@Test
	void testEquals4() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertTrue(accountTypeEntity.equals(accountTypeEntity1));
		int expectedHashCodeResult = accountTypeEntity.hashCode();
		assertEquals(expectedHashCodeResult, accountTypeEntity1.hashCode());
	}

	@Test
	void testEquals5() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(0, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(accountTypeEntity1));
	}

	@Test
	void testEquals6() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(0, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(accountTypeEntity1));
	}

	@Test
	void testEquals7() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId(null);
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(accountTypeEntity1));
	}

	@Test
	void testEquals8() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUserId("42");
		userEntity.setUsername("janedoe");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(0);
		currencyValue.setCents(0);
		currencyValue.setNegative(true);

		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setUser(userEntity);
		accountEntity.setInterest(0);
		accountEntity.setNickname("Nickname");
		accountEntity.setBalance(currencyValue);
		accountEntity.setId("42");
		accountEntity.setType(accountTypeEntity);
		accountEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountEntity.setActiveStatus(true);

		HashSet<AccountEntity> accountEntitySet = new HashSet<AccountEntity>();
		accountEntitySet.add(accountEntity);

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(accountEntitySet);
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity2 = new AccountTypeEntity();
		accountTypeEntity2.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity2.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity2.setId("42");
		accountTypeEntity2.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity2.setName("Name");
		accountTypeEntity2.setActive(true);
		accountTypeEntity2.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity1.equals(accountTypeEntity2));
	}

	@Test
	void testEquals9() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName(null);
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(accountTypeEntity1));
	}

	@Test
	void testEquals10() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(false);
		accountTypeEntity.setDescription("The characteristics of someone or something");

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(accountTypeEntity1));
	}

	@Test
	void testEquals11() {
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription(null);

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertFalse(accountTypeEntity.equals(accountTypeEntity1));
	}

	@Test
	void testCompareTo() {
		LocalDateTime createdDate = LocalDateTime.of(1, 1, 1, 1, 1);
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity("Name", "The characteristics of someone or something",
				true, createdDate, LocalDateTime.of(1, 1, 1, 1, 1));

		AccountTypeEntity accountTypeEntity1 = new AccountTypeEntity();
		accountTypeEntity1.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity1.setId("42");
		accountTypeEntity1.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity1.setName("Name");
		accountTypeEntity1.setActive(true);
		accountTypeEntity1.setDescription("The characteristics of someone or something");
		assertEquals(0, accountTypeEntity.compareTo(accountTypeEntity1));
	}
}

