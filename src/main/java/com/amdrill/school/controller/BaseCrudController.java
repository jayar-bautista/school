package com.amdrill.school.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.amdrill.school.domain.ApiInput;
import com.amdrill.school.domain.ApiOutput;
import com.amdrill.school.service.CrudService;

public class BaseCrudController<I extends ApiInput, O extends ApiOutput, K> implements CrudController<I, O, K> {

	private final CrudService<I, O, K> crudService;

	protected BaseCrudController(CrudService<I, O, K> crudService) {
		this.crudService = crudService;
	}

	@Override
	public ResponseEntity<O> create(I input) {
		O result = crudService.create(input);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<O> read(K id) {
		O result = crudService.read(id);
		return ResponseEntity.ok(result);
	}

	@Override
	public ResponseEntity<List<O>> read() {
		List<O> objects = crudService.read();
		return ResponseEntity.ok(objects);
	}

	@Override
	public ResponseEntity<O> update(I input, K id) {
		O result = crudService.update(input, id);
		return ResponseEntity.ok(result);
	}

	@Override
	public void delete(K id) {
		crudService.delete(id);
	}

	public CrudService<I, O, K> getCrudService() {
		return crudService;
	}
}
