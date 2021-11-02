package com.beardtrust.webapp.transactionservice.dtos;

import lombok.*;

import java.time.LocalDate;

/**
 * The UserEntity Data Transfer Object.
 *
 * @author Matthew Crowell <Matthew.Crowell@Smoothstack.com>
 */
@Data
@Builder
public class UserDTO {
	private String userId;
	private String username;
	private String email;
	private String phone;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String role;

	public UserDTO() {
	}

	public UserDTO(String userId, String username, String email, String phone, String firstName, String lastName, LocalDate dateOfBirth, String role) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}
}
