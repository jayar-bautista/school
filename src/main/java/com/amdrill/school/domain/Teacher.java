package com.amdrill.school.domain;

import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;

import com.amdrill.school.domain.Teacher.TeacherOutput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Teacher extends BaseTeacher implements Domain<TeacherOutput, String> {

	@Id
	private String id;

	public Teacher() {
	}

	public Teacher(TeacherInput teacherInput) {
		BeanUtils.copyProperties(teacherInput, this);
	}

	@Override
	public TeacherOutput generateOutput() {
		TeacherOutput teacherOutput = new TeacherOutput();
		BeanUtils.copyProperties(this, teacherOutput);
		return teacherOutput;
	}

	public static class TeacherInput extends BaseTeacher implements ApiInput {
	}

	@Getter
	@Setter
	public static class TeacherOutput extends BaseTeacher implements ApiOutput {
		private String id;
	}
}
