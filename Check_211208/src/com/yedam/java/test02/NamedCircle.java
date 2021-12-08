package com.yedam.java.test02;

public class NamedCircle extends Circle {
	String name;
	
	public NamedCircle(int radius, String name) {
		super(radius);
		this.name = name;
	}
	
	@Override
	public void show() {
		System.out.println(name + ", 반지름 = " + getRadius());
	}
	
}
