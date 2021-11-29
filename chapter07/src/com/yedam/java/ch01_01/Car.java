package com.yedam.java.ch01_01;

public class Car {
	//field
	public int speed;
	//constructor
	
	//method
	public void speedUp() {
		speed++;
	}
	
	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
