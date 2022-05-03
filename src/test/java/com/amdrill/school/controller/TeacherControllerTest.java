package com.amdrill.school.controller;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.amdrill.school.domain.Teacher.TeacherInput;
import com.amdrill.school.domain.Teacher.TeacherOutput;
import com.amdrill.school.service.CrudService;

public class TeacherControllerTest {

	@Mock
	private CrudService<TeacherInput, TeacherOutput, String> crudService;

	@Test
	public void givenTeacherControllerWhenConstructorIsInvokedThenCrudServiceIsSaved() {
		TeacherController teacherController = new TeacherController(crudService);

		assertSame(crudService, teacherController.getCrudService());
	}
}
