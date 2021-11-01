package com.beardtrust.webapp.transactionservice.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.beardtrust.webapp.transactionservice.entities.CurrencyValue;
import com.beardtrust.webapp.transactionservice.entities.UserEntity;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class AccountDTOTest {
	@Test
	void testCanEqual() {
		assertFalse((new AccountDTO()).canEqual("Other"));
	}

	@Test
	void testCanEqual2() {
		AccountDTO accountDTO = new AccountDTO();

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

		AccountDTO accountDTO1 = new AccountDTO();
		accountDTO1.setUser(userEntity);
		accountDTO1.setBalance(currencyValue);
		accountDTO1.setInterest(0);
		accountDTO1.setNickname("Nickname");
		accountDTO1.setCreateDate(LocalDate.ofEpochDay(1L));
		accountDTO1.setId("42");
		accountDTO1.setType("Type");
		accountDTO1.setActiveStatus(true);
		assertTrue(accountDTO.canEqual(accountDTO1));
	}

	@Test
	void testConstructor() {
		AccountDTO actualAccountDTO = new AccountDTO();
		actualAccountDTO.setActiveStatus(true);
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);
		actualAccountDTO.setBalance(currencyValue);
		LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
		actualAccountDTO.setCreateDate(ofEpochDayResult);
		actualAccountDTO.setId("42");
		actualAccountDTO.setInterest(1);
		actualAccountDTO.setNickname("Nickname");
		actualAccountDTO.setType("Type");
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
		actualAccountDTO.setUser(userEntity);
		assertSame(currencyValue, actualAccountDTO.getBalance());
		assertSame(ofEpochDayResult, actualAccountDTO.getCreateDate());
		assertEquals("42", actualAccountDTO.getId());
		assertEquals(1, actualAccountDTO.getInterest().intValue());
		assertEquals("Nickname", actualAccountDTO.getNickname());
		assertEquals("Type", actualAccountDTO.getType());
		assertSame(userEntity, actualAccountDTO.getUser());
		assertTrue(actualAccountDTO.isActiveStatus());
		assertEquals("AccountDTO(user=UserEntity{userId='42', username='janedoe', password='iloveyou', email='jane.doe"
				+ "@example.org', phone='4105551212', firstName='Jane', lastName='Doe', dateOfBirth=1970-01-02, role='Role'},"
				+ " id=42, activeStatus=true, balance=-$1.01, interest=1, nickname=Nickname, createDate=1970-01-02,"
				+ " type=Type)", actualAccountDTO.toString());
	}

	@Test
	void testEquals() {
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
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUser(userEntity);
		accountDTO.setBalance(currencyValue);
		accountDTO.setInterest(1);
		accountDTO.setNickname("Nickname");
		accountDTO.setCreateDate(LocalDate.ofEpochDay(1L));
		accountDTO.setId("42");
		accountDTO.setType("Type");
		accountDTO.setActiveStatus(true);
		assertFalse(accountDTO.equals(null));
	}

	@Test
	void testEquals2() {
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
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUser(userEntity);
		accountDTO.setBalance(currencyValue);
		accountDTO.setInterest(1);
		accountDTO.setNickname("Nickname");
		accountDTO.setCreateDate(LocalDate.ofEpochDay(1L));
		accountDTO.setId("42");
		accountDTO.setType("Type");
		accountDTO.setActiveStatus(true);
		assertFalse(accountDTO.equals("Different type to AccountDTO"));
	}

	@Test
	void testEquals3() {
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
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUser(userEntity);
		accountDTO.setBalance(currencyValue);
		accountDTO.setInterest(1);
		accountDTO.setNickname("Nickname");
		accountDTO.setCreateDate(LocalDate.ofEpochDay(1L));
		accountDTO.setId("42");
		accountDTO.setType("Type");
		accountDTO.setActiveStatus(true);
		assertTrue(accountDTO.equals(accountDTO));
		int expectedHashCodeResult = accountDTO.hashCode();
		assertEquals(expectedHashCodeResult, accountDTO.hashCode());
	}

	@Test
	void testEquals4() {
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
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setUser(userEntity);
		accountDTO.setBalance(currencyValue);
		accountDTO.setInterest(1);
		accountDTO.setNickname("Nickname");
		accountDTO.setCreateDate(LocalDate.ofEpochDay(1L));
		accountDTO.setId("42");
		accountDTO.setType("Type");
		accountDTO.setActiveStatus(true);

		UserEntity userEntity1 = new UserEntity();
		userEntity1.setLastName("Doe");
		userEntity1.setPassword("iloveyou");
		userEntity1.setEmail("jane.doe@example.org");
		userEntity1.setRole("Role");
		userEntity1.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity1.setUserId("42");
		userEntity1.setUsername("janedoe");
		userEntity1.setPhone("4105551212");
		userEntity1.setFirstName("Jane");

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);

		AccountDTO accountDTO1 = new AccountDTO();
		accountDTO1.setUser(userEntity1);
		accountDTO1.setBalance(currencyValue1);
		accountDTO1.setInterest(1);
		accountDTO1.setNickname("Nickname");
		accountDTO1.setCreateDate(LocalDate.ofEpochDay(1L));
		accountDTO1.setId("42");
		accountDTO1.setType("Type");
		accountDTO1.setActiveStatus(true);
		assertTrue(accountDTO.equals(accountDTO1));
		int expectedHashCodeResult = accountDTO.hashCode();
		assertEquals(expectedHashCodeResult, accountDTO1.hashCode());
	}
}

