package com.amdrill.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdrill.school.dto.TeacherInput;
import com.amdrill.school.dto.TeacherOutput;
import com.amdrill.school.service.CrudService;

@RestController
@RequestMapping(path = "/api/teachers")
public class TeacherController extends BaseCrudController<TeacherInput, TeacherOutput> {

	@Autowired
	public TeacherController(CrudService<TeacherInput, TeacherOutput> crudService) {
		super(crudService);
	}
}
