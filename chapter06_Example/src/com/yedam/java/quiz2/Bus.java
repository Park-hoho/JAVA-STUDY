package com.yedam.java.quiz2;

public class Bus {
	int busNumber;
	int money;
	int passengerCount;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
		this.money = 0;
		this.passengerCount = 0;
	}
	
	public void take(int money) {
		this.money += money;
		passengerCount++;
	}
	
	public void showInfo() {
		System.out.printf("버스 %d번의 승객은 %d명이고 수입은 %d원입니다.\n", busNumber, passengerCount, money);
	}
}
