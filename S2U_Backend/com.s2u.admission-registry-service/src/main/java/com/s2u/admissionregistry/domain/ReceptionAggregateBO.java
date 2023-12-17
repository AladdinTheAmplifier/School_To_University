package com.s2u.admissionregistry.domain;

import java.util.List;

public class ReceptionAggregateBO {

	private InquiryStudentBO inquiryStudent;

	private List<InquiryStudentBO> inquiryStudents;

	private SchoolReceivedCallLogsBO schoolReceivedCallLog;

	private List<SchoolReceivedCallLogsBO> schoolReceivedCallLogs;

	public InquiryStudentBO getInquiryStudent() {
		return inquiryStudent;
	}

	public void setInquiryStudent(InquiryStudentBO inquiryStudent) {
		this.inquiryStudent = inquiryStudent;
	}

	public List<InquiryStudentBO> getInquiryStudents() {
		return inquiryStudents;
	}

	public void setInquiryStudents(List<InquiryStudentBO> inquiryStudents) {
		this.inquiryStudents = inquiryStudents;
	}

	public SchoolReceivedCallLogsBO getSchoolReceivedCallLog() {
		return schoolReceivedCallLog;
	}

	public void setSchoolReceivedCallLog(SchoolReceivedCallLogsBO schoolReceivedCallLog) {
		this.schoolReceivedCallLog = schoolReceivedCallLog;
	}

	public List<SchoolReceivedCallLogsBO> getSchoolReceivedCallLogs() {
		return schoolReceivedCallLogs;
	}

	public void setSchoolReceivedCallLogs(List<SchoolReceivedCallLogsBO> schoolReceivedCallLogs) {
		this.schoolReceivedCallLogs = schoolReceivedCallLogs;
	}

}
