package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.menu.MenuDAOImpl;

public class OrderController {
	Scanner sc = new Scanner(System.in);
	
	void run() {
		while(true) {
			System.out.println();
			System.out.println("================================");
			System.out.println("선택된 매장: " + CustomerController.STORE_INFO.getStoreName());
			System.out.println("1.전체 메뉴보기  2.메뉴 주문  3.뒤로가기");
			System.out.println("================================");
			int selected = sc.nextInt();
			if (selected == 1) {
				MenuDAOImpl.getInstance().showStoreMenus(CustomerController.STORE_INFO);
			} else if (selected == 2) {
				System.out.print("메뉴번호>>");
				int menu = sc.nextInt();
			} else if (selected == 3) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
}
