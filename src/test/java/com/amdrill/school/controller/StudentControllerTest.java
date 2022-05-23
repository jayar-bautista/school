package com.amdrill.school.controller;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.amdrill.school.dto.StudentInput;
import com.amdrill.school.dto.StudentOutput;
import com.amdrill.school.service.CrudService;

public class StudentControllerTest {

	@Mock
	private CrudService<StudentInput, StudentOutput> crudService;

	@Test
	public void givenCrudServiceWhenConstructorIsInvokedThenCru() {
		StudentController studentController = new StudentController(crudService);

		assertSame(crudService, studentController.getCrudService());
	}
}
