package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.app.manager.Manager;
import com.yedam.java.app.manager.ManagerDAOImpl;

public class ManagerFrame {
	Scanner sc = new Scanner(System.in);
	public static final Manager MANAGER_INFO = new Manager();
	
	public ManagerFrame() {
		System.out.println("1.회원가입  2.로그인");
		int selected = sc.nextInt();
		if (selected == 1) {
			managerSignUp();
		} else if (selected == 2) {
			managerLogin();
		}
		
		while(true) {
			
		}
	}
	
	void managerSignUp() {
		Manager manager = inputAll();
		ManagerDAOImpl.getInstance().insert(manager);
		managerLogin();
	}
	
	void managerLogin() {
		Manager manager = inputLogin();
		MANAGER_INFO = ManagerDAOImpl.getInstance().selectOne(manager);
		new ManagerController().run();
	}
}
