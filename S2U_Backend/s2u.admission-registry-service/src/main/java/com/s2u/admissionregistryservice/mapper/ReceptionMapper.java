package com.s2u.admissionregistryservice.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.s2u.admissionregistryservice.domain.InquiryStudentBO;
import com.s2u.admissionregistryservice.entity.InquiryStudentDO;

@Mapper
public interface ReceptionMapper {

	@Mappings({ @Mapping(source = "inquiryFollowUp.followUpDate", target = "inquiryFollowUpDO.followUpDate"),
			@Mapping(source = "inquiryFollowUp.followUpUser", target = "inquiryFollowUpDO.followUpUser"),
			@Mapping(source = "inquiryFollowUp.followUpMessage", target = "inquiryFollowUpDO.followUpMessage"),
			@Mapping(source = "inquiryFollowUp.followUpNextDate", target = "inquiryFollowUpDO.followUpNextDate"),
			@Mapping(source = "inquiryFollowUp.followUpStatus", target = "inquiryFollowUpDO.followUpStatus"),
			@Mapping(source = "inquiryFollowUp.followedUpCount", target = "inquiryFollowUpDO.followedUpCount") })
	InquiryStudentDO toInquiryStudentDO(InquiryStudentBO inquiryStudentBO);

	@InheritInverseConfiguration
	InquiryStudentBO toInquiryStudentBO(InquiryStudentDO inquiryStudentDO);

	List<InquiryStudentBO> toInquiryStudentBOs(List<InquiryStudentDO> inquiryStudentBOs);

}
