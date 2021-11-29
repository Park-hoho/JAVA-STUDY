package com.yedam.java.ch02_01;

public class MianExample {

	public static void main(String[] args) {
		//=== 자동타입변환
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b2 = d;
		C c2 = e;
		
		// B b3 = e;
		// C c3 = b;
		
		//=== 자동타입변환 후 멤버 접근
		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();
		
		Parent parent = child; // 자동타입 변환
		parent.method1();
		parent.method2();
		// parent.method3();
		
		Parent temp = new Parent();
		temp.method1();
		temp.method2();
		
	}

}
