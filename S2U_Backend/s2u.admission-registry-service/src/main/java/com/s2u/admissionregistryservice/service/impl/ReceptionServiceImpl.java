package com.s2u.admissionregistryservice.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2u.admissionregistryservice.domain.ReceptionAggregateBO;
import com.s2u.admissionregistryservice.domain.ReceptionAggregateBOBuilder;
import com.s2u.admissionregistryservice.entity.AuditModel;
import com.s2u.admissionregistryservice.entity.InquiryStudentDO;
import com.s2u.admissionregistryservice.mapper.ReceptionMapper;
import com.s2u.admissionregistryservice.repository.InquiryStudentRepository;
import com.s2u.admissionregistryservice.service.ReceptionService;
import com.s2u.admissionregistryservice.validation.ReceptionDuplicateHandler;
import com.s2u.admissionregistryservice.validation.ReceptionValidator;
import com.s2u.commonlib.exception.S2UConfigurationException;
import com.s2u.commonlib.util.Constants;
import com.s2u.commonlib.util.ValidatorUtil;

@Service
@Transactional
public class ReceptionServiceImpl implements ReceptionService {

	private static final Logger LOG = LoggerFactory.getLogger(ReceptionServiceImpl.class);

	@Autowired
	ReceptionValidator receptionValidator;
	
	@Autowired
	ReceptionDuplicateHandler receptionDuplicateHandler;

	@Autowired
	ReceptionMapper receptionMapper;

	@Autowired
	InquiryStudentRepository inquiryStudentRepository;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public ReceptionAggregateBO addInquiryStudent(ReceptionAggregateBO receptionAggregateBO) {
		LOG.info("--start method of addInquiryStudent");
		@SuppressWarnings("unused")
		InquiryStudentDO savedinquiryStudent = null;
		try {
			ValidatorUtil.handleValidation(receptionAggregateBO, receptionValidator);
			receptionDuplicateHandler.checkDuplicate(receptionAggregateBO);
			InquiryStudentDO inquiryStudentDO = receptionMapper
					.toInquiryStudentDO(receptionAggregateBO.getInquiryStudent());
			System.out.println(inquiryStudentDO);
			// InquiryStudentDO inquiryStudentDO = new InquiryStudentDO();
			// inquiryStudentDO.setInquiryStudentName(receptionAggregateBO.getInquiryStudent().getInquiryStudentName());
			/// inquiryStudentDO.setInquiryStudentAge(receptionAggregateBO.getInquiryStudent().getInquiryStudentAge());
			inquiryStudentDO.setIsActive(Constants.IS_ACTIVE);
			inquiryStudentDO.setAudit(createAuditModel(inquiryStudentDO.getInquiryStudentName()));
			inquiryStudentDO.getInquiryFollowUpDO().setIsActive(Constants.IS_ACTIVE);
			inquiryStudentDO.getInquiryFollowUpDO()
					.setAudit(createAuditModel(inquiryStudentDO.getInquiryStudentName()));
			savedinquiryStudent = inquiryStudentRepository.save(inquiryStudentDO);
		} catch (S2UConfigurationException e) {
			LOG.equals("--error occured in addInquiryStudent--" + e.getMessage());
		}
		return ReceptionAggregateBOBuilder.create()
				.withInquiryStudent(receptionMapper.toInquiryStudentBO(savedinquiryStudent)).build();
	}

	private AuditModel createAuditModel(String userName) {
		AuditModel auditModel = new AuditModel();
		auditModel.setCreatedDate(new java.util.Date());
		auditModel.setCreatedBy(userName);
		return auditModel;
	}

	@SuppressWarnings("unused")
	private AuditModel updateAuditModel(String userName, AuditModel audit) {
		audit.setUpdatedDate(new java.util.Date());
		audit.setUpdatedBy(userName);
		return audit;
	}
}