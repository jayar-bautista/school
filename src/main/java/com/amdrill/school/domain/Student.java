package com.amdrill.school.domain;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import com.amdrill.school.domain.Student.StudentOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends BaseStudent implements Domain<StudentOutput, String> {

	@Id
	private String id;

	public Student() {
	}

	public Student(StudentInput studentInput) {
		BeanUtils.copyProperties(studentInput, this);
	}

	public StudentOutput generateOutput() {
		StudentOutput studentOutput = new StudentOutput();
		BeanUtils.copyProperties(this, studentOutput);
		return studentOutput;
	}

	public static class StudentInput extends BaseStudent implements ApiInput {
	}

	@Getter
	@Setter
	public static class StudentOutput extends BaseStudent implements ApiOutput {
		private String id;
	}
}
