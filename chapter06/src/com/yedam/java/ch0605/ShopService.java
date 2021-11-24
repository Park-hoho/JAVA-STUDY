package com.yedam.java.ch0605;

public class ShopService {
	private static ShopService instance = new ShopService(); // 힙영역에 객체가 생성됨
	private ShopService() {}
	
	static ShopService getInstance() {
		return instance;
	}
}
