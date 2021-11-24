package com.yedam.java.quiz2;

public class Subway {
	String lineNumber;
	int money;
	int passengerCount;
	
	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
		this.money = 0;
		this.passengerCount = 0;
	}
	
	public void take(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void showInfo() {
		System.out.printf("지하철 %s의 승객은 %d명이고 수입은 %d원입니다.\n", lineNumber, passengerCount, money);
	}
}
