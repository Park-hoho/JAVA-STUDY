package com.yedam.java.app;

import java.util.Scanner;

public class CustomerController {
	Scanner sc = new Scanner(System.in);
	
	void run() {
		while(true) {
			System.out.println();
			System.out.println("1.매장선택  2.회원정보조회  3.회원정보수정");
			int selected = sc.nextInt();
			if (selected == 1) {
				
			} else if (selected == 2) {
				
			} else if (selected == 3) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}
