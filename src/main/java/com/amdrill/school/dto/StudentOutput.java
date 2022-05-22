package com.amdrill.school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOutput extends BaseStudent implements ApiOutput {
	private String id;
}