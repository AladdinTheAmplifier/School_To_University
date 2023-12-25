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
@Table(name = "inquiry_follow_up_call_logs")
public class InquiryFollowUpDO implements Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "follow_up_call_log_id")
	private long inquiryCallLogId;

	@Column(name = "follow_up_date")
	private String followUpDate;

	@Column(name = "follow_up_user")
	private String followUpUser;

	@Column(name = "follow_up_message")
	private String followUpMessage;

	@Column(name = "follow_up_next_date")
	private String followUpNextDate;

	@Column(name = "follow_up_status")
	private String followUpStatus;

	@Column(name = "follow_up_count")
	private int followedUpCount;

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "InquiryFollowUpDO [inquiryCallLogId=" + inquiryCallLogId + ", followUpDate=" + followUpDate
				+ ", followUpUser=" + followUpUser + ", followUpMessage=" + followUpMessage + ", followUpNextDate="
				+ followUpNextDate + ", followUpStatus=" + followUpStatus + ", followedUpCount=" + followedUpCount
				+ ", isActive=" + isActive + "]";
	}

}
