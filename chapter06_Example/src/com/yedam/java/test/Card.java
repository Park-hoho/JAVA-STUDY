package com.yedam.java.test;

public class Card {
	private static int cardNum = 1000;
	private int cardId;
	
	Card() {
		System.out.println("카드가 생성되었습니다.");
		Card.cardNum++;
		this.cardId = cardNum;
	}
	
	public static int getCardNum() {
		return cardNum;
	}

	public static void setCardNum(int cardNum) {
		Card.cardNum = cardNum;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
}
