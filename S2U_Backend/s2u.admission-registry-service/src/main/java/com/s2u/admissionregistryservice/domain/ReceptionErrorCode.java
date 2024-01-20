package com.s2u.admissionregistryservice.domain;

import com.s2u.commonlib.domain.IErrorCode;

public enum ReceptionErrorCode implements IErrorCode {

	INQUIRY_STUDENT_NAME_INVALID(1001, "inquiryStudent.inquiryStudentName is invalid"),
	INQUIRY_STUDENT_PHONE_NUMBER_INVALID(1002, "inquiryStudent.inquiryPhoneNumber is invalid"),
	INQUIRY_STUDENT_WHATSAPP_PHONE_NUMBER_INVALID(1003, "inquiryStudent.inquiryPhoneNumber is invalid"),
	INQUIRY_EMAIL_ADDRESS_INVALID(1004, "inquiryStudent.inquiryEmailAddress"),
	INQUIRY_STUDENT_BIRTHDAY_INVALID(1005, "inquiryStudent.inquiryStudentBirthday is invalid"),
	INQUIRY_STUDENT_AGE_INVALID(1006, "inquiryStudent.inquiryStudentAge is invalid"),
	INQUIRY_STUDENT_PARENT_NAME_INVALID(1007, "inquiryStudent.inquiryParentName is invalid"),
	INQUIRY_STUDENT_CLASS_TOBE_ADMITTED_INVALID(1008, "inquiryStudent.inquiryClassToBeAdmitted is invalid"),
	INQUIRY_FOLLOW_UP_USER_INVALID(1009, "inquiryStudent.inquiryStudent.inquiryFollowUp.followUpUser is invalid"),
	INQUIRY_STUDENT_ALREADY_EXISTS(1011, "Student Name Is Already Exists"),
	DEFAULT(9000, "unknown error"),;

	private int code;
	private String message;

	private ReceptionErrorCode(int code, String messgae) {
		this.code = code;
		this.message = messgae;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "{" + "code=" + code + ", message='" + message + '\'' + '}';
	}

	public static ReceptionErrorCode getByCodeStr(String codeStr) {
		for (ReceptionErrorCode e : values()) {
			if (e.getMessage().equals(codeStr))
				return e;
		}
		return DEFAULT;

	}
}
