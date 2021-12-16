package com.yedam.java.app;

import java.util.Scanner;

public class ManagerController {
	Scanner sc = new Scanner(System.in);
	
	void run() {
		while(true) {
			System.out.println();
			System.out.println("==============================");
			System.out.println("매니저 : " + ManagerFrame.MANAGER_INFO.getManagerName());
			System.out.println("1.담당매장  2.매출조회  3.매니저관리");
			System.out.println("==============================");
			int selected = sc.nextInt();
			switch(selected) {
			case 1:
				storeController();
				break;
			case 2:
				//showSales();
				break;
			case 3:
				break;
			}
		}
	}
	
	void storeController() {
		while(true) {
			System.out.println("1.매장정보등록  2.매장정보수정  3.담당매장수정");
			int selected = sc.nextInt();
			if (selected == 1) {
				insertStore();
			} else if (selected == 2) {
				updateStore();
			}
		}
	}
	
	void insertStore() {
		Store store = inputStoreAll();
		StoreDAOImpl.getInstance().insert(store);
	}
	
	void updateStore() {
		Store store = inputStoreAll();
		StoreDAOImpl.getInstance().insert(store);
	}
}
