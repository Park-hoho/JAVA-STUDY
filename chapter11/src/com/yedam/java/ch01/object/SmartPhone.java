package com.yedam.java.ch01.object;

public class SmartPhone {
	private String com;
	private String os;
	
	SmartPhone(String com, String os) {
		this.com = com;
		this.os = os;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return com + ", " + os;
	}
	
	
}
