package com.yedam.java.check;

public class Account {
	private String owner;
	private long balance;
	
	Account() {
		this.owner = null;
		this.balance = 0;
	}
	Account(String owner) {
		this.owner = owner;
		this.balance = 0;
	}
	Account(long balance) {
		this.owner = null;
		this.balance = balance;
	}
	Account(String owner, long balance) {
		this.owner = owner;
		this.balance = balance;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	//저축
	public long deposit(long amount) throws BalanceInsufficientException{
		if(amount <= 0) {
			throw new BalanceInsufficientException("오류:음수,0입력");
		}
		
		balance += amount;
		System.out.printf("입금 : %d, 잔고 : %d\n", amount, balance);
		
		return balance;
	}
	
	//인출
	public long withdraw(long amount) throws BalanceInsufficientException{
		if(amount <= 0) {
			throw new BalanceInsufficientException("오류:음수,0입력");
		} else if (balance == 0) {
			throw new BalanceInsufficientException("오류:잔고없음");
		}
		
		if (balance < amount) {
			System.out.println("인출액이 잔고보다 많습니다. 인출 가능한 금액 : " + balance);
		} else {
			balance -= amount;
			System.out.printf("인출 : %d, 잔고 : %d\n", amount, balance);
		}
		return balance;
	}
	
	
}

