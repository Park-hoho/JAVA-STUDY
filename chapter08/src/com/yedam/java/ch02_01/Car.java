package com.yedam.java.ch02_01;

public class Car {
	//field
	Tire frontLeftTire = new HankookTire();
	Tire frontRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRightTire = new HankookTire();
	
	//method
//	void run() {
//		frontLeftTire.roll();
//		frontRightTire.roll();
//		backLeftTire.roll();
//		backRightTire.roll();
//	}
	
	Tire[] tires = {
		new HankookTire(),
		new HankookTire(),
		new HankookTire(),
		new HankookTire(),
	};
	
	void run() {
		for(Tire tire : tires) {
			tire.roll();
		}
	}
}
