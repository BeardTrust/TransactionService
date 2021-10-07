package com.beardtrust.webapp.transactionservice.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class UserDTOTest {
	@Test
	void testCanEqual() {
		assertFalse((new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")).canEqual("Other"));
	}

	@Test
	void testCanEqual2() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertTrue(userDTO.canEqual(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testConstructor() {
		UserDTO actualUserDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
		actualUserDTO.setDateOfBirth(ofEpochDayResult);
		actualUserDTO.setEmail("jane.doe@example.org");
		actualUserDTO.setFirstName("Jane");
		actualUserDTO.setLastName("Doe");
		actualUserDTO.setPhone("4105551212");
		actualUserDTO.setRole("Role");
		actualUserDTO.setUserId("42");
		actualUserDTO.setUsername("janedoe");
		assertSame(ofEpochDayResult, actualUserDTO.getDateOfBirth());
		assertEquals("jane.doe@example.org", actualUserDTO.getEmail());
		assertEquals("Jane", actualUserDTO.getFirstName());
		assertEquals("Doe", actualUserDTO.getLastName());
		assertEquals("4105551212", actualUserDTO.getPhone());
		assertEquals("Role", actualUserDTO.getRole());
		assertEquals("42", actualUserDTO.getUserId());
		assertEquals("janedoe", actualUserDTO.getUsername());
	}

	@Test
	void testEquals() {
		assertFalse((new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")).equals(null));
		assertFalse((new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")).equals("Different type to UserDTO"));
	}

	@Test
	void testEquals10() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "+44 1865 4960636", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals11() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", null, "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals12() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "42", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals13() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", null, "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals14() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "42",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals15() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", null,
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals16() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(0L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals17() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe", null, "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals18() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "42");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals19() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), null);
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals2() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertTrue(userDTO.equals(userDTO));
		int expectedHashCodeResult = userDTO.hashCode();
		assertEquals(expectedHashCodeResult, userDTO.hashCode());
	}

	@Test
	void testEquals20() {
		UserDTO userDTO = new UserDTO(null, "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		UserDTO userDTO1 = new UserDTO(null, "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");

		assertTrue(userDTO.equals(userDTO1));
		int expectedHashCodeResult = userDTO.hashCode();
		assertEquals(expectedHashCodeResult, userDTO1.hashCode());
	}

	@Test
	void testEquals21() {
		UserDTO userDTO = new UserDTO("42", null, "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		UserDTO userDTO1 = new UserDTO("42", null, "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");

		assertTrue(userDTO.equals(userDTO1));
		int expectedHashCodeResult = userDTO.hashCode();
		assertEquals(expectedHashCodeResult, userDTO1.hashCode());
	}

	@Test
	void testEquals22() {
		UserDTO userDTO = new UserDTO("42", "janedoe", null, "4105551212", "Jane", "Doe", LocalDate.ofEpochDay(1L), "Role");
		UserDTO userDTO1 = new UserDTO("42", "janedoe", null, "4105551212", "Jane", "Doe", LocalDate.ofEpochDay(1L),
				"Role");

		assertTrue(userDTO.equals(userDTO1));
		int expectedHashCodeResult = userDTO.hashCode();
		assertEquals(expectedHashCodeResult, userDTO1.hashCode());
	}

	@Test
	void testEquals3() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		UserDTO userDTO1 = new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");

		assertTrue(userDTO.equals(userDTO1));
		int expectedHashCodeResult = userDTO.hashCode();
		assertEquals(expectedHashCodeResult, userDTO1.hashCode());
	}

	@Test
	void testEquals4() {
		UserDTO userDTO = new UserDTO("janedoe", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals5() {
		UserDTO userDTO = new UserDTO(null, "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals6() {
		UserDTO userDTO = new UserDTO("42", "42", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals7() {
		UserDTO userDTO = new UserDTO("42", null, "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals8() {
		UserDTO userDTO = new UserDTO("42", "janedoe", "42", "4105551212", "Jane", "Doe", LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}

	@Test
	void testEquals9() {
		UserDTO userDTO = new UserDTO("42", "janedoe", null, "4105551212", "Jane", "Doe", LocalDate.ofEpochDay(1L), "Role");
		assertFalse(userDTO.equals(new UserDTO("42", "janedoe", "jane.doe@example.org", "4105551212", "Jane", "Doe",
				LocalDate.ofEpochDay(1L), "Role")));
	}
}

