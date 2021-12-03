package com.yedam.java.ch04;

public class Account {
	private int balance;
	
	public long getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withDraw(int money) throws BalanceInsufficientException {
		if(money > balance) {
			throw new BalanceInsufficientException
			("잔고부족 : " + (money - balance) + "이 모자랍니다.");
		}
		balance -= money;
	}
}
