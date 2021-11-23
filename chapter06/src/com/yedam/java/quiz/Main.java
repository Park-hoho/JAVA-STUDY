package com.yedam.java.quiz;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// 문제 1)
		Person james = new Person("james", 40, "남");
		james.isMarried(true);
		james.setChildren(3);
		System.out.println("이 사람의 나이 : " + james.getAge());
		System.out.println("이 사람의 이름 : " + james.getName());
		System.out.println("이 사람의 결혼 여부 : " + james.isMarried());
		System.out.println("이 사람의 자녀 수 : " + james.getChildren());
		
		System.out.println();
		// 문제 2)
		Order order1 = new Order(
				"201803120001", "abc123", "20180312", "홍길순", "PD0345-12",
				"서울시 영등포구 여의도동 20번지");
		order1.printReceipt();
		
		System.out.println();
		// 문제 3)
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		excute(x, y);
		scanner.close();
	}
	public static int plus(int x, int y) {
		return x + y;
	}
	
	public static int minus(int x, int y) {
		return x - y;
	}
	
	public static int multi(int x, int y) {
		return x * y;
	}
	
	public static int divide(int x, int y) {
		return x / y;
	}
	
	public static void excute(int x, int y) {
		System.out.println("+ : " + plus(x, y));
		System.out.println("- : " + minus(x, y));
		System.out.println("* : " + multi(x, y));
		System.out.println("/ : " + divide(x, y));
//		System.out.printf("%d + %d = %d\n", x, y, plus(x, y) );
//		System.out.printf("%d - %d = %d\n", x, y, minus(x, y) );
//		System.out.printf("%d * %d = %d\n", x, y, multi(x, y) );
//		System.out.printf("%d / %d = %d\n", x, y, divide(x, y) );
	}
}
