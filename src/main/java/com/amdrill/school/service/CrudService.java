package com.amdrill.school.service;

import java.util.List;

public interface CrudService<I, O, K> {

	O create(I input);

	O read(K id);

	List<O> read();

	O update(I input, K id);

	void delete(K id);
}
