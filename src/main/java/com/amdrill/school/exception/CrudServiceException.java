package com.amdrill.school.exception;

public class CrudServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CrudServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
