package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.app.customer.Customer;
import com.yedam.java.app.customer.CustomerDAOImpl;

public class CustomerFrame {
	Scanner sc = new Scanner(System.in);
	public static Customer CUSTOMER_INFO;
	
	public CustomerFrame() {
		while(true) {
			System.out.println("1.회원가입  2.로그인  3.종료");
			int selected = sc.nextInt();
			if (selected == 1) {
				customerSignUp();
			} else if (selected == 2) {
				customerLogin();
			} else if (selected == 3) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void customerSignUp() {
		Customer customer = inputAll();
		CustomerDAOImpl.getInstance().insert(customer);
		customerLogin();
	}
	
	private void customerLogin() {
		CUSTOMER_INFO = login();
		if (CUSTOMER_INFO != null) {
			
		}
	}
	
	private Customer login() {
		System.out.print("이메일>>");
		String email = sc.next();
		System.out.print("비밀번호>>");
		String pwd = sc.next();
		Customer customer = CustomerDAOImpl.getInstance().selectOne(email);
		if (customer == null || pwd.equals(customer.getCustomerPwd())) {
			System.out.println("잘못된 접근입니다.");
			return null;
		} else {
			System.out.println("로그인 성공!");
			return customer;
		}
	}
	
	private Customer inputAll() {
		Customer customer = new Customer();
		customer.setCustomerId(0);
		System.out.print("이메일>>");
		customer.setCustomerEmail(sc.next());
		System.out.print("이름>>");
		customer.setCustomerName(sc.next());
		System.out.print("비밀번호>>");
		customer.setCustomerPwd(sc.next());
		return customer;
	}
	
}
