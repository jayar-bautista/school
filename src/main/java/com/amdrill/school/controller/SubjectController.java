package com.amdrill.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amdrill.school.dto.SubjectInput;
import com.amdrill.school.dto.SubjectOutput;
import com.amdrill.school.service.CrudService;

@RestController
@RequestMapping(path = "/api/subjects")
public class SubjectController extends BaseCrudController<SubjectInput, SubjectOutput> {

	@Autowired
	public SubjectController(CrudService<SubjectInput, SubjectOutput> crudService) {
		super(crudService);
	}
}
