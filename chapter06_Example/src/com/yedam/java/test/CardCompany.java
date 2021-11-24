package com.yedam.java.test;

public class CardCompany {
	//필드
	private static CardCompany instance = new CardCompany();
	
	//생성자
	private CardCompany() {}
	
	// 메서드
	public static CardCompany getInstance() {
		System.out.println("카드회사가 설립되었습니다.");
		System.out.println("카드회사가 운영중입니다.");
		return instance;
	}
	
	public Card createCard() {
		return new Card();
	}
}
