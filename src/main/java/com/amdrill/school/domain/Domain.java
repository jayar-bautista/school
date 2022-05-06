package com.amdrill.school.domain;

public interface Domain<O, K> {

	void setId(K id);

	K getId();

	O generateOutput();
}
