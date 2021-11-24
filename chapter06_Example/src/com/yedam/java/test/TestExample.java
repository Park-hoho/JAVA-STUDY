package com.yedam.java.test;

public class TestExample {

	public static void main(String[] args) {
		//문제1)
		System.out.println("=========== 문제1번");
		Person kim = new Person("Kim", 8000);
		Person lee = new Person("Lee", 9800);
		
		StarCafe starCafe = new StarCafe("1호점");
		KongCafe kongCafe = new KongCafe("동성로점");
		
		kim.buy(starCafe, "americano", 1);
		starCafe.showInfo();
		System.out.println();
		
		lee.buy(kongCafe, "latte", 1);
		kongCafe.showInfo();
		System.out.println();
		
		kim.showInfo();
		lee.showInfo();
		
		//문제2)
		System.out.println("=========== 문제2번");
		
		Card parkCard = new Card();
		Card leeCard = new Card();
		
		System.out.println("kbCard : " + parkCard.getCardId());
		System.out.println("kdbCard : " + leeCard.getCardId());
		
		//문제3)
		System.out.println("=========== 문제3번");
		CardCompany cardCompany = CardCompany.getInstance();
		
		Card firstCard = cardCompany.createCard();
		Card secondCard = cardCompany.createCard();
		
		System.out.println("첫번째 카드 : " + firstCard.getCardId());
		System.out.println("두번째 카드 : " + secondCard.getCardId());
	}

}
