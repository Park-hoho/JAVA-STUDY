package com.yedam.java.ch01_01;

public class A {
	public A() {
		System.out.println("A객체가 생성됨.");
	}
	
	//인스턴스 멤버 클래스
	public class B{
		//필드
		int field;
		//static int field2; //사용 불가
		
		//생성자
		public B() {
			System.out.println("B객체가 생성됨.");
		}
		//메소드
		void method1() {}
		//static void method2() {} //사용 불가
	}
	
	//정적 멤버 클래스
	static class C {
		//필드
		int field1;
		static int field2;
		//생성자
		C() {
			System.out.println("C객체가 생성됨.");
		}
		//메서드
		void method1() {}
		static void method2() {}
	}
	
	//로컬 멤버 클래스
	void method() {
		class D{
			//필드
			int field1;
			//static int field2; //사용 불가
			//생성자
			D() {
				System.out.println("D객체가 생성됨.");
			}
			//메소드
			void method1() {}
			//static void method2() {} //사용 불가
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
	
}
