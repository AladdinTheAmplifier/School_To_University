package com.s2u.admissionregistry.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.s2u.admissionregistry.domain.InquiryStudentBO;
import com.s2u.admissionregistry.domain.ReceptionAggregateBO;
import com.s2u.admissionregistry.domain.ReceptionErrorCode;
import com.s2u.commonlib.util.CommonValidatorUtil;

@Component
public class ReceptionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ReceptionAggregateBO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ReceptionAggregateBO receptionAggregateBO = (ReceptionAggregateBO) target;
		InquiryStudentBO inquiryStudentBO = receptionAggregateBO.getInquiryStudent();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryStudentName",
				ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getMessage());
		//ValidateReceptionPatterns(errors, inquiryStudentBO);
	}

	private void ValidateReceptionPatterns(Errors errors, InquiryStudentBO inquiryStudentBO) {
		if (inquiryStudentBO.getInquiryPhoneNumber() != null) {
			boolean isValid = CommonValidatorUtil.isPhoneNumber(inquiryStudentBO.getInquiryPhoneNumber());
			if (!isValid) {
				errors.rejectValue("inquiryStudent.inquiryPhoneNumber",
						ReceptionErrorCode.INQUIRY_STUDENT_PHONE_NUMBER_INVALID.getCodeStr(),
						ReceptionErrorCode.INQUIRY_STUDENT_PHONE_NUMBER_INVALID.getMessage());
			}
		}
		if (inquiryStudentBO.getInquiryWhatsappNumber() != null) {
			boolean isValid = CommonValidatorUtil.isWhatsAppPhoneNumber(inquiryStudentBO.getInquiryWhatsappNumber());
			if (!isValid) {
				errors.rejectValue("inquiryStudent.inquiryWhatsappNumber",
						ReceptionErrorCode.INQUIRY_STUDENT_WHATSAPP_PHONE_NUMBER_INVALID.getCodeStr(),
						ReceptionErrorCode.INQUIRY_STUDENT_WHATSAPP_PHONE_NUMBER_INVALID.getMessage());
			}
		}

		if (inquiryStudentBO.getInquiryStudentName() != null) {
			boolean isValid = CommonValidatorUtil.isAlphabetical(inquiryStudentBO.getInquiryStudentName());
			if (!isValid) {
				errors.rejectValue("inquiryStudent.inquiryStudentName",
						ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getCodeStr(),
						ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getMessage());
			}
		}

		if (inquiryStudentBO.getInquiryEmailAddress() != null) {
			boolean isValid = CommonValidatorUtil.validateEmail(inquiryStudentBO.getInquiryEmailAddress());
			if (!isValid) {
				errors.rejectValue("inquiryStudent.inquiryEmailAddress",
						ReceptionErrorCode.INQUIRY_EMAIL_ADDRESS_INVALID.getCodeStr(),
						ReceptionErrorCode.INQUIRY_EMAIL_ADDRESS_INVALID.getMessage());
			}
		}

	}

}
