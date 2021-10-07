package com.beardtrust.webapp.transactionservice.dtos;

import lombok.Builder;
import lombok.Data;

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
}
