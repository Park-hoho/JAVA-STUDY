package com.yedam.java.quiz2;

public class Student {
	//필드
	String name;
	int money; //보유하고 있는 돈
	//생성자
	Student(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	//메서드
	//탄다
	public void take(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}
	
	public void take(Subway subway) {
		subway.take(1500);
		this.money -= 1500;
	}
	
	public void take(Taxi taxi) {
		taxi.take(10000);
		this.money -= 10000;
	}
	//학생정보
	public void showInfo() {
		System.out.printf("%s님의 남은 돈은 %d입니다.\n", name, money);
	}
}
