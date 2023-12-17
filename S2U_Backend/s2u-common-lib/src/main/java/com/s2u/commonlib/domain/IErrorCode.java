package com.s2u.commonlib.domain;

public interface IErrorCode {

	int getCode();

	String getMessage();

	default String getCodeStr() {
		return String.valueOf(getCode());

	}
}
