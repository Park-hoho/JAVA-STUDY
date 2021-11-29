package com.yedam.java.ch03_01;

public abstract class Animal {
	//field
	public String kind;

	//constructor
	Animal() {}
	
	//method
	public void breath() {
		System.out.println("숨을 쉽니다.");
	}
	
	public abstract void sound();
}
