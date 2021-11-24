package com.yedam.java.quiz4;

public class CarFactory {
	private static CarFactory instance = new CarFactory();
	
	private CarFactory() {}
	
	public static CarFactory getInstance() {
		return instance;
	}
	
	public Car createCar() { // 이거 이해안감
		return new Car();
	}
}
