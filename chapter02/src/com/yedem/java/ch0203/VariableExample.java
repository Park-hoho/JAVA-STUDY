package com.yedem.java.ch0203;

public class VariableExample {

	public static void main(String[] args) {
		// 자동 타입 변환
		
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue : " + intValue);
		
		char charValue = '가';
		intValue = charValue;
		System.out.println("가의 유니코드 값 : " + intValue);
		
		intValue = 50;
		long longValue = intValue;
		System.out.println("longValue : " + longValue);
		
		longValue = 100;
		float floatValue = longValue;
		System.out.println("floatValue : " + floatValue);
		
		floatValue = 100.5F;
		double doubleValue = floatValue;
		System.out.println("doubleValue : " + doubleValue);
		
		// 강제 타입 변환
		
		intValue = 44032;
		charValue = (char)intValue;
		System.out.println("charValue : " + charValue);
		
		longValue = 500;
		intValue = (int)longValue;
		System.out.println(intValue);
		
		doubleValue = 3.14;
		intValue = (int)doubleValue;
		System.out.println(intValue);
		
		// 정수 타입의 연산
		byte result = 10 + 20;
		System.out.println(result);
		
		byte x = 10;
		byte y = 20;
		int result2 = x + y;
		System.out.println(result2);
		
		byte value1 = 10;
		int value2 = 100;
		long value3 = 1000L;
		
		long result3 = value1 + value2 + value3;
		System.out.println(result3);
		
		// 실수 타입의 연산
		int intV1 = 10;
		float floatV1 = 5.5F;
		double doubleV1 = 4.6;
		
		float result4 = intV1 + floatV1;
		System.out.println(result4);
		
		double result5 = intV1 + doubleV1;
		System.out.println(result5);
		
		// 연산식에서 자동 타입 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		
		byte byteValue3 = (byte)(byteValue1 + byteValue2);
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(byteValue3 + ", " + intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드 : " + intValue2);
		System.out.println("출력문자 : " + (char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3 / 4;
		
		System.out.println(intValue4);
		
		double doubleValue1 = intValue3/4.0;
		System.out.println(doubleValue1);
		
		int x1 = 1;
		int y1 = 2;
		double result1 = x1 / y1;
		System.out.println(result1);
		result1 = (double)x1 / y1;
		// x1 : 1 -> 강제로 1.0
		// y1 : 2 -> 강제로 2.0
		// 1.0 / 2.0 -> 0.5
		System.out.println(result1);
		
		// 문자열 결합 연산
		int value = 10 + 2 + 8;
		System.out.println("value : " + value);
		
		String str1 = 10 + 2 + "8";
		System.out.println("str1 : " + str1);
		
		String str2 = 10 + "2" + 8;
		System.out.println("str2 : " + str2);
		
		String str3 = "10" + 2 + 8;
		System.out.println("str3 : " + str3);
		
		String str4 = "10" + (2 + 8);
		System.out.println("str4 : " + str4);
		
		// 기본 타입과 문자열 간의 변환
		
		int val1 = Integer.parseInt("10");
		double val2 = Double.parseDouble("3.14");
		boolean val3 = Boolean.parseBoolean("true");
		
		System.out.println("val1 : " + val1);
		System.out.println("val2 : " + val2);
		System.out.println("val3 : " + val3);
		
		String str10 = String.valueOf(10);
		String str11 = String.valueOf(3.14);
		String str12 = String.valueOf(true);
		
		System.out.println("str10 : " + str10);
		System.out.println("str11 : " + str11);
		System.out.println("str12 : " + str12);
		
	}

}
