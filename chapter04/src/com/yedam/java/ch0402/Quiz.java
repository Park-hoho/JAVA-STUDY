package com.yedam.java.ch0402;

import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		//문제2)
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i%3 == 0) {
				sum += i;
			}
		}
		System.out.println("3의 배수 총합 : " + sum);
		
		System.out.println("문제3)");
		//문제3)
		int val1;
		int val2;
		while(true) {
			val1 = (int)(Math.random() * 6) + 1;
			val2 = (int)(Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", val1, val2);
			if (val1 + val2 == 5)
				break;
		}
		System.out.println("문제4)");
		//문제4)
		int x, y;
		
		for (x = 1; x <= 10; x++) {
			for (y = 1; y <= 10; y++) {
				if ((4*x)+(5*y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		System.out.println("문제5)");
		//문제5)
		for (x = 1; x < 5; x++) {
			for (y = 1; y <= x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("문제6)");
		//문제6)
		for (x = 1; x < 5; x++) {
			for (y = 5; y > 0; y--) {
				if (x < y) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		System.out.println("문제7)");
		//문제7)
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int number = scanner.nextInt();
			
			switch(number) {
			case 1:
				System.out.print("예금액>");
				balance += scanner.nextInt();
				break;
			case 2:
				System.out.print("출금액>");
				balance -= scanner.nextInt();
				break;
			case 3:
				System.out.println("잔고>" + balance);
				break;
			case 4:
				run = false;
				break;
				
			}
		}
		scanner.close();
		System.out.println("프로그램 종료");
	}

}
