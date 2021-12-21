package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.admins.Admin;

public class AdminController {
	Scanner sc = new Scanner(System.in);
	Admin admin;
	
	AdminController() {
		admin = AdminFrame.ADMIN_INFO;
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("\nTodo List Application 관리============================================");
			System.out.println(admin.getAdminName() + "관리자님 환영합니다.");
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1.유저관리 1.유저 정보 찾기   2.통계 1.모든 todo수  3.관리자 관리 1.관리자 추가");
			System.out.println("      ㅡ 2.모든 유저 리스트     ㅡ 2.총 유저 수            ㅡ 2.관리자 수정");
			System.out.println("      ㅡ 3.탈퇴 유저 관리                              ㅡ 3.모든 관리자 리스트");
			System.out.println("0.종료");
			System.out.println();
			System.out.print("메뉴입력>>");
			int selected = sc.nextInt();
			if (selected == 11) {
				
			} else if (selected == 12) {
				
			} else if (selected == 13) {
				
			} else if (selected == 21) {
				
			} else if (selected == 22) {
				
			} else if (selected == 31) {
				
			} else if (selected == 32) {
				
			} else if (selected == 33) {
				
			} else if (selected == 0) {
				
			}
		}
	}
}
