package com.yedam.java.paymentHistory;

import java.sql.Date;

public class Payment {
	private int paymentId;
	private int menuId;
	private int storeId;
	private int customerId;
	private int totalPrice;
	private int waitingNumber;
	private Date paymentDate;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getWaitingNumber() {
		return waitingNumber;
	}
	public void setWaitingNumber(int waitingNumber) {
		this.waitingNumber = waitingNumber;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", menuId=" + menuId + ", storeId=" + storeId + ", customerId="
				+ customerId + ", totalPrice=" + totalPrice + ", waitingNumber=" + waitingNumber + ", paymentDate="
				+ paymentDate + "]";
	}
	
}
