package com.amdrill.school.domain;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseUser {

	@NotEmpty
	private String firstName;
	@NotEmpty
	private String middleName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String birthdate;
}