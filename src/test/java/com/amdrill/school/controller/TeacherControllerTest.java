package com.amdrill.school.controller;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.amdrill.school.dto.TeacherInput;
import com.amdrill.school.dto.TeacherOutput;
import com.amdrill.school.service.CrudService;

public class TeacherControllerTest {

	@Mock
	private CrudService<TeacherInput, TeacherOutput> crudService;

	@Test
	public void givenTeacherControllerWhenConstructorIsInvokedThenCrudServiceIsSaved() {
		TeacherController teacherController = new TeacherController(crudService);

		assertSame(crudService, teacherController.getCrudService());
	}
}
