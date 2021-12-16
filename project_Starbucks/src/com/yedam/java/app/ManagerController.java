package com.yedam.java.app;

public class ManagerController {
	
	void run() {
		while(true) {
			System.out.println("1.담당매장  2.영업  3.메뉴");
			int selected = sc.nextInt();
			switch(selected) {
			case 1:
				storeController();
				break;
			case 2:
				
				break;
			case 3:
				break;
			}
		}
	}
	
	void storeController() {
		while(true) {
			System.out.println("1.매장정보등록  2.매장정보수정");
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
