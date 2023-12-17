package com.hr.exception;

import com.hr.util.ErrorResponse;

@SuppressWarnings("serial")
public class DuplicateEmployeeException extends RuntimeException {
	
	private ErrorResponse errorResponse;

	public DuplicateEmployeeException(ErrorResponse errorResponse) {
		super();
		this.errorResponse = errorResponse;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}
	
	
}
