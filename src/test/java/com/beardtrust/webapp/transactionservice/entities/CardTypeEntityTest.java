package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CardTypeEntityTest {
	@Test
	void testConstructor() {
		CardTypeEntity actualCardTypeEntity = new CardTypeEntity();
		actualCardTypeEntity.setAvailable(true);
		actualCardTypeEntity.setBaseInterestRate(10.0);
		actualCardTypeEntity.setDescription("The characteristics of someone or something");
		actualCardTypeEntity.setId("42");
		actualCardTypeEntity.setPreviewURL("https://example.org/example");
		actualCardTypeEntity.setTypeName("Type Name");
		assertTrue(actualCardTypeEntity.getAvailable());
		assertEquals(10.0, actualCardTypeEntity.getBaseInterestRate().doubleValue());
		assertEquals("The characteristics of someone or something", actualCardTypeEntity.getDescription());
		assertEquals("42", actualCardTypeEntity.getId());
		assertEquals("https://example.org/example", actualCardTypeEntity.getPreviewURL());
		assertEquals("Type Name", actualCardTypeEntity.getTypeName());
		assertEquals("Type Name", actualCardTypeEntity.toString());
	}

	@Test
	void testConstructor2() {
		CardTypeEntity actualCardTypeEntity = new CardTypeEntity("42", "Type Name", 10.0);
		actualCardTypeEntity.setAvailable(true);
		actualCardTypeEntity.setBaseInterestRate(10.0);
		actualCardTypeEntity.setDescription("The characteristics of someone or something");
		actualCardTypeEntity.setId("42");
		actualCardTypeEntity.setPreviewURL("https://example.org/example");
		actualCardTypeEntity.setTypeName("Type Name");
		assertTrue(actualCardTypeEntity.getAvailable());
		assertEquals(10.0, actualCardTypeEntity.getBaseInterestRate().doubleValue());
		assertEquals("The characteristics of someone or something", actualCardTypeEntity.getDescription());
		assertEquals("42", actualCardTypeEntity.getId());
		assertEquals("https://example.org/example", actualCardTypeEntity.getPreviewURL());
		assertEquals("Type Name", actualCardTypeEntity.getTypeName());
		assertEquals("Type Name", actualCardTypeEntity.toString());
	}
}

