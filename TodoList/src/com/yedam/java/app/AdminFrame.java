package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.admins.Admin;
import com.yedam.java.admins.AdminDAOImpl;

public class AdminFrame {
	Scanner sc = new Scanner(System.in);
	public static Admin ADMIN_INFO;
	
	public AdminFrame() {
		while(true) {
			System.out.println();
			System.out.println("================================");
			System.out.println("1.관리자 로그인  2.종료");
			System.out.println("================================");
			System.out.print("선택>>");
			int selected = sc.nextInt();
			if (selected == 1) {
				adminLogin();
			} else if (selected == 2) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	private void adminLogin() {
		Admin admin = inputLogin();
		if (admin != null) {
			ADMIN_INFO = admin;
			new AdminController();
		}
	}

	private Admin inputLogin() {
		System.out.print("아이디>>");
		String id = sc.next();
		System.out.print("비밀번호>>");
		String password = sc.next();
		Admin admin = AdminDAOImpl.getInstance().checklogin(id, password);
		if (admin.getAdminNo() == 0 || admin.getAdminId() == null) {
			System.out.println("아이디 또는 비밀번호가 잘 못되었습니다.");
			return null;
		} else {
			System.out.println("로그인 성공!");
			return admin;
		}
	}
	
}
