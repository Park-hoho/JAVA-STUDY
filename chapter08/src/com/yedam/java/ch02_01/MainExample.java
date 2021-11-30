package com.yedam.java.ch02_01;

public class MainExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		System.out.println();
		
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
		myCar.run();
	}

}
