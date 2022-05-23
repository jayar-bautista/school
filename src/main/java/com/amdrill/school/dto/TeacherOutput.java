package com.amdrill.school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherOutput extends BaseTeacher implements ApiOutput {
	private String id;
}
