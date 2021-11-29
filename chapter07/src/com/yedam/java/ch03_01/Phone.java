package com.yedam.java.ch03_01;

public abstract class Phone {
	//field
	public String owner;
	
	//constructor - 자식클래스에서 호출하기위해 만듬
	public Phone(String owner) {
		this.owner = owner;
	}
	
	//method
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("폰 전원을 끕니다.");
	}
}
