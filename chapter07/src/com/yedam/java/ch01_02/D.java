package com.yedam.java.ch01_02;

import com.yedam.java.ch01_01.A;

public class D extends A {
	public D() {
		super();
		this.field = "value";
		this.method();	
	}
	/*
	public void method() {
		A a = new A();
		a.field = "Value";
		a.method();
	}
	*/
}
