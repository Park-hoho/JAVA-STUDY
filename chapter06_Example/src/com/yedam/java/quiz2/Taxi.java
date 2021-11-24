package com.yedam.java.quiz2;

public class Taxi {
	String carNumber;
	int money;
	int passengerCount;
	
	public Taxi(String carNumber) {
		this.carNumber = carNumber;
		this.money = 0;
		this.passengerCount = 0;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.printf("택시 %s의 승객은 %d명이고 수입은 %d원입니다.\n", carNumber, passengerCount, money);
	}
}
