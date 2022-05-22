package com.amdrill.school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseStudent extends BaseUser {
	private String grade;
	private String schoolYear;
	private String section;
}
