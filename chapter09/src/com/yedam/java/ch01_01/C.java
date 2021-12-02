package com.yedam.java.ch01_01;

public class C {
	//인스턴스 멤버
	int field1;
	void method1() {}
	//정적 멤버
	static int field2;
	static void method2() {}
	
	//인스턴스 멤버 클래스
	class X {
		void method() {
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();
		}
	}
	
	//정적 멤버 클래스 - 인스턴스에 대한 정보가 필요가없다.
	static class Y {
		void method() {
			/*
			field1 = 10;
			method1();
			*/
			C c = new C();
			c.field1 = 10;
			c.method1();
			
			field2 = 10;
			method2();
		}
	}
}
