package com.s2u.admissionregistryservice.validation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.s2u.admissionregistryservice.domain.InquiryStudentBO;
import com.s2u.admissionregistryservice.domain.ReceptionAggregateBO;
import com.s2u.admissionregistryservice.domain.ReceptionErrorCode;
import com.s2u.admissionregistryservice.entity.InquiryStudentDO;
import com.s2u.admissionregistryservice.mapper.ReceptionMapper;
import com.s2u.admissionregistryservice.repository.InquiryStudentRepository;
import com.s2u.commonlib.domain.IErrorCode;
import com.s2u.commonlib.exception.DuplicateException;
import com.s2u.commonlib.service.DuplicateHandler;
import com.s2u.commonlib.util.Constants;

@Component
public class ReceptionDuplicateHandler implements DuplicateHandler<ReceptionAggregateBO> {

	private static final Logger LOG = LoggerFactory.getLogger(ReceptionDuplicateHandler.class);

	@Autowired
	ReceptionMapper receptionMapper;

	@Autowired
	InquiryStudentRepository inquiryStudentRepository;

	@Override
	public void checkDuplicate(ReceptionAggregateBO receptionAggregateBO) {
		List<IErrorCode> errorCodeEnumList = new ArrayList<>();
		InquiryStudentBO inquiryStudentBO = receptionAggregateBO.getInquiryStudent();
		String inquiryStudentName = receptionAggregateBO.getInquiryStudent().getInquiryStudentName();
		String inquiryStudentPhoneNumber = receptionAggregateBO.getInquiryStudent().getInquiryPhoneNumber();
		Assert.notNull(inquiryStudentName, "Student Name cannot be null");
		Assert.notNull(inquiryStudentPhoneNumber, "Student Phone Number cannot be null");
		InquiryStudentBO existingInquiryStudent = getStudentDetails(
				receptionMapper.toInquiryStudentDO(inquiryStudentBO));
		if (existingInquiryStudent != null) {
			LOG.debug("Inquiry Student:{} already exists", existingInquiryStudent);
			errorCodeEnumList.add(ReceptionErrorCode.INQUIRY_STUDENT_ALREADY_EXISTS);
		}
		if (!errorCodeEnumList.isEmpty()) {
			throw new DuplicateException("Duplicate Error", errorCodeEnumList);
		}

	}

	private InquiryStudentBO getStudentDetails(InquiryStudentDO inquiryStudentDO) {
		
		InquiryStudentBO tnquiryStudentBO = receptionMapper.toInquiryStudentBO(
				inquiryStudentRepository.findInquiryStudentDetailsIsActive(inquiryStudentDO.getInquiryStudentName(),
						inquiryStudentDO.getInquiryPhoneNumber(), Constants.IS_ACTIVE));
		return tnquiryStudentBO;
	}
}
