package com.yedam.java.check2;

public class Circle {
	private double x, y;
	private int radius;
		
	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public void show() {
		System.out.println("("+x+","+y+")"+radius);
	}
}
