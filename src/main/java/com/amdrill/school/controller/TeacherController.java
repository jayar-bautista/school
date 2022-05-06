package com.amdrill.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdrill.school.domain.Teacher.TeacherInput;
import com.amdrill.school.domain.Teacher.TeacherOutput;
import com.amdrill.school.service.CrudService;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController extends BaseCrudController<TeacherInput, TeacherOutput, String> {

	@Autowired
	public TeacherController(CrudService<TeacherInput, TeacherOutput, String> crudService) {
		super(crudService);
	}
}
