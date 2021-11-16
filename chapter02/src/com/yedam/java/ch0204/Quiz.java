package com.yedam.java.ch0204;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		// P99, 문제2번
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 수:");
		String strNum1 = scanner.nextLine();
		
		System.out.print("두번째 수:");
		String strNum2 = scanner.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println("덧셈 결과:" + result);	
		
		// P99, 문제3번
		System.out.println("[필수 정보 입력]");	
		System.out.print("1. 이름:");
		String name = scanner.nextLine();
		System.out.print("2. 주민번호 앞 6자리:");
		String birth = scanner.nextLine();
		System.out.print("3. 전화번호:");
		String phone = scanner.nextLine();
		
		System.out.println();	
		System.out.println("[입력한 내용]");	
		System.out.printf("%s\n", name);	
		System.out.printf("%s\n", birth);	
		System.out.printf("%s\n", phone);	

	}

}
