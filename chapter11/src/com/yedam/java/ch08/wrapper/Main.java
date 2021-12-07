package com.yedam.java.ch08.wrapper;

public class Main {

	public static void main(String[] args) {
		// 박싱 : 기본 타입의 값을 포장 객체로 만드는 과정
		// 언박싱 : 포장 객체에서 기본 타입의 값을 얻어내는 과정
		
		Integer obj1 = Integer.valueOf("300");
		int value1 = obj1.intValue();
		
		// 자동 박싱과 언박싱
		Integer obj2 = 100;
		System.out.println("value : " + obj2.intValue());
		
		// 자동 언박싱
		int value2 = obj2;
		System.out.println("value : " + value2);
		
		// 연산 시 자동 언박싱
		int result = obj2 + 100;
		System.out.println("result : " + result);
		
		// 문자열을 기본 타입 값으로 변환
		int val1 = Integer.parseInt("10");
		double val2 = Double.parseDouble("3.14");
		boolean val3 = Boolean.parseBoolean("true");
		
		System.out.println("val1 : " + val1);
		System.out.println("val2 : " + val2);
		System.out.println("val3 : " + val3);
		System.out.println();
		
		// 포장 객체 비교
		System.out.println("[-128 ~ 127] 초과값일 경우");
		Integer obj4 = 300;
		Integer obj5 = 300;
		System.out.println("결과:" + (obj4==obj5));
		System.out.println("언박싱 후:" + (obj4.intValue()==obj5.intValue()));
		System.out.println("equals():" + (obj4.equals(obj5)));
		System.out.println();
		
		System.out.println("[-128 ~ 127] 범위값일 경우");
		Integer obj6 = 10;
		Integer obj7 = 10;
		System.out.println("결과:"+(obj6==obj7));
		System.out.println("언박싱 후:" + (obj6.intValue()==obj7.intValue()));
		System.out.println("equals():" + (obj6.equals(obj7)));
		System.out.println();
		
	}

}
