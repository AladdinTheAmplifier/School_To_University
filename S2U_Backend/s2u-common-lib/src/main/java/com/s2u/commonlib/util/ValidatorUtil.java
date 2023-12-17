package com.s2u.commonlib.util;

import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

import com.s2u.commonlib.exception.InputFieldValidationException;

public class ValidatorUtil {

	private ValidatorUtil() {

	}

	public static <T> void handleValidation(T t, Validator validator) {
		DataBinder dataBinder = new DataBinder(t);
		dataBinder.setValidator(validator);
		dataBinder.validate();
		if (dataBinder.getBindingResult().hasErrors()) {
			throw new InputFieldValidationException("Validation Error", dataBinder.getBindingResult().getFieldErrors());
		}
	}
}
