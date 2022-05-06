package com.amdrill.school.domain;

import static com.amdrill.school.domain.MockDomain.ID;
import static com.amdrill.school.domain.MockDomain.NAME;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.amdrill.school.domain.Student.StudentInput;
import com.amdrill.school.domain.Student.StudentOutput;

public class StudentTest {

	@Test
	public void givenStudentWhenGenerateOutputIsInvokedThenStudentOutputIsCreated() {
		StudentInput studentInput = new StudentInput();
		studentInput.setFirstName(NAME);
		Student student = new Student(studentInput);
		student.setId(ID);

		StudentOutput studentOutput = student.generateOutput();

		assertSame(studentInput.getFirstName(), studentOutput.getFirstName());
		assertSame(ID, studentOutput.getId());
	}

	@Test
	public void givenStudentWhenGenerateOutputIsInvokedThenStudentOutputIdIsNull() {
		Student student = new Student();

		StudentOutput studentOutput = student.generateOutput();

		assertNull(studentOutput.getId());
	}
}
