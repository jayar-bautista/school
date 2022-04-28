package com.amdrill.school.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseTeacher extends BaseUser {
	private String department;
}
