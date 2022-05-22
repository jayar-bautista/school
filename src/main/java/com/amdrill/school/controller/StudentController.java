package com.amdrill.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdrill.school.dto.StudentInput;
import com.amdrill.school.dto.StudentOutput;
import com.amdrill.school.service.CrudService;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController extends BaseCrudController<StudentInput, StudentOutput> {

	@Autowired
	public StudentController(CrudService<StudentInput, StudentOutput> crudService) {
		super(crudService);
	}
}