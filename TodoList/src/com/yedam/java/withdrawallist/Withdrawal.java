package com.yedam.java.withdrawallist;

import java.sql.Date;

import com.yedam.java.users.User;

public class Withdrawal {
	private int withdrawalId;
	private int userNo;
	private String withdrawalStatus;
	private Date applicationDate;
	private Date completeDate;
	private String withdrawalReason;
	private Date cancelDate;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
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
	
	public long dateCalculation() {
		java.util.Date date = new java.util.Date();
		long calDateDays;

		java.util.Date applyDate = new java.util.Date(this.applicationDate.getTime());
		java.util.Date today = date;
		long calDate = today.getTime() - applyDate.getTime(); 
		calDateDays = calDate / (24*60*60*1000); 
		calDateDays = 30 - Math.abs(calDateDays);
		return calDateDays;
	}
	
	@Override
	public String toString() {
		if (this.user == null) {
			return "Withdrawal [withdrawalId=" + withdrawalId + ", userNo=" + userNo + ", withdrawalStatus="
					+ withdrawalStatus + ", applyDate=" + applicationDate + ", completeDate=" + completeDate
					+ ", withdrawalReason=" + withdrawalReason + ", cancelDate=" + cancelDate + "]";
		} else {
			return "[탈퇴사유: "+withdrawalReason+", 아이디: "+user.getUserId()+", 이름: "+user.getUserName()+", 가입일: "+user.getJoinDate()+
					", 탈퇴신청일: "+applicationDate+", " + dateCalculation() + "일 후 자동DB삭제]";
		}
	}
	
}
