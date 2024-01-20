package com.s2u.commonlib.exception;

import java.util.List;

import com.s2u.commonlib.domain.IErrorCode;

public class DuplicateException extends RuntimeException {

	private static final long serialVersionUID = 101L;
	final transient List<IErrorCode> errorCodes;

	public DuplicateException(String meesage, List<IErrorCode> duplicateErrorCodes) {
		super(meesage);
		this.errorCodes = duplicateErrorCodes;
	}

	public List<IErrorCode> getErrorCodes() {
		return errorCodes;
	}

}
