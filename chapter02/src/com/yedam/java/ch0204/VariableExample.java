package com.yedam.java.ch0204;

import java.io.IOException;
import java.util.Scanner;

public class VariableExample {

	public static void main(String[] args) throws IOException {
		// print
		System.out.print("오늘 날짜는");
		System.out.print("2021년");
		System.out.print("11월 15일 입니다.\n");

		// printf
		int x = 1;
		int y = 2;
		System.out.println("x : " + x + ", y : " + y);
		System.out.printf("x : %d, y : %d\n", x, y);
		
		int result = x + y;
		System.out.printf("%d + %d = %d\n", x, y, result);
		
		int value = 123;
		System.out.printf("상품의 가격 : %d\n", value);
		System.out.printf("상품의 가격 : %6d\n", value);
		System.out.printf("상품의 가격 : %-6d\n", value);
		System.out.printf("상품의 가격 : %06d\n", value);
		
		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, area);
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s\n", 1, name, job);
		
		// System.in.read()
		int keyCode;
		/*
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		while(true) {
			keyCode = System.in.read();
			System.out.println("keyCode : " + keyCode);
			if(keyCode == 113) {
				break;
			}
		}
		*/
		// Scanner
		Scanner scanner = new Scanner(System.in);
		String inputData;
		
		while(true) {
			inputData = scanner.nextLine();
			if(inputData.equals("exit")) {
				break;
			} else {
				System.out.printf("입력된 문자열 : \"%s\" \n", inputData);				
			}
		}
		System.out.println("종료합니다.");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
