package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class CardEntityTest {
	@Test
	void testConstructor() {
		CardEntity actualCardEntity = new CardEntity();
		actualCardEntity.setBillCycleLength(1);
		actualCardEntity.setCardNumber("42");
		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");
		actualCardEntity.setCardType(cardTypeEntity);
		LocalDateTime ofResult = LocalDateTime.of(1, 1, 1, 1, 1);
		actualCardEntity.setExpireDate(ofResult);
		actualCardEntity.setInterestRate(10.0);
		actualCardEntity.setNickname("Nickname");
		assertEquals(1, actualCardEntity.getBillCycleLength());
		assertEquals("42", actualCardEntity.getCardNumber());
		assertSame(cardTypeEntity, actualCardEntity.getCardType());
		assertSame(ofResult, actualCardEntity.getExpireDate());
		assertEquals(10.0, actualCardEntity.getInterestRate());
		assertEquals("Nickname", actualCardEntity.getNickname());
		assertEquals("42", actualCardEntity.toString());
	}

	@Test
	void testEquals() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname("Nickname");
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(1);
		cardEntity.setInterestRate(10.0);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);
		assertFalse(cardEntity.equals(null));
	}

	@Test
	void testEquals2() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname("Nickname");
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(1);
		cardEntity.setInterestRate(10.0);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);
		assertFalse(cardEntity.equals("Different type to CardEntity"));
	}

	@Test
	void testEquals3() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname("Nickname");
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(1);
		cardEntity.setInterestRate(10.0);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);
		assertTrue(cardEntity.equals(cardEntity));
		int expectedHashCodeResult = cardEntity.hashCode();
		assertEquals(expectedHashCodeResult, cardEntity.hashCode());
	}

	@Test
	void testEquals4() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname("Nickname");
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(1);
		cardEntity.setInterestRate(10.0);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);

		UserEntity userEntity1 = new UserEntity();
		userEntity1.setLastName("Doe");
		userEntity1.setPassword("iloveyou");
		userEntity1.setEmail("jane.doe@example.org");
		userEntity1.setRole("Role");
		userEntity1.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity1.setUsername("janedoe");
		userEntity1.setId("42");
		userEntity1.setPhone("4105551212");
		userEntity1.setFirstName("Jane");

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);

		CardTypeEntity cardTypeEntity1 = new CardTypeEntity();
		cardTypeEntity1.setBaseInterestRate(10.0);
		cardTypeEntity1.setAvailable(true);
		cardTypeEntity1.setId("42");
		cardTypeEntity1.setTypeName("Type Name");
		cardTypeEntity1.setDescription("The characteristics of someone or something");
		cardTypeEntity1.setPreviewURL("https://example.org/example");

		CardEntity cardEntity1 = new CardEntity();
		cardEntity1.setUser(userEntity1);
		cardEntity1.setNickname("Nickname");
		cardEntity1.setBalance(currencyValue1);
		cardEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardType(cardTypeEntity1);
		cardEntity1.setId("42");
		cardEntity1.setBillCycleLength(1);
		cardEntity1.setInterestRate(10.0);
		cardEntity1.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardNumber("42");
		cardEntity1.setActiveStatus(true);
		assertFalse(cardEntity.equals(cardEntity1));
	}

	@Test
	void testEquals5() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname(null);
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(1);
		cardEntity.setInterestRate(10.0);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);

		UserEntity userEntity1 = new UserEntity();
		userEntity1.setLastName("Doe");
		userEntity1.setPassword("iloveyou");
		userEntity1.setEmail("jane.doe@example.org");
		userEntity1.setRole("Role");
		userEntity1.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity1.setUsername("janedoe");
		userEntity1.setId("42");
		userEntity1.setPhone("4105551212");
		userEntity1.setFirstName("Jane");

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);

		CardTypeEntity cardTypeEntity1 = new CardTypeEntity();
		cardTypeEntity1.setBaseInterestRate(10.0);
		cardTypeEntity1.setAvailable(true);
		cardTypeEntity1.setId("42");
		cardTypeEntity1.setTypeName("Type Name");
		cardTypeEntity1.setDescription("The characteristics of someone or something");
		cardTypeEntity1.setPreviewURL("https://example.org/example");

		CardEntity cardEntity1 = new CardEntity();
		cardEntity1.setUser(userEntity1);
		cardEntity1.setNickname("Nickname");
		cardEntity1.setBalance(currencyValue1);
		cardEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardType(cardTypeEntity1);
		cardEntity1.setId("42");
		cardEntity1.setBillCycleLength(1);
		cardEntity1.setInterestRate(10.0);
		cardEntity1.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardNumber("42");
		cardEntity1.setActiveStatus(true);
		assertFalse(cardEntity.equals(cardEntity1));
	}

	@Test
	void testEquals6() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname("Nickname");
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(0);
		cardEntity.setInterestRate(10.0);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);

		UserEntity userEntity1 = new UserEntity();
		userEntity1.setLastName("Doe");
		userEntity1.setPassword("iloveyou");
		userEntity1.setEmail("jane.doe@example.org");
		userEntity1.setRole("Role");
		userEntity1.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity1.setUsername("janedoe");
		userEntity1.setId("42");
		userEntity1.setPhone("4105551212");
		userEntity1.setFirstName("Jane");

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);

		CardTypeEntity cardTypeEntity1 = new CardTypeEntity();
		cardTypeEntity1.setBaseInterestRate(10.0);
		cardTypeEntity1.setAvailable(true);
		cardTypeEntity1.setId("42");
		cardTypeEntity1.setTypeName("Type Name");
		cardTypeEntity1.setDescription("The characteristics of someone or something");
		cardTypeEntity1.setPreviewURL("https://example.org/example");

		CardEntity cardEntity1 = new CardEntity();
		cardEntity1.setUser(userEntity1);
		cardEntity1.setNickname("Nickname");
		cardEntity1.setBalance(currencyValue1);
		cardEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardType(cardTypeEntity1);
		cardEntity1.setId("42");
		cardEntity1.setBillCycleLength(1);
		cardEntity1.setInterestRate(10.0);
		cardEntity1.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardNumber("42");
		cardEntity1.setActiveStatus(true);
		assertFalse(cardEntity.equals(cardEntity1));
	}

	@Test
	void testEquals7() {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CardTypeEntity cardTypeEntity = new CardTypeEntity();
		cardTypeEntity.setBaseInterestRate(10.0);
		cardTypeEntity.setAvailable(true);
		cardTypeEntity.setId("42");
		cardTypeEntity.setTypeName("Type Name");
		cardTypeEntity.setDescription("The characteristics of someone or something");
		cardTypeEntity.setPreviewURL("https://example.org/example");

		CardEntity cardEntity = new CardEntity();
		cardEntity.setUser(userEntity);
		cardEntity.setNickname("Nickname");
		cardEntity.setBalance(currencyValue);
		cardEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardType(cardTypeEntity);
		cardEntity.setId("42");
		cardEntity.setBillCycleLength(1);
		cardEntity.setInterestRate(0.5);
		cardEntity.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity.setCardNumber("42");
		cardEntity.setActiveStatus(true);

		UserEntity userEntity1 = new UserEntity();
		userEntity1.setLastName("Doe");
		userEntity1.setPassword("iloveyou");
		userEntity1.setEmail("jane.doe@example.org");
		userEntity1.setRole("Role");
		userEntity1.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity1.setUsername("janedoe");
		userEntity1.setId("42");
		userEntity1.setPhone("4105551212");
		userEntity1.setFirstName("Jane");

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);

		CardTypeEntity cardTypeEntity1 = new CardTypeEntity();
		cardTypeEntity1.setBaseInterestRate(10.0);
		cardTypeEntity1.setAvailable(true);
		cardTypeEntity1.setId("42");
		cardTypeEntity1.setTypeName("Type Name");
		cardTypeEntity1.setDescription("The characteristics of someone or something");
		cardTypeEntity1.setPreviewURL("https://example.org/example");

		CardEntity cardEntity1 = new CardEntity();
		cardEntity1.setUser(userEntity1);
		cardEntity1.setNickname("Nickname");
		cardEntity1.setBalance(currencyValue1);
		cardEntity1.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardType(cardTypeEntity1);
		cardEntity1.setId("42");
		cardEntity1.setBillCycleLength(1);
		cardEntity1.setInterestRate(10.0);
		cardEntity1.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
		cardEntity1.setCardNumber("42");
		cardEntity1.setActiveStatus(true);
		assertFalse(cardEntity.equals(cardEntity1));
	}
}

