package com.yedam.java.app.customer;

public class Customer {
	private int customerId;
	private String customerEmail;
	private String customerName;
	private String customerPwd;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerEmail=" + customerEmail + ", customerName="
				+ customerName + ", customerPwd=" + customerPwd + "]";
	}
	
}
