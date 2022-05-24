package com.amdrill.school.domain;

import static com.amdrill.school.domain.MockDomain.ID;
import static com.amdrill.school.domain.MockDomain.NAME;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import com.amdrill.school.dto.SubjectInput;
import com.amdrill.school.dto.SubjectOutput;

public class SubjectTest {
	@Test
	public void givenSubjectWhenGenerateOutputIsInvokedThenSubjectOutputIsCreated() {
		SubjectInput subjectInput = new SubjectInput();
		subjectInput.setName(NAME);
		Subject subject = new Subject(subjectInput);
		subject.setId(ID);

		SubjectOutput subjectOutput = subject.generateOutput();

		assertSame(subjectInput.getName(), subjectOutput.getName());
		assertSame(ID, subjectOutput.getId());
	}

	@Test
	public void givenSubjectWhenGenerateOutputIsInvokedThenSubjectOutputIdIsNull() {
		Subject subject = new Subject();

		SubjectOutput subjectOutput = subject.generateOutput();

		assertNull(subjectOutput.getId());
	}
}
