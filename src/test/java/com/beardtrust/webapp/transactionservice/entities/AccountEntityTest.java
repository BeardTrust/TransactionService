package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class AccountEntityTest {
	@Test
	void testConstructor() {
		AccountEntity actualAccountEntity = new AccountEntity();
		actualAccountEntity.setInterest(1);
		actualAccountEntity.setNickname("Nickname");
		AccountTypeEntity accountTypeEntity = new AccountTypeEntity();
		accountTypeEntity.setCreatedDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setExpireDate(LocalDateTime.of(1, 1, 1, 1, 1));
		accountTypeEntity.setId("42");
		accountTypeEntity.setAccounts(new HashSet<AccountEntity>());
		accountTypeEntity.setName("Name");
		accountTypeEntity.setActive(true);
		accountTypeEntity.setDescription("The characteristics of someone or something");
		actualAccountEntity.setType(accountTypeEntity);
		assertEquals(1, actualAccountEntity.getInterest().intValue());
		assertEquals("Nickname", actualAccountEntity.getNickname());
		assertSame(accountTypeEntity, actualAccountEntity.getType());
	}
}

