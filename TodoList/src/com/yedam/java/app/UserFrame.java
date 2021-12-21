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
		if (user != null && !user.getWithdrawalStatus().equals("Y")) {
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
		if (user.getUserNo() == 0 || user.getUserId() == null) {
			System.out.println("아이디 또는 비밀번호가 잘 못되었습니다.");
			return null;
		} else {
			System.out.println("로그인 성공!");
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
