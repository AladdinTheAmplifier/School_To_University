package com.s2u.admissionregistry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.s2u.admissionregistry.entity.InquiryStudentDO;

@Repository
public interface InquiryStudentRepository extends JpaRepository<InquiryStudentDO, Long> {

}
