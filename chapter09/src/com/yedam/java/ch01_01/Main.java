package com.yedam.java.ch01_01;

public class Main {

	public static void main(String[] args) {
		// 중첩 클래스 객체 생성
		A a = new A();
		System.out.println();
		
		// 인스턴스 멤법 클래스 객체 생성
		A.B b = a.new B(); 
		b.field = 3;
		b.method1();
		System.out.println();
		
		//정적 멤버 클래스 객체 생성
		A.C c = new A.C();
		//정적 멤버 클래스 내부 인스턴스 멤버 접근
		c.field1 = 3;
		c.method1();
		//정적 멤버 클래스 내부 정적 멤버 접근
		A.C.field2 = 3;
		A.C.method2();
		
		//로컬 클래스
		a.method();
		
		//인스턴스 내부 클래스 예제
		OutClassA outClassA = new OutClassA();
		System.out.println("외부 클래스 이용하여 내부 클래스 사용");
		outClassA.usingClass();
		System.out.println();
		
		OutClassB.InStaticClass sInClass = new OutClassB.InStaticClass();
		System.out.println("정적 내부 클래스의 인스턴스 메서드 호출");
		sInClass.inTest();
		System.out.println("22");
		OutClassB.InStaticClass.sTest();
		System.out.println();
		
		Outer out = new Outer();
		Runnable runner = out.getRunnable(10);
		
		runner.run();
		System.out.println();
		
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested();
		nested.print();
	}

}
