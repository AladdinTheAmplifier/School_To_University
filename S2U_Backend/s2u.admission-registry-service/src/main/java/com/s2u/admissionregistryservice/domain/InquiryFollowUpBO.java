package com.s2u.admissionregistryservice.domain;

public class InquiryFollowUpBO {

	private long inquiryCallLogId;

	private String followUpDate;

	private String followUpUser;

	private String followUpMessage;

	private String followUpNextDate;

	private String followUpStatus;

	private int followedUpCount;

	public long getInquiryCallLogId() {
		return inquiryCallLogId;
	}

	public void setInquiryCallLogId(long inquiryCallLogId) {
		this.inquiryCallLogId = inquiryCallLogId;
	}

	public String getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(String followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getFollowUpUser() {
		return followUpUser;
	}

	public void setFollowUpUser(String followUpUser) {
		this.followUpUser = followUpUser;
	}

	public String getFollowUpMessage() {
		return followUpMessage;
	}

	public void setFollowUpMessage(String followUpMessage) {
		this.followUpMessage = followUpMessage;
	}

	public String getFollowUpNextDate() {
		return followUpNextDate;
	}

	public void setFollowUpNextDate(String followUpNextDate) {
		this.followUpNextDate = followUpNextDate;
	}

	public String getFollowUpStatus() {
		return followUpStatus;
	}

	public void setFollowUpStatus(String followUpStatus) {
		this.followUpStatus = followUpStatus;
	}

	public int getFollowedUpCount() {
		return followedUpCount;
	}

	public void setFollowedUpCount(int followedUpCount) {
		this.followedUpCount = followedUpCount;
	}

}
