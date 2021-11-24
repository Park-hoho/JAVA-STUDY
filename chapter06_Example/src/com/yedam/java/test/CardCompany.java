package com.yedam.java.test;

public class CardCompany {
	//필드
	private static volatile CardCompany instance;
	private String CompanyName = "YedamCard";
	private int totalCard;
	//생성자
	private CardCompany() {
		System.out.println("카드회사가 설립되었습니다.");
		System.out.println("카드회사가 운영중입니다.");
		totalCard = 0;
	}
	
	// 메서드
	public static CardCompany getInstance() {
		if (instance == null) {
			synchronized (CardCompany.class) {
				if (instance == null) {
					instance = new CardCompany();
				}
			}
		}
		return instance;
	}
	
	public Card createCard() {
		totalCard++;
		return new Card("yedamCard");
	}
	public int getTotalCard() {
		return totalCard;
	}
	public void showInfo() {
		System.out.printf("%s 의 총 발행한 카드 수는 %d개 입니다.\n", CompanyName, totalCard);
	}
}
