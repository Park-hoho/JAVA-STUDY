package com.yedam.java.quiz;

public class Main {
	
	public static void main(String[] args) {
		// 문제 1)
		Person man = new Person(40, "james", true, 3);
		man.printInfo();
		
		System.out.println();
		// 문제 2)
		Order order = new Order(
				201803120001L, "abc123", "20180312", "홍길순", "PD0345-12",
				"서울시 영등포구 여의도동 20번지");
		order.printReceipt();
		
		System.out.println();
		// 문제 3)
		Order myCalc = new Order();
		
		myCalc.plus(5, 6);
		myCalc.minus(26, 14);
		myCalc.times(2, 4);
		myCalc.divide(10, 2);
		
	}
	
}
