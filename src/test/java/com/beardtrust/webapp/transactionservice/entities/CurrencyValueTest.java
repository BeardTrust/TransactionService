package com.beardtrust.webapp.transactionservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CurrencyValueTest {
	@Test
	void testConstructor() {
		CurrencyValue actualCurrencyValue = new CurrencyValue();
		actualCurrencyValue.setNegative(true);
		assertEquals(0, actualCurrencyValue.getCents());
		assertEquals(0, actualCurrencyValue.getDollars());
		assertTrue(actualCurrencyValue.isNegative());
	}

	@Test
	void testConstructor10() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(new CurrencyValue(true, 1, 1));
		assertEquals(1, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor11() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(Integer.MIN_VALUE, 2);
		CurrencyValue actualCurrencyValue = new CurrencyValue(currencyValue);
		assertEquals(2, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(Integer.MIN_VALUE, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor12() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setCents(Integer.MIN_VALUE);
		CurrencyValue actualCurrencyValue = new CurrencyValue(currencyValue);
		assertEquals(48, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(21474836, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor13() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(Integer.MIN_VALUE, 2);
		currencyValue.setCents(Integer.MIN_VALUE);
		CurrencyValue actualCurrencyValue = new CurrencyValue(currencyValue);
		assertEquals(52, actualCurrencyValue.getCents());
		assertEquals(2126008811, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor14() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(true, 1, 1);

		assertEquals(1, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor15() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(false, 1, 1);

		assertEquals(1, actualCurrencyValue.getCents());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor16() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(true, -1, 1);

		assertEquals(1, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor17() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(true, 1, -1);

		assertEquals(1, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor18() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(true, 1, Integer.MIN_VALUE);

		assertEquals(48, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(21474837, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor19() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(true, Integer.MIN_VALUE, Integer.MIN_VALUE);

		assertEquals(52, actualCurrencyValue.getCents());
		assertEquals(2126008811, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor2() {
		CurrencyValue actualCurrencyValue = new CurrencyValue();
		assertEquals(0, actualCurrencyValue.getCents());
		assertEquals(0, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor20() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(false, 1, 100);

		assertEquals(0, actualCurrencyValue.getCents());
		assertEquals(2, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor3() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(1, 1);

		assertEquals(1, actualCurrencyValue.getCents());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor4() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(-99, 1);

		assertEquals(1, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(99, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor5() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(1, -99);

		assertEquals(99, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(1, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor6() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(1, Integer.MIN_VALUE);

		assertEquals(48, actualCurrencyValue.getCents());
		assertTrue(actualCurrencyValue.isNegative());
		assertEquals(21474837, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor7() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(Integer.MIN_VALUE, Integer.MIN_VALUE);

		assertEquals(52, actualCurrencyValue.getCents());
		assertEquals(2126008811, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor8() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(1, 100);

		assertEquals(0, actualCurrencyValue.getCents());
		assertEquals(2, actualCurrencyValue.getDollars());
	}

	@Test
	void testConstructor9() {
		CurrencyValue actualCurrencyValue = new CurrencyValue(new CurrencyValue());
		assertEquals(0, actualCurrencyValue.getCents());
		assertEquals(0, actualCurrencyValue.getDollars());
	}

	@Test
	void testValueOf() {
		CurrencyValue actualValueOfResult = CurrencyValue.valueOf(10.0);
		assertEquals(0, actualValueOfResult.getCents());
		assertEquals(10, actualValueOfResult.getDollars());
	}

	@Test
	void testValueOf2() {
		CurrencyValue actualValueOfResult = CurrencyValue.valueOf(-0.5);
		assertEquals(50, actualValueOfResult.getCents());
		assertTrue(actualValueOfResult.isNegative());
		assertEquals(0, actualValueOfResult.getDollars());
	}

	@Test
	void testValueOf3() {
		CurrencyValue actualValueOfResult = CurrencyValue.valueOf(10.0f);
		assertEquals(0, actualValueOfResult.getCents());
		assertEquals(10, actualValueOfResult.getDollars());
	}

	@Test
	void testValueOf4() {
		CurrencyValue actualValueOfResult = CurrencyValue.valueOf(-0.5f);
		assertEquals(50, actualValueOfResult.getCents());
		assertTrue(actualValueOfResult.isNegative());
		assertEquals(0, actualValueOfResult.getDollars());
	}

	@Test
	void testSetDollars() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		assertEquals(1, currencyValue.getDollars());
	}

	@Test
	void testSetDollars2() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(-99);
		assertTrue(currencyValue.isNegative());
		assertEquals(99, currencyValue.getDollars());
	}

	@Test
	void testSetCents() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setCents(1);
		assertEquals(1, currencyValue.getCents());
	}

	@Test
	void testSetCents2() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setCents(-99);
		assertEquals(99, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
	}

	@Test
	void testAdd() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(2, 2);
		assertEquals(2, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(2, currencyValue.getDollars());
	}

	@Test
	void testAdd10() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);
		currencyValue.add(2, 0);
		currencyValue.add(2, 2);
		assertEquals(1, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(3, currencyValue.getDollars());
	}

	@Test
	void testAdd11() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);
		currencyValue.add(2, -99);
		assertEquals(0, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(4, currencyValue.getDollars());
	}

	@Test
	void testAdd12() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(Integer.MIN_VALUE, Integer.MIN_VALUE);
		assertEquals(52, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(2126008811, currencyValue.getDollars());
	}

	@Test
	void testAdd13() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);
		currencyValue.add(2, 0);
		currencyValue.add(2, 101);
		assertEquals(0, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(4, currencyValue.getDollars());
	}

	@Test
	void testAdd14() {
		CurrencyValue currencyValue = new CurrencyValue();

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		currencyValue.add(currencyValue1);
		assertEquals(1, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(1, currencyValue.getDollars());
	}

	@Test
	void testAdd15() {
		CurrencyValue currencyValue = new CurrencyValue(1, 1);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		currencyValue.add(currencyValue1);
		assertEquals(0, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(0, currencyValue.getDollars());
	}

	@Test
	void testAdd16() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		currencyValue.add(currencyValue1);
		assertEquals(2, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(2, currencyValue.getDollars());
	}

	@Test
	void testAdd17() {
		CurrencyValue valueOfResult = CurrencyValue.valueOf(10.0);

		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);
		valueOfResult.add(currencyValue);
		assertEquals(99, valueOfResult.getCents());
		assertFalse(valueOfResult.isNegative());
		assertEquals(8, valueOfResult.getDollars());
	}

	@Test
	void testAdd18() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(0, 2);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		currencyValue.add(currencyValue1);
		assertEquals(99, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(0, currencyValue.getDollars());
	}

	@Test
	void testAdd19() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(2, -99);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		currencyValue.add(currencyValue1);
		assertEquals(0, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(4, currencyValue.getDollars());
	}

	@Test
	void testAdd2() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);
		currencyValue.add(2, 2);
		assertEquals(1, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(1, currencyValue.getDollars());
	}

	@Test
	void testAdd20() {
		CurrencyValue currencyValue = new CurrencyValue();

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(false);
		currencyValue.add(currencyValue1);
		assertEquals(1, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(1, currencyValue.getDollars());
	}

	@Test
	void testAdd21() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(Integer.MIN_VALUE);
		currencyValue1.setNegative(true);
		currencyValue.add(currencyValue1);
		assertEquals(47, currencyValue.getCents());
		assertFalse(currencyValue.isNegative());
		assertEquals(21474834, currencyValue.getDollars());
	}

	@Test
	void testAdd3() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(-99, 2);
		currencyValue.add(2, 2);
		assertEquals(0, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(97, currencyValue.getDollars());
	}

	@Test
	void testAdd4() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(2, -99);
		currencyValue.add(2, 2);
		assertEquals(97, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(0, currencyValue.getDollars());
	}

	@Test
	void testAdd5() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(-99);
		currencyValue.setCents(0);
		currencyValue.setNegative(true);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.add(currencyValue);
		currencyValue1.add(2, 2);
		assertEquals(98, currencyValue1.getCents());
		assertTrue(currencyValue1.isNegative());
		assertEquals(96, currencyValue1.getDollars());
	}

	@Test
	void testAdd6() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(0);
		currencyValue.setCents(-99);
		currencyValue.setNegative(true);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.add(currencyValue);
		currencyValue1.add(2, 2);
		assertEquals(3, currencyValue1.getCents());
		assertFalse(currencyValue1.isNegative());
		assertEquals(1, currencyValue1.getDollars());
	}

	@Test
	void testAdd7() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(-99, 2);
		assertEquals(2, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(99, currencyValue.getDollars());
	}

	@Test
	void testAdd8() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(2, -99);
		assertEquals(99, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(2, currencyValue.getDollars());
	}

	@Test
	void testAdd9() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(2, Integer.MIN_VALUE);
		assertEquals(48, currencyValue.getCents());
		assertTrue(currencyValue.isNegative());
		assertEquals(21474838, currencyValue.getDollars());
	}

	@Test
	void testEquals() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);
		assertFalse(currencyValue.equals(null));
	}

	@Test
	void testEquals2() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);
		assertFalse(currencyValue.equals("Different type to CurrencyValue"));
	}

	@Test
	void testEquals3() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);
		assertTrue(currencyValue.equals(currencyValue));
		int expectedHashCodeResult = currencyValue.hashCode();
		assertEquals(expectedHashCodeResult, currencyValue.hashCode());
	}

	@Test
	void testEquals4() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertTrue(currencyValue.equals(currencyValue1));
		int expectedHashCodeResult = currencyValue.hashCode();
		assertEquals(expectedHashCodeResult, currencyValue1.hashCode());
	}

	@Test
	void testEquals5() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(0);
		currencyValue.setCents(1);
		currencyValue.setNegative(true);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertFalse(currencyValue.equals(currencyValue1));
	}

	@Test
	void testEquals6() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(0);
		currencyValue.setNegative(true);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertFalse(currencyValue.equals(currencyValue1));
	}

	@Test
	void testEquals7() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.setDollars(1);
		currencyValue.setCents(1);
		currencyValue.setNegative(false);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertFalse(currencyValue.equals(currencyValue1));
	}

	@Test
	void testToString() {
		assertEquals("$0.00", (new CurrencyValue()).toString());
		assertEquals("-$1.01", (new CurrencyValue(true, 1, 1)).toString());
	}

	@Test
	void testToString2() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(2, -99);
		assertEquals("-$2.99", currencyValue.toString());
	}

	@Test
	void testCompareTo() {
		CurrencyValue currencyValue = new CurrencyValue();

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertEquals(1, currencyValue.compareTo(currencyValue1));
	}

	@Test
	void testCompareTo2() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertEquals(1, currencyValue.compareTo(currencyValue1));
	}

	@Test
	void testCompareTo3() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(-99, 2);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertEquals(-1, currencyValue.compareTo(currencyValue1));
	}

	@Test
	void testCompareTo4() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(-1, 2);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertEquals(-1, currencyValue.compareTo(currencyValue1));
	}

	@Test
	void testCompareTo5() {
		CurrencyValue currencyValue = new CurrencyValue();
		currencyValue.add(Integer.MIN_VALUE, 2);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(true);
		assertEquals(1, currencyValue.compareTo(currencyValue1));
	}

	@Test
	void testCompareTo6() {
		CurrencyValue currencyValue = new CurrencyValue();

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(false);
		assertEquals(-1, currencyValue.compareTo(currencyValue1));
	}

	@Test
	void testCompareTo7() {
		CurrencyValue currencyValue = new CurrencyValue(true, 1, 1);

		CurrencyValue currencyValue1 = new CurrencyValue();
		currencyValue1.setDollars(1);
		currencyValue1.setCents(1);
		currencyValue1.setNegative(false);
		assertEquals(-1, currencyValue.compareTo(currencyValue1));
	}
}

