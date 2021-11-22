package com.yedam.java.ch0604;

public class Calculator {
	// 메소드
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double divide(int x, int y) {
		double result = (double) x / y;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x, y);
		double result = sum / 2;
		return result;
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	void execute() {
		double result = avg(7, 10);
		println("실행결과 : " + result);
	}
	
	// 정사각형의 넓이
	double areaRectangle(double width) {
		return width * width;
	}
	
	// 직사각형의 높이
	double areaRectangle(double width, double height) {
		return width * height;
	}
	
	

	
	
	
	
	
	
	
	
}
