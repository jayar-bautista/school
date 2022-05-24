package com.amdrill.school.controller;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.amdrill.school.dto.SubjectInput;
import com.amdrill.school.dto.SubjectOutput;
import com.amdrill.school.service.CrudService;

public class SubjectControllerTest {
	@Mock
	private CrudService<SubjectInput, SubjectOutput> crudService;

	@Test
	public void givenCrudServiceWhenConstructorIsInvokedThenCru() {
		SubjectController subjectController = new SubjectController(crudService);

		assertSame(crudService, subjectController.getCrudService());
	}
}
