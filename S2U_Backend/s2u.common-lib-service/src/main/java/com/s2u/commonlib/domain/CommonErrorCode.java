package com.s2u.commonlib.domain;

public enum CommonErrorCode implements IErrorCode {
	INVALID_PATH(1001, "Invalid path argument");

	private int code;
	private String message;

	CommonErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
