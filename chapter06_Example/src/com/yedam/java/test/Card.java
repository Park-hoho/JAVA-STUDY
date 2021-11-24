package com.yedam.java.test;

public class Card {
	private static int cardNum = 1000;
	private String cardId;
	private String cardCompanyName;
	
	Card(String cardCompanyName) {
		System.out.println("카드가 생성되었습니다.");
		Card.cardNum++;
		this.cardCompanyName = cardCompanyName;
		this.cardId = "KR-" + cardNum;
	}
	
	public static int getCardNum() {
		return cardNum;
	}

	public static void setCardNum(int cardNum) {
		Card.cardNum = cardNum;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = "KR-" + cardId;
	}
	
	public String getCardCompanyName() {
		return cardCompanyName;
	}

}
