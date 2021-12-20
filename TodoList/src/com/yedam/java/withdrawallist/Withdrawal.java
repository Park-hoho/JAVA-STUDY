package com.yedam.java.withdrawallist;

import java.sql.Date;

public class Withdrawal {
	private int withdrawalId;
	private int userNo;
	private String withdrawalStatus;
	private Date applicationDate;
	private Date completeDate;
	private String withdrawalReason;
	private Date cancelDate;
	
	public int getWithdrawalId() {
		return withdrawalId;
	}
	public void setWithdrawalId(int withdrawalId) {
		this.withdrawalId = withdrawalId;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getWithdrawalStatus() {
		return withdrawalStatus;
	}
	public void setWithdrawalStatus(String withdrawalStatus) {
		this.withdrawalStatus = withdrawalStatus;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public Date getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}
	public String getWithdrawalReason() {
		return withdrawalReason;
	}
	public void setWithdrawalReason(String withdrawalReason) {
		this.withdrawalReason = withdrawalReason;
	}
	public Date getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
	@Override
	public String toString() {
		return "Withdrawal [withdrawalId=" + withdrawalId + ", userNo=" + userNo + ", withdrawalStatus="
				+ withdrawalStatus + ", applicationDate=" + applicationDate + ", completeDate=" + completeDate
				+ ", withdrawalReason=" + withdrawalReason + ", cancelDate=" + cancelDate + "]";
	}
	
}
