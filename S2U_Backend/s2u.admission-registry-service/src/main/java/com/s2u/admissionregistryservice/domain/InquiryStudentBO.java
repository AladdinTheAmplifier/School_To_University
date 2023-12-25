package com.s2u.admissionregistryservice.domain;

public class InquiryStudentBO {

	private long inquiryStudentId;

	private String inquiryStudentName;

	private String inquiryStudentBirthday;

	private int inquiryStudentAge;

	private String inquiryParentName;

	private String inquiryPhoneNumber;

	private String inquiryWhatsappNumber;

	private String inquiryEmailAddress;

	private String inquiryClassToBeAdmitted;

	private String inquiryPreviousSchool;

	private String inquiryDate;

	private InquiryFollowUpBO inquiryFollowUp;

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

	public String getInquiryDate() {
		return inquiryDate;
	}

	public void setInquiryDate(String inquiryDate) {
		this.inquiryDate = inquiryDate;
	}

	public InquiryFollowUpBO getInquiryFollowUp() {
		return inquiryFollowUp;
	}

	public void setInquiryFollowUp(InquiryFollowUpBO inquiryFollowUp) {
		this.inquiryFollowUp = inquiryFollowUp;
	}

}
