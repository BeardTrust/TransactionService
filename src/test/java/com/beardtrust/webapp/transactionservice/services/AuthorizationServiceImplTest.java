package com.beardtrust.webapp.transactionservice.services;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.beardtrust.webapp.transactionservice.entities.UserEntity;
import com.beardtrust.webapp.transactionservice.repos.AuthorizationRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AuthorizationServiceImpl.class})
@ExtendWith(SpringExtension.class)
class AuthorizationServiceImplTest {
	@MockBean
	private AuthorizationRepository authorizationRepository;

	@Autowired
	private AuthorizationServiceImpl authorizationServiceImpl;

	@Test
	void testGetUserByUserId() {
		when(this.authorizationRepository.findById((String) any())).thenReturn(Optional.<UserEntity>empty());
		assertNull(this.authorizationServiceImpl.getUserByUserId("42"));
		verify(this.authorizationRepository).findById((String) any());
	}
}

