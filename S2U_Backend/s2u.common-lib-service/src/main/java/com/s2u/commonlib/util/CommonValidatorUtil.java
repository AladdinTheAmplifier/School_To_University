package com.s2u.commonlib.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CommonValidatorUtil {

	private CommonValidatorUtil() {
		// not called
	}

	private static final Pattern ALPHABETICAL_PATTERN = Pattern.compile("^[a-zA-Z]*$");

	private static final Pattern NUMERIC_INTEGER_PATTERN = Pattern.compile("^\\d+$");

	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[\\w-\\+]+(\\.[\\w]+)@[\\w-]+(\\.[\\w]+)(\\.[a-z]{2,})$");

	public static boolean isAlphabetical(String string) {
		boolean result = true;
		result = ALPHABETICAL_PATTERN.matcher(String.valueOf(string)).matches();
		return result;
	}

	public static boolean isNumeric(String number) {
		boolean result = true;
		result = NUMERIC_INTEGER_PATTERN.matcher(String.valueOf(number)).matches();
		return result;

	}

	public static boolean isPhoneNumber(String phoneNumber) {
		boolean result = false;
		result = NUMERIC_INTEGER_PATTERN.matcher(String.valueOf(phoneNumber)).matches();
		if (result && (phoneNumber.length() < 10 || phoneNumber.length() > 11)) {
			result = false;
		}
		return result;
	}

	public static boolean isWhatsAppPhoneNumber(String whatsAppPhoneNumber) {
		boolean result = false;
		result = NUMERIC_INTEGER_PATTERN.matcher(String.valueOf(whatsAppPhoneNumber)).matches();
		if (result && (whatsAppPhoneNumber.length() < 10 || whatsAppPhoneNumber.length() > 11)) {
			result = false;
		}
		return result;
	}

	public static boolean validateEmail(String email) {
		boolean result = true;
		result = EMAIL_PATTERN.matcher(String.valueOf(email)).matches();
		if (!result) {
			return result;
		} else {
			List<String> emailList = Arrays.asList(email.split("@"));
			String username = emailList.get(0);
			result = username.matches(".[a-zA-Z]+.");
			return result;
		}
	}
}
