package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.store.Store;
import com.yedam.java.store.StoreDAOImpl;

public class CustomerController {
	Scanner sc = new Scanner(System.in);
	public static Store STORE_INFO;
	
	void run() {
		while(true) {
			System.out.println();
			System.out.println("=========================================");
			System.out.println(CustomerFrame.CUSTOMER_INFO.getCustomerName() + "고객님 환영합니다.");
			System.out.println("1.매장선택/주문  2.카드정보  3.회원정보  4.뒤로가기");
			System.out.println("=========================================");
			int selected = sc.nextInt();
			if (selected == 1) {
				System.out.print("매장이름>>");
				String storeName = sc.next();
				Store store = StoreDAOImpl.getInstance().selectOne(storeName);
				if (store.getStoreName() != null) {
					STORE_INFO = store;
					
					//주문 컨트롤
					new OrderController().run();
				} else {
					System.out.println("없는 매장입니다. 다시 선택해주세요!");
				}
			} else if (selected == 2) {
				cardController();
			} else if (selected == 3) {
				customerUpdate();
			} else if (selected == 4) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	void orderController() {
		
	}
	
	void cardController() {
		//카드정보 1.카드충전  2.카드정보조회  3.카드삭제
		System.out.println("카드정보 제작해야함");
	}
	
	void customerUpdate() {
		//회원정보수정 1.정보조회 2.이름변경  3.이메일변경  4.비밀번호변경  5.뒤로가기
		System.out.println("회원정보 제작해야함");
	}

}
