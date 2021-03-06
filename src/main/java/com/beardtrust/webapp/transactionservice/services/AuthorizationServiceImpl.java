package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.dtos.UserDTO;
import com.beardtrust.webapp.transactionservice.entities.UserEntity;
import com.beardtrust.webapp.transactionservice.repos.AuthorizationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Authorization service.
 *
 * @author Matthew Crowell <Matthew.Crowell@Smoothstack.com>
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	private final AuthorizationRepository authorizationRepository;

	/**
	 * Instantiates a new Authorization service.
	 *
	 * @param authorizationRepository the authorization repository
	 */
	@Autowired
	public AuthorizationServiceImpl(AuthorizationRepository authorizationRepository) {
		this.authorizationRepository = authorizationRepository;
	}


	@Override
	public UserDTO getUserByUserId(String id) {
		Optional<UserEntity> user = authorizationRepository.findById(id);

		UserDTO userDTO = null;

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		if (user.isPresent()) {
			userDTO = modelMapper.map(user.get(), UserDTO.class);
		}

		return userDTO;
	}
}
