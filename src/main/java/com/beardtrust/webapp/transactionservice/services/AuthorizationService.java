package com.beardtrust.webapp.transactionservice.services;

import com.beardtrust.webapp.transactionservice.dtos.UserDTO;

/**
 * The interface Authorization service.
 *
 * @author Matthew Crowell <Matthew.Crowell@Smoothstack.com>
 */
public interface AuthorizationService {
	/**
	 * Gets user by user id.
	 *
	 * @param id the id
	 * @return the user by user id
	 */
	UserDTO getUserByUserId(String id);
}
