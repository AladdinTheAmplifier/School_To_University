package com.s2u.commonlib.exception;

import org.springframework.http.HttpStatus;

import com.s2u.commonlib.domain.IErrorCode;

public class InValidPathArgumentException extends S2UHttpException{
	
	private static final long serialVersionUID = 1L;

	public InValidPathArgumentException(IErrorCode errorCode, HttpStatus httpStatus) {
		super(errorCode, httpStatus);
	}

}
