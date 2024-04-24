package com.s2u.admissionregistryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.s2u.admissionregistryservice.entity.InquiryStudentDO;

@Repository
public interface InquiryStudentRepository extends JpaRepository<InquiryStudentDO, Long> {
	
	@Query("SELECT s from InquiryStudentDO s where s.isActive=:isActive")
	List<InquiryStudentDO> findAllActiveInquiryStudentDetails(@Param("isActive") Integer  isActive);

	@Query("SELECT s from InquiryStudentDO s where s.isActive=:isActive and s.inquiryStudentName=:inquiryStudentName and s.inquiryPhoneNumber=:inquiryPhoneNumber")
	InquiryStudentDO findInquiryStudentDetailsIsActive(@Param("inquiryStudentName") String inquiryStudentName,
			@Param("inquiryPhoneNumber") String inquiryPhoneNumber, @Param("isActive") Integer isActive);



}
