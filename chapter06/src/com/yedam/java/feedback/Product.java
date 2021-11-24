package com.yedam.java.feedback;

public class Product {
	//필드
	String name;
	int price;
	
	//생성자
	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
    //메서드
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	
}
