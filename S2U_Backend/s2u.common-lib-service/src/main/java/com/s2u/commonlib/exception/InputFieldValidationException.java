package com.s2u.commonlib.exception;

import java.util.List;

import org.springframework.validation.FieldError;

public class InputFieldValidationException extends RuntimeException {

	private static final long serialVersionUID = 591564471981714268L;

	final transient List<FieldError> fieldErrorList = null;

	public InputFieldValidationException(String message, List<FieldError> errorCodeList) {
		super(message);
	}

	public List<FieldError> getFieldErrorList() {
		return fieldErrorList;
	}
}
