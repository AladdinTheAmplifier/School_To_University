package com.s2u.admissionregistryservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.s2u.admissionregistryservice.config.Auditable;

@Entity
@Table(name = "inquiry_student_details")
public class InquiryStudentDO implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inquiry_student_id", unique = true)
	private Long inquiryStudentId;

	@Column(name = "inquiry_student_name")
	private String inquiryStudentName;

	@Column(name = "inquiry_student_birthday")
	private String inquiryStudentBirthday;

	@Column(name = "inquiry_student_age")
	private int inquiryStudentAge;

	@Column(name = "inquiry_parent_name")
	private String inquiryParentName;

	@Column(name = "inquiry_phone_number")
	private String inquiryPhoneNumber;

	@Column(name = "inquiry_whatsapp_number")
	private String inquiryWhatsappNumber;

	@Column(name = "inquiry_email_address")
	private String inquiryEmailAddress;

	@Column(name = "inquiry_class_to_be_admitted")
	private String inquiryClassToBeAdmitted;

	@Column(name = "inquiry_previous_school")
	private String inquiryPreviousSchool;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "follow_up_call_log_id")
	private InquiryFollowUpDO inquiryFollowUpDO;

	@Column(name = "is_active")
	private int isActive;

	@Embedded
	public AuditModel auditModel;

	@Override
	public AuditModel getAudit() {

		return auditModel;
	}

	@Override
	public void setAudit(AuditModel audit) {
		this.auditModel = audit;

	}

	public long getInquiryStudentId() {
		return inquiryStudentId;
	}

	public void setInquiryStudentId(long inquiryStudentId) {
		this.inquiryStudentId = inquiryStudentId;
	}

	public String getInquiryStudentName() {
		return inquiryStudentName;
	}

	public void setInquiryStudentName(String inquiryStudentName) {
		this.inquiryStudentName = inquiryStudentName;
	}

	public String getInquiryStudentBirthday() {
		return inquiryStudentBirthday;
	}

	public void setInquiryStudentBirthday(String inquiryStudentBirthday) {
		this.inquiryStudentBirthday = inquiryStudentBirthday;
	}

	public int getInquiryStudentAge() {
		return inquiryStudentAge;
	}

	public void setInquiryStudentAge(int inquiryStudentAge) {
		this.inquiryStudentAge = inquiryStudentAge;
	}

	public String getInquiryParentName() {
		return inquiryParentName;
	}

	public void setInquiryParentName(String inquiryParentName) {
		this.inquiryParentName = inquiryParentName;
	}

	public String getInquiryPhoneNumber() {
		return inquiryPhoneNumber;
	}

	public void setInquiryPhoneNumber(String inquiryPhoneNumber) {
		this.inquiryPhoneNumber = inquiryPhoneNumber;
	}

	public String getInquiryWhatsappNumber() {
		return inquiryWhatsappNumber;
	}

	public void setInquiryWhatsappNumber(String inquiryWhatsappNumber) {
		this.inquiryWhatsappNumber = inquiryWhatsappNumber;
	}

	public String getInquiryEmailAddress() {
		return inquiryEmailAddress;
	}

	public void setInquiryEmailAddress(String inquiryEmailAddress) {
		this.inquiryEmailAddress = inquiryEmailAddress;
	}

	public String getInquiryClassToBeAdmitted() {
		return inquiryClassToBeAdmitted;
	}

	public void setInquiryClassToBeAdmitted(String inquiryClassToBeAdmitted) {
		this.inquiryClassToBeAdmitted = inquiryClassToBeAdmitted;
	}

	public String getInquiryPreviousSchool() {
		return inquiryPreviousSchool;
	}

	public void setInquiryPreviousSchool(String inquiryPreviousSchool) {
		this.inquiryPreviousSchool = inquiryPreviousSchool;
	}

	public InquiryFollowUpDO getInquiryFollowUpDO() {
		return inquiryFollowUpDO;
	}

	public void setInquiryFollowUpDO(InquiryFollowUpDO inquiryFollowUpDO) {
		this.inquiryFollowUpDO = inquiryFollowUpDO;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public AuditModel getAuditModel() {
		return auditModel;
	}

	public void setAuditModel(AuditModel auditModel) {
		this.auditModel = auditModel;
	}

	@Override
	public String toString() {
		return "InquiryStudentDO [inquiryStudentId=" + inquiryStudentId + ", inquiryStudentName=" + inquiryStudentName
				+ ", inquiryStudentBirthday=" + inquiryStudentBirthday + ", inquiryStudentAge=" + inquiryStudentAge
				+ ", inquiryParentName=" + inquiryParentName + ", inquiryPhoneNumber=" + inquiryPhoneNumber
				+ ", inquiryWhatsappNumber=" + inquiryWhatsappNumber + ", inquiryEmailAddress=" + inquiryEmailAddress
				+ ", inquiryClassToBeAdmitted=" + inquiryClassToBeAdmitted + ", inquiryPreviousSchool="
				+ inquiryPreviousSchool + ", inquiryFollowUpDO=" + inquiryFollowUpDO + ", isActive=" + isActive
				+ ", auditModel=" + auditModel + "]";
	}

}
