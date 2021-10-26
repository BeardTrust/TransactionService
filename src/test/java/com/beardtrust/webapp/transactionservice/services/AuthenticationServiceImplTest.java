package com.beardtrust.webapp.transactionservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.beardtrust.webapp.transactionservice.entities.UserEntity;
import com.beardtrust.webapp.transactionservice.repos.UserRepository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthenticationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AuthenticationServiceImplTest {
	@Autowired
	private AuthenticationServiceImpl authenticationServiceImpl;

	@MockBean
	private Environment environment;

	@MockBean
	private UserRepository userRepository;

	@Test
	void testGetUserDetailsByEmail() {
		UserRepository userRepository = mock(UserRepository.class);
		when(userRepository.findByEmail((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
		assertThrows(UsernameNotFoundException.class,
				() -> (new AuthenticationServiceImpl(new StandardReactiveWebEnvironment(), userRepository))
						.getUserDetailsByEmail("jane.doe@example.org"));
		verify(userRepository).findByEmail((String) any());
	}

	@Test
	void testLoadUserByUsername() throws UsernameNotFoundException {
		UserEntity userEntity = new UserEntity();
		userEntity.setLastName("Doe");
		userEntity.setPassword("iloveyou");
		userEntity.setEmail("jane.doe@example.org");
		userEntity.setRole("Role");
		userEntity.setDateOfBirth(LocalDate.ofEpochDay(1L));
		userEntity.setUsername("janedoe");
		userEntity.setUserId("42");
		userEntity.setPhone("4105551212");
		userEntity.setFirstName("Jane");
		when(this.userRepository.findByEmail((String) any())).thenReturn(userEntity);
		UserDetails actualLoadUserByUsernameResult = this.authenticationServiceImpl.loadUserByUsername("foo");
		assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
		assertEquals(
				"org.springframework.security.core.userdetails.User [Username=jane.doe@example.org, Password=[PROTECTED],"
						+ " Enabled=true, AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted"
						+ " Authorities=[Role]]",
				actualLoadUserByUsernameResult.toString());
		assertTrue(actualLoadUserByUsernameResult.isEnabled());
		assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
		assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
		assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
		assertEquals("jane.doe@example.org", actualLoadUserByUsernameResult.getUsername());
		assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
		verify(this.userRepository).findByEmail((String) any());
	}
}

