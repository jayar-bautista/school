package com.amdrill.school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherOutput extends BaseTeacherDto implements ApiOutput {
	private String id;
}
