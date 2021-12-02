package com.yedam.java.ch01_01;

public class OutClassB {
	private int num = 10;
	private static int sNum = 20;
	
	//정적 멤버 클래스
	static class InStaticClass {
		int inNum = 100;
		static int sInNum = 200;
		
		//인스턴스 메서드
		void inTest() {
			System.out.println("InstaticClass inNum = " + inNum 
					+ "(내부 클래스의 인스턴스 변수 사용)");
			System.out.println("InstaticClass sInNum = " + sInNum 
					+ "(내부 클래스의 정적 변수 사용)");
			System.out.println("OutClass nym = " + inNum + 
					"(외부 클래스의 정적 변수 사용)");
		}
		
		//정적 메서드
		static void sTest() {
			System.out.println("InstaticClass sInNum = " + sInNum 
					+ "(내부 클래스의 정적 변수 사용)");
		}
	}
	
}
