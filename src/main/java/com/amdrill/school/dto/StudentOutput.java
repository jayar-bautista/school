package com.amdrill.school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentOutput extends BaseStudentDto implements ApiOutput {
	private String id;
}