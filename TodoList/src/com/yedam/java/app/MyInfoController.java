package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.users.UserDAOImpl;

public class MyInfoController {
	Scanner sc = new Scanner(System.in);
	double COMPLETED_RATIO;
	
	public MyInfoController() {
		run();
	}
	
	private void run() {
		while(true) {
			showUserInterface();
			int selected = Integer.parseInt(sc.nextLine());
			if (selected == 1) {
				changeName();
			} else if (selected == 2) {
				changePassword();
			} else if (selected == 3) {
				withdrawalApp();
			} else if (selected == 9) {
				break;
			} else { System.out.println("잘못된 입력입니다."); }
		}
	}

	private void showUserInterface() {
		System.out.println("\n===================================================");
		System.out.printf("%s님 정보  |  완료된 할 일: %d |  등급: %s\n",
				UserFrame.USER_INFO.getUserName(), UserController.COMPLETED_COUNT, UserController.USER_GRADE);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1.이름 변경  2.비밀번호 변경  3.계정 삭제  9.뒤로가기");
		System.out.println();
		System.out.print("메뉴입력>>");
	}
	
	private void changeName() {
		System.out.print("변경할 이름>>");
		String name = sc.nextLine();
		UserDAOImpl.getInstance().updateName(UserFrame.USER_INFO, name);
		UserFrame.USER_INFO.setUserName(name);
	}
	
	private void changePassword() {
		System.out.print("변경할 비밀번호>>");
		String password = sc.nextLine();
		UserDAOImpl.getInstance().updatePwd(UserFrame.USER_INFO, password);
	}

	private void withdrawalApp() {
		System.out.print("정말 탈퇴하시겠습니까>(Y/N)");
		String s = sc.nextLine();
		if (s.equals("Y")) {
			System.out.print("탈퇴사유를 입력해주세요(400자)>>");
			String reason = sc.nextLine();
			UserDAOImpl.getInstance().applicationWithdrawal(UserFrame.USER_INFO, reason);
			System.out.println("처리완료 되었습니다.");
			System.out.println("* 30일이내로 탈퇴 취소처리 가능하고 그 이후에는 재가입이 불가합니다.");
			System.out.print("아무키나 누르시면 종료됩니다.");
			sc.nextLine();
			System.exit(0);
		}
	}
	
}
