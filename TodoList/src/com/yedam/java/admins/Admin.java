package com.yedam.java.admins;

public class Admin {
	private int adminNo;
	private String adminName;
	private String adminId;
	private String adminPwd;
	
	public int getAdminNo() {
		return adminNo;
	}
	public void setAdminNo(int adminNo) {
		this.adminNo = adminNo;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	
	@Override
	public String toString() {
		return "Admin [adminNo=" + adminNo + ", adminName=" + adminName + ", adminId=" + adminId + ", adminPwd="
				+ adminPwd + "]";
	}
	
}
