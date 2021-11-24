package com.yedam.java.test;

public class Person {
	//필드
		String name;
		int money; //보유하고 있는 돈
		//생성자
		Person(String name, int money) {
			this.name = name;
			this.money = money;
		}
		
		//메서드
		public void buy(KongCafe kongCafe, String menu, int cups) {
			int coffeePrice = kongCafe.buy(menu, cups);
			this.money -= coffeePrice; 
		}
		
		public void buy(StarCafe starCafe, String menu, int cups) {
			int coffeePrice = starCafe.buy(menu, cups);
			this.money -= coffeePrice; 
		}
		
		public void showInfo() {
			System.out.printf("%s의 남은 돈은 %d입니다.\n", name, money);
		}
}
