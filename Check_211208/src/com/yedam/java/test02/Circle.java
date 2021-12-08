package com.yedam.java.test02;

public class Circle {
	private int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	public void show() {
		System.out.println("반지름 = " + this.radius);
	}
	public int getRadius() {
		return radius;
	}
}
