package com.yedam.java.quiz4;

public class Car {
	//필드
	private static int serialNum = 1000;//기준이 되는 시리얼 넘버
	
	private int carNumber;
	//자동차 고유 번호
	
	//생성자
	public Car() {
		Car.serialNum++;
		this.carNumber = serialNum;
	}
	
	//메서드
	public static void setSerialNum(int serialNum) {
		Car.serialNum = serialNum;
	}
	
	public static int getSerialNum() {
		return Car.serialNum;
	}
	
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	
	public int getCarNumber() {
		return carNumber;
	}
}
