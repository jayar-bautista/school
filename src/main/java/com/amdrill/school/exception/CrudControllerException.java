package com.amdrill.school.exception;

public class CrudControllerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CrudControllerException(String message, Throwable cause) {
		super(message, cause);
	}
}
