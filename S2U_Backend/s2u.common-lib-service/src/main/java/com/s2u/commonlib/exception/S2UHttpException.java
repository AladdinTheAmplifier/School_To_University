package com.s2u.commonlib.exception;

import org.springframework.http.HttpStatus;

import com.s2u.commonlib.domain.IErrorCode;

public class S2UHttpException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	final transient IErrorCode errorCode;

	private final HttpStatus httpStatus;

	public S2UHttpException(IErrorCode errorCode, HttpStatus httpStatus) {
		super(errorCode.getMessage());
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
	}

	public IErrorCode getErrorCode() {
		return errorCode;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
