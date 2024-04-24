package com.s2u.admissionregistryservice.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.s2u.admissionregistryservice.domain.InquiryFollowUpBO;
import com.s2u.admissionregistryservice.domain.InquiryStudentBO;
import com.s2u.admissionregistryservice.domain.ReceptionAggregateBO;
import com.s2u.admissionregistryservice.domain.ReceptionErrorCode;
import com.s2u.commonlib.util.CommonValidatorUtil;

@Component
public class ReceptionValidator implements Validator {

	private static final Logger LOG = LoggerFactory.getLogger(ReceptionValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return ReceptionAggregateBO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LOG.info("-- Reception Validator Class - validate method --");
		ReceptionAggregateBO receptionAggregateBO = (ReceptionAggregateBO) target;
		
		InquiryStudentBO inquiryStudentBO = receptionAggregateBO.getInquiryStudent();
		
		InquiryFollowUpBO inquiryFollowUpBO = receptionAggregateBO.getInquiryStudent().getInquiryFollowUp();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryStudentName",
				ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getMessage());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryStudentBirthday",
				ReceptionErrorCode.INQUIRY_STUDENT_BIRTHDAY_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_BIRTHDAY_INVALID.getMessage());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryStudentAge",
				ReceptionErrorCode.INQUIRY_STUDENT_AGE_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_AGE_INVALID.getMessage());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryParentName",
				ReceptionErrorCode.INQUIRY_STUDENT_PARENT_NAME_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_PARENT_NAME_INVALID.getMessage());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryPhoneNumber",
				ReceptionErrorCode.INQUIRY_STUDENT_PHONE_NUMBER_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_PHONE_NUMBER_INVALID.getMessage());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryClassToBeAdmitted",
				ReceptionErrorCode.INQUIRY_STUDENT_CLASS_TOBE_ADMITTED_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_STUDENT_CLASS_TOBE_ADMITTED_INVALID.getMessage());

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inquiryStudent.inquiryFollowUp.followUpUser",
				ReceptionErrorCode.INQUIRY_FOLLOW_UP_USER_INVALID.getCodeStr(),
				ReceptionErrorCode.INQUIRY_FOLLOW_UP_USER_INVALID.getMessage());

		//ValidateReceptionPatterns(errors, inquiryStudentBO, inquiryFollowUpBO);
		//ValidateReceptionFollowUp(errors, inquiryFollowUpBO);
	}

	private void ValidateReceptionPatterns(Errors errors, InquiryStudentBO inquiryStudentBO,
			InquiryFollowUpBO inquiryFollowUpBO) {
		if ((inquiryStudentBO.getInquiryPhoneNumber() != null)
				&& (Integer.getInteger(inquiryStudentBO.getInquiryPhoneNumber()) >= 11)) {
			boolean isValid = CommonValidatorUtil.isPhoneNumber(inquiryStudentBO.getInquiryPhoneNumber());
			if (!isValid) {
				errors.rejectValue("inquiryStudent.inquiryPhoneNumber",
						ReceptionErrorCode.INQUIRY_STUDENT_PHONE_NUMBER_INVALID.getCodeStr(),
						ReceptionErrorCode.INQUIRY_STUDENT_PHONE_NUMBER_INVALID.getMessage());
			}
		}
		if ((inquiryStudentBO.getInquiryWhatsappNumber() != null)&& (Integer.getInteger(inquiryStudentBO.getInquiryWhatsappNumber()) >= 11)) {
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

	private void ValidateReceptionFollowUp(Errors errors, InquiryFollowUpBO inquiryFollowUpBO) {
		if (inquiryFollowUpBO.getFollowUpUser() != null) {
			boolean isValid = CommonValidatorUtil.isAlphabetical(inquiryFollowUpBO.getFollowUpUser());
			if (!isValid) {
				errors.rejectValue("inquiryStudent.inquiryFollowUp.followUpUser",
						ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getCodeStr(),
						ReceptionErrorCode.INQUIRY_STUDENT_NAME_INVALID.getMessage());
			}
		}

	}

}
