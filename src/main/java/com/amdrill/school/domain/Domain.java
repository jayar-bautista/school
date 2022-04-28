package com.amdrill.school.domain;

public interface Domain<T> {

	void setId(T id);

	T getId();

	ApiOutput generateOutput();
}
