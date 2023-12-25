package com.s2u.admissionregistryservice.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.s2u.admissionregistryservice.config.Auditable;
 

@Entity
@Table(name = "school_received_call_logs")
public class SchoolReceivedCallLogsDO implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inquiry_call_log_id")
	private long inquiryCallLogId;

	@Column(name = "inquiry_caller_name")
	private String inquiryCallerName;

	@Column(name = "inquiry_contact_no")
	private String inquiryContactNo;

	@Column(name = "inquiry_caller_purpose")
	private String inquiryCallerPurpose;

	@Column(name = "inquiry_concerned_person")
	private String inquiryConcernedPerson;

	@Column(name = "inquiry_call_date_time")
	private String inquiryCallDateAndTime;

	@Column(name = "inquiry_caller_message")
	private String inquiryCallerMessage;

	@Column(name = "inquiry_caller_status")
	private String inquiryCallerStatus;

	@Column(name = "is_active")
	private boolean isActive;

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

	public long getInquiryCallLogId() {
		return inquiryCallLogId;
	}

	public void setInquiryCallLogId(long inquiryCallLogId) {
		this.inquiryCallLogId = inquiryCallLogId;
	}

	public String getInquiryCallerName() {
		return inquiryCallerName;
	}

	public void setInquiryCallerName(String inquiryCallerName) {
		this.inquiryCallerName = inquiryCallerName;
	}

	public String getInquiryContactNo() {
		return inquiryContactNo;
	}

	public void setInquiryContactNo(String inquiryContactNo) {
		this.inquiryContactNo = inquiryContactNo;
	}

	public String getInquiryCallerPurpose() {
		return inquiryCallerPurpose;
	}

	public void setInquiryCallerPurpose(String inquiryCallerPurpose) {
		this.inquiryCallerPurpose = inquiryCallerPurpose;
	}

	public String getInquiryConcernedPerson() {
		return inquiryConcernedPerson;
	}

	public void setInquiryConcernedPerson(String inquiryConcernedPerson) {
		this.inquiryConcernedPerson = inquiryConcernedPerson;
	}

	public String getInquiryCallDateAndTime() {
		return inquiryCallDateAndTime;
	}

	public void setInquiryCallDateAndTime(String inquiryCallDateAndTime) {
		this.inquiryCallDateAndTime = inquiryCallDateAndTime;
	}

	public String getInquiryCallerMessage() {
		return inquiryCallerMessage;
	}

	public void setInquiryCallerMessage(String inquiryCallerMessage) {
		this.inquiryCallerMessage = inquiryCallerMessage;
	}

	public String getInquiryCallerStatus() {
		return inquiryCallerStatus;
	}

	public void setInquiryCallerStatus(String inquiryCallerStatus) {
		this.inquiryCallerStatus = inquiryCallerStatus;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "SchoolReceivedCallLogsDO [inquiryCallLogId=" + inquiryCallLogId + ", inquiryCallerName="
				+ inquiryCallerName + ", inquiryContactNo=" + inquiryContactNo + ", inquiryCallerPurpose="
				+ inquiryCallerPurpose + ", inquiryConcernedPerson=" + inquiryConcernedPerson
				+ ", inquiryCallDateAndTime=" + inquiryCallDateAndTime + ", inquiryCallerMessage="
				+ inquiryCallerMessage + ", inquiryCallerStatus=" + inquiryCallerStatus + ", isActive=" + isActive
				+ "]";
	}

}
