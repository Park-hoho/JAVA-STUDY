package com.yedam.java.quiz4;

public class MainExample {

	public static void main(String[] args) {
		//자동차 공장 싱크톤 + 시리얼넘버 / 안에서 자동차 여러개
		CarFactory factory = CarFactory.getInstance();
		Car firstCar = factory.createCar();
		Car secondCar = factory.createCar();
		System.out.println(firstCar.getCarNumber());
		System.out.println(secondCar.getCarNumber());
	}

}
