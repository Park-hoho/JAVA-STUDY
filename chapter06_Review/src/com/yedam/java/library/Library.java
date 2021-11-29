package com.yedam.java.library;

public class Library {
	//field
	private static final int MAX_SIZE = 5;
	private Book[] bookList;
	private int bookCount;
	
	//constructor
	public Library() {
		this.bookList = new Book[MAX_SIZE];
		this.bookCount = 0;
	}
	
	//method
	
	//3.책에 대한 입고처리
	
	//1.현재 보유 중인 책 정보 확인
	public void printBookList() {
		for(int i = 0; i < this.bookCount; i++) {
			System.out.println(bookList[i]);
		}
	}
	
	//2.지정된 책 정보 확인
	public void searchBook() {
		
	}
	
	//4.책 대여
	
	//5.책 반납
	
	//6.대여횟수를 기준으로 인기순위 확인

}
