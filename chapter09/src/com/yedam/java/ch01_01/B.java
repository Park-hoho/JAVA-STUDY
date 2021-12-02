package com.yedam.java.ch01_01;

public class B {
	//인스턴스 멤버
	//인스턴스 필드
	X field1 = new X();
	Y field2 = new Y();
	
	//인스턴스 메소드
	void method1() {
		X var1 = new X();
		Y var2 = new Y();
	}
	//정적 멤버
	//정적 필드
	static X field3 = new X();
	static Y field4 = new Y();
	
	//정적 메소드
	static void method2() {
		X var1 = new X();
		Y var1 = new Y();
	}
	//인스턴스 멤버 클래스
	class X {}
	//정적 멤버 클래스
	static class Y {}
}
