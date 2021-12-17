package com.yedam.java.menu;

public class Menu {
	private int menuId;
	private String menuType;
	private String menuName;
	private int menuPrice;
	private int storeId;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuType=" + menuType + ", menuName=" + menuName + ", menuPrice="
				+ menuPrice + ", storeId=" + storeId + "]";
	}
	
	
}
