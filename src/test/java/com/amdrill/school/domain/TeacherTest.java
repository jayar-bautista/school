package com.amdrill.school.domain;

import static com.amdrill.school.domain.MockDomain.ID;
import static com.amdrill.school.domain.MockDomain.NAME;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.amdrill.school.dto.TeacherInput;
import com.amdrill.school.dto.TeacherOutput;

class TeacherTest {

	@Test
	void givenTeacherWhenGenerateOutputIsInvokedThenTeacherOutputIsCreated() {
		TeacherInput teacherInput = new TeacherInput();
		teacherInput.setFirstName(NAME);
		Teacher teacher = new Teacher(teacherInput);
		teacher.setId(ID);

		TeacherOutput teacherOutput = teacher.generateOutput();

		assertSame(teacherInput.getFirstName(), teacherOutput.getFirstName());
		assertSame(ID, teacherOutput.getId());
	}

	@Test
	void givenTeacherWhenGenerateOutputIsInvokedThenTeacherOutputIdIsNull() {
		Teacher teacher = new Teacher();

		TeacherOutput teacherOutput = teacher.generateOutput();

		assertNull(teacherOutput.getId());
	}
}
