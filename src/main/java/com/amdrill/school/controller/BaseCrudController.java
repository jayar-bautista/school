package com.amdrill.school.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.amdrill.school.dto.ApiInput;
import com.amdrill.school.dto.ApiOutput;
import com.amdrill.school.service.CrudService;

public class BaseCrudController<I extends ApiInput, O extends ApiOutput> implements CrudController<I, O> {

	private final CrudService<I, O> crudService;

	protected BaseCrudController(CrudService<I, O> crudService) {
		this.crudService = crudService;
	}

	@Override
	public ResponseEntity<O> create(I input) {
		O result = crudService.create(input);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<O> read(String id) {
		O result = crudService.read(id);
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<List<O>> read() {
		List<O> objects = crudService.read();
		return ResponseEntity.ok(objects);
	}

	@Override
	public ResponseEntity<O> update(I input, String id) {
		O result = crudService.update(input, id);
		return ResponseEntity.ok(result);
	}

	@Override
	public void delete(String id) {
		crudService.delete(id);
	}

	public CrudService<I, O> getCrudService() {
		return crudService;
	}
}
