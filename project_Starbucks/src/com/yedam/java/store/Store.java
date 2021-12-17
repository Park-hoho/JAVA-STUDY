package com.yedam.java.store;

public class Store {
	private int storeid;
	private String storeName;
	private String storeLocation;
	
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	@Override
	public String toString() {
		return "Store [storeid=" + storeid + ", storeName=" + storeName + ", storeLocation=" + storeLocation + "]";
	}
	
}
