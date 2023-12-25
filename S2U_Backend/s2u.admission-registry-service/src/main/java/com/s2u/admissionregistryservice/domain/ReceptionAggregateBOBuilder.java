package com.s2u.admissionregistryservice.domain;

import java.util.List;

public class ReceptionAggregateBOBuilder {

	private InquiryStudentBO inquiryStudent;

	private List<InquiryStudentBO> inquiryStudents;

	private SchoolReceivedCallLogsBO schoolReceivedCallLog;

	private List<SchoolReceivedCallLogsBO> schoolReceivedCallLogs;

	public static ReceptionAggregateBOBuilder create() {
		return new ReceptionAggregateBOBuilder();
	}

	public ReceptionAggregateBOBuilder withInquiryStudent(InquiryStudentBO inquiryStudent) {
		this.inquiryStudent = inquiryStudent;
		return this;
	}

	public ReceptionAggregateBOBuilder withInquiryStudents(List<InquiryStudentBO> inquiryStudents) {
		this.inquiryStudents = inquiryStudents;
		return this;
	}

	public ReceptionAggregateBO build() {
		ReceptionAggregateBO receptionAggregateBO = new ReceptionAggregateBO();
		receptionAggregateBO.setInquiryStudent(inquiryStudent);
		receptionAggregateBO.setInquiryStudents(inquiryStudents);
		return receptionAggregateBO;
	}
}
