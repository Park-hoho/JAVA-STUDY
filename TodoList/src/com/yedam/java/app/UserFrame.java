package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.users.User;
import com.yedam.java.users.UserDAOImpl;

public class UserFrame {
	Scanner sc = new Scanner(System.in);
	public static User USER_INFO;
	
	public UserFrame() {
		while(true) {
			System.out.println();
			System.out.println("================================");
			System.out.println("1.로그인  2.회원가입  3.종료");
			System.out.println("================================");
			System.out.print("선택>>");
			int selected = sc.nextInt();
			if (selected == 1) {
				userLogin();
			} else if (selected == 2) {
				userSignUp();
			} else if (selected == 3) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	private void userSignUp() {
		User user = inputSignUp();
		if (UserDAOImpl.getInstance().insert(user)) {
			userLogin();			
		}
	}

	private void userLogin() {
		User user = inputLogin();
		if (user != null) {
			USER_INFO = user;
			new UserController();
		}
	}

	private User inputLogin() {
		System.out.print("아이디>>");
		String id = sc.next();
		System.out.print("비밀번호>>");
		String password = sc.next();
		User user = UserDAOImpl.getInstance().checklogin(id, password);
		if (user == null) {
			System.out.println("유저정보가 없습니다.");
			return null;
		} else if (user.getWithdrawalStatus().equals("Y")) {
			System.out.println("탈퇴 처리된 유저입니다.");
			System.out.print("탈퇴 취소하시겠습니까?(Y/N)>>"); 
			String selected = sc.next();
			if (selected.equals("Y")) {
				
				//탈퇴 취소 신청
				UserDAOImpl.getInstance().cancelWithdrawal(user);
				
			} else if (selected.equals("N")) {
				
			} else { System.out.println("잘못된 입력입니다."); }
			return null;
		} else {
			return user;
		}
	}

	private User inputSignUp() {
		User user = new User();
		System.out.print("아이디>>");
		user.setUserId(sc.next());
		System.out.print("비밀번호>>");
		user.setUserPwd(sc.next());
		System.out.print("이름>>");
		user.setUserName(sc.next());
		return user;
	}
	
}
