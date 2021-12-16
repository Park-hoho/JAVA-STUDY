package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.app.manager.Manager;
import com.yedam.java.app.manager.ManagerDAOImpl;

public class ManagerFrame {
	Scanner sc = new Scanner(System.in);
	public static Manager MANAGER_INFO;
	
	public ManagerFrame() {
		while(true) {
			System.out.println("1.회원가입  2.로그인  3.종료");
			int selected = sc.nextInt();
			if (selected == 1) {
				managerSignUp();
			} else if (selected == 2) {
				managerLogin();
			} else if (selected == 3) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		
	}
	
	//회원가입
	private void managerSignUp() {
		Manager manager = inputAll();
		ManagerDAOImpl.getInstance().insert(manager);
		managerLogin();
	}
	
	//로그인
	private void managerLogin() {
		MANAGER_INFO = login();
		if (MANAGER_INFO != null) {
			new ManagerController().run();
		}
	}
	
	private Manager login() {
		System.out.print("매니저ID>>");
		int id = sc.nextInt();
		System.out.print("비밀번호>>");
		String pwd = sc.next();
		Manager manager = ManagerDAOImpl.getInstance().selectOne(id);
		if (manager == null) {
			System.out.println(id + "는 없는 매니저ID 입니다.");
			return null;
		} else {
			if (pwd.equals(manager.getManagerPwd())) {
				System.out.println("로그인 성공!");
				return manager;
			} else {
				System.out.println("잘못된 비밀번호 입니다.");
				return null;
			}
		}
	}
	
	private Manager inputAll() {
		Manager manager = new Manager();
		System.out.print("매니저ID>>");
		manager.setManagerId(sc.nextInt());
		System.out.print("매니저이름>>");
		manager.setManagerName(sc.next());
		System.out.print("비밀번호>>");
		manager.setManagerPwd(sc.next());
		System.out.print("관리매장ID>>");
		manager.setStoreId(sc.nextInt());
		return manager;
	}
}
