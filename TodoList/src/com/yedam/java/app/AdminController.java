package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.java.admins.Admin;
import com.yedam.java.admins.AdminDAOImpl;
import com.yedam.java.users.User;
import com.yedam.java.users.UserDAOImpl;

public class AdminController {
	Scanner sc = new Scanner(System.in);
	
	AdminController() {
		run();
	}
	
	private void run() {
		while(true) {
			showUserInterface();
			System.out.print("메뉴입력>>");
			int selected = sc.nextInt();
			if (selected == 11) {
				searchUser();
			} else if (selected == 12) {
				viewAllUsers();
			} else if (selected == 13) {
				controllWithdrawallUser();
			} else if (selected == 21) {
				countAllTodoList();
			} else if (selected == 22) {
				countAllUsers();
			} else if (selected == 31) {
				addAdmin();
			} else if (selected == 32) {
				modifyAdmin();
			} else if (selected == 33) {
				viewAllAdmins();
			} else if (selected == 0) {
				System.out.println("프로그램 종료");
				System.exit(0);
			}
		}
	}
	
	private void showUserInterface() {
		System.out.println("\nTodo List Application 관리===============================");
		System.out.println(AdminFrame.ADMIN_INFO.getAdminName() + "관리자님 환영합니다.");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("11.유저 정보 찾기   | 21.총 todo 수  | 31.관리자 추가");
		System.out.println("12.모든 유저 목록   | 22.총 유저 수   | 32.관리자 수정");
		System.out.println("13.탈퇴 유저 관리   |               | 33.모든 관리자 리스트");
		System.out.println("0.종료");
	}

	private void viewAllAdmins() {
		List<Admin> adminList = AdminDAOImpl.getInstance().selectAll();
		for (Admin admin : adminList) {
			System.out.println(admin);
		}
	}

	private void modifyAdmin() {
		System.out.println("1.이름 수정  2.아이디 수정  3.비밀번호 수정  9.뒤로가기");
		System.out.print("선택>>");
		int selectedOption = sc.nextInt();
		if (selectedOption == 1) {
			System.out.print("이름>>");
			String name = sc.next();
			AdminDAOImpl.getInstance().updateName(AdminFrame.ADMIN_INFO, name);
			AdminFrame.ADMIN_INFO.setAdminName(name);
		} else if (selectedOption == 2) {
			System.out.print("아이디>>");
			AdminDAOImpl.getInstance().updateId(AdminFrame.ADMIN_INFO, sc.next());
		} else if (selectedOption == 3) {
			System.out.print("비밀번호>>");
			AdminDAOImpl.getInstance().updatePwd(AdminFrame.ADMIN_INFO, sc.next());
		} else if (selectedOption == 9) {
			return;
		} else { System.out.println("잘못된 입력입니다."); }
	}

	private void addAdmin() {
		Admin admin = new Admin();
		System.out.print("관리자 이름>>");
		admin.setAdminName(sc.next());;
		System.out.print("관리자 아이디>>");
		admin.setAdminId(sc.next());
		System.out.print("관리자 비밀번호>>");
		admin.setAdminPwd(sc.next());
		AdminDAOImpl.getInstance().insert(admin);
	}

	private void countAllUsers() {
		System.out.println("총 유저 수: " + UserDAOImpl.getInstance().countAll());
		
	}

	private void countAllTodoList() {
		// TODO Auto-generated method stub
		
	}

	private void controllWithdrawallUser() {
		// TODO Auto-generated method stub
		
	}

	private void viewAllUsers() {
		List<User> userList = UserDAOImpl.getInstance().selectAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}

	private void searchUser() {
		System.out.print("유저 아이디>>");
		User user = UserDAOImpl.getInstance().selectOneId(sc.next());
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("데이터가 없습니다.");
		}
	}

}
