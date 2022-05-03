package com.amdrill.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdrill.school.domain.Student.StudentInput;
import com.amdrill.school.domain.Student.StudentOutput;
import com.amdrill.school.service.CrudService;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController extends BaseCrudController<StudentInput, StudentOutput, String> {

	@Autowired
	public StudentController(CrudService<StudentInput, StudentOutput, String> crudService) {
		super(crudService);
	}
}