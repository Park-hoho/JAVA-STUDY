package com.yedam.java.quiz;

public class Order {
	//필드
	String no;
	String id;
	String date;
	String name;
	String productNumber;
	String address;
	
	//생성자
	Order() {
		
	}
	Order(
			String no, 
			String id, 
			String date, 
			String name, 
			String productNumber,
			String address ) {
		this.no = no;
		this.id = id;
		this.date = date;
		this.name = name;
		this.productNumber = productNumber;
		this.address = address;
	}
	
	//메서드
	void printReceipt() {
		System.out.println("주문 번호 : " + this.no);
		System.out.println("주문자 아이디 : " + this.id);
		System.out.println("주문 날짜 : " + this.date);
		System.out.println("주문자 이름 : " + this.name);
		System.out.println("주문 상품 번호 : " + this.productNumber);
		System.out.println("배송 주소 : " + this.address);
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	int minus(int x, int y) {
		int result = x - y;
		return result;
	}
	
	int times(int x, int y) {
		int result = x * y;
		return result;
	}
	
	double divide(int x, int y) {
		double result = (double) x / y;
		return result;
	}
	
}
