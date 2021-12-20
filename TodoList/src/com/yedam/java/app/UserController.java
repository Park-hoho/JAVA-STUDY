package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.users.User;

public class UserController {
	Scanner sc = new Scanner(System.in);
	User user = null;
	String userName;
	
	
	protected UserController(User user) {
		if (user != null) {
			this.user = user;
			userName = user.getUserName();
			getUserTodoList();
			getUserGrade();
			run();
		}
	}
	
	private void getUserGrade() {
		// TODO 유저 등급
		
	}

	private void getUserTodoList() {
		// TODO 유저가 보유한 리스트
		
	}

	private void run() {
		while(true) {
			System.out.println();
			System.out.println("==================================================");
			System.out.println(user.getUserName()+"님 환영합니다.  |  완료된 할 일: 2013  |  등급 : 실버");
			System.out.println("오늘 : 2021-12-20 월요일");
			System.out.println("===할 일 목록(3개)===================================");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1.할 일 추가  2.완료 목록 보기  3.정렬  9.내정보 관리  0.종료");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			String selected = sc.next();
			
			if (selected == "1") {
				
			}
		}
	}
	
}
