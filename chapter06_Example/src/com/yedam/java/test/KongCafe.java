package com.yedam.java.test;

public class KongCafe {
	//필드
	//메뉴 별 가격
	static int americanoPrice = 2000;
	static int lattePrice = 4500;
	
	String cafeName = "콩다방";
	String branchName;
	int money; //수익
	int count; //판매한 커피 수
	int todayCustomer;
	//생성자
	public KongCafe(String branchName) {
		this.branchName = branchName;
		this.money = 0;
		this.count = 0;
		this.todayCustomer = 0;
	}
	
	//메서드
	public int buy(String menu, int cups) {
		if(menu.equals("latte")) {
			this.money += lattePrice*cups;
			this.count += cups;
			todayCustomer++;
			System.out.println("라떼를 " + lattePrice*cups + "에 결제하셨습니다.");
			return lattePrice*cups;
		}else if(menu.equals("americano")) {
			this.money += americanoPrice*cups;
			this.count += cups;
			todayCustomer++;
			System.out.println("아메리카노를 " + americanoPrice*cups + "에 결제하셨습니다.");
			return americanoPrice*cups;
		}else {
			System.out.println("주문을 다시 해주세요.");
			return 0;
		}
	}
	
	public void showInfo() {
		System.out.printf("%s %s의 손님은 %d명이고 수입은 %d원입니다.\n", cafeName, branchName, todayCustomer, money);
	}
	
}
