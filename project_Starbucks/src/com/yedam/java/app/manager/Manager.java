package com.yedam.java.app.manager;

public class Manager {
	private int managerId;
	private String managerName;
	private String managerPwd;
	private int storeId;
	
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPwd() {
		return managerPwd;
	}
	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public String toString() {
		return "Manager [Id=" + managerId + ", Name=" + managerName + ", Pwd=" + managerPwd
				+ ", 관리매장Id=" + storeId + "]";
	}
	
}
