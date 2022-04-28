package com.amdrill.school.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseUser {

	private String firstName;
	private String middleName;
	private String lastName;
	private String birthdate;
}