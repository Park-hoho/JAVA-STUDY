package com.yedam.java.check;

public class Rectangle {
	private double width;
	private double height;
	
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getCircumference() {
		return (width + height)*2;
	}
}
