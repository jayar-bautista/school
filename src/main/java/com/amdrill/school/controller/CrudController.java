package com.amdrill.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Validated
public interface CrudController<I, O, K> {

	@PostMapping
	ResponseEntity<O> create(@Valid @RequestBody I input);

	@GetMapping(path = "/{id}")
	ResponseEntity<O> read(@PathVariable K id);

	@GetMapping
	ResponseEntity<List<O>> read();

	@PutMapping(path = "/{id}")
	ResponseEntity<O> update(@Valid @RequestBody I input, @PathVariable K id);

	@DeleteMapping(path = "/{id}")
	void delete(@PathVariable K id);
}
