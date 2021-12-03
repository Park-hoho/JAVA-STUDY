package com.yedam.java.ch04;

public class AccountExample {
	
	public static void main(String[] args) {
		Account account = new Account();
		
		//예금
		account.deposit(10000);
		System.out.println("예금액 : " + account.getBalance());
		
		//출금
		try {
			account.withDraw(30000);
		} catch (BalanceInsufficientException e) {
			System.out.println(e.getMessage());
			System.out.println();
			e.printStackTrace();
		}
	}
	
}
