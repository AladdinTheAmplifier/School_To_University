package com.s2u.admissionregistryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.s2u.admissionregistryservice.domain.InquiryStudentBO;
import com.s2u.admissionregistryservice.entity.InquiryStudentDO;

@Repository
public interface InquiryStudentRepository extends JpaRepository<InquiryStudentDO, Long> {
	
	@Query("SELECT s from InquiryStudentDO where s.isActive=:isActive and s.inquiryStudentName=:inquiryStudentName")
	InquiryStudentDO findInquiryStudentDetailsIsActive(InquiryStudentBO inquiryStudentBO);

}
