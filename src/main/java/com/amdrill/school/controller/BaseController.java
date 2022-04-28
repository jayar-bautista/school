package com.amdrill.school.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.amdrill.school.domain.ApiInput;
import com.amdrill.school.domain.ApiOutput;
import com.amdrill.school.service.CrudService;

public class BaseController<I extends ApiInput, O extends ApiOutput, K> implements CrudController<I, O, K> {
	private static final String SLASH = "/";
	private CrudService<I, O, K> crudService;

	protected BaseController(CrudService<I, O, K> crudService) {
		this.crudService = crudService;
	}

	@Override
	public ResponseEntity<String> create(I input) {
		K id = crudService.create(input);
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		String path = builder.toUriString() + SLASH + id;
		return new ResponseEntity<>(path, HttpStatus.CREATED);
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
	public void update(I input, K id) {
		crudService.update(input, id);
	}

	@Override
	public void delete(K id) {
		crudService.delete(id);
	}
}
