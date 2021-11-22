package com.yedam.java.ch0603;

public class MainExample {

	public static void main(String[] args) {
		// 생성자를 호출해서 객체 생성
		Car car = new Car("검정", 3000);
		
		// 생성자에서 필드 초기화
		Korean k1 = new Korean("박자바", "011225-1234567");
		System.out.println("k1.name : " + k1.name);
		System.out.println("k1.ssn : " + k1.ssn);
		
		Korean k2 = new Korean("김자바", "930525-0654321");
		System.out.println("k2.name : " + k2.name);
		System.out.println("k2.ssn : " + k2.ssn);
		
		// 인스턴스 생성 시 생성자를 선택
	
		
	}

}
