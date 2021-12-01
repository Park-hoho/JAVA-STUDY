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
	public void addBook(String name, String writer) {
		if(this.bookCount == MAX_SIZE) {
			System.out.println("빈 공간이 없습니다.");
			return;
		}
		Book book = new Book(name, writer);
		bookList[bookCount] = book;
		bookCount++;
		System.out.println("정상 입고되었습니다.");
	}
	
	//1.현재 보유 중인 책 정보 확인
	public void printBookList() {
		for(int i = 0; i < this.bookCount; i++) {
			System.out.println(bookList[i]);
		}
	}
	
	//2.지정된 책 정보 확인 - 책 이름
	public void selectBookInfo(String name) {
		boolean isSearch = false;
		for(int i = 0; i < this.bookCount; i++) {
			String bookName = bookList[i].getBookName();
			if(bookName.equals(name)) {
				System.out.println(bookList[i]);
				isSearch = true;
				break;
			}
		}
		if (!isSearch) {
			System.out.println("검색결과를 찾지 못했습니다.");
		}
	}
	
	//4.책 대여
	public void rentalBook(String name) {
		for(int i = 0; i < this.bookCount; i++) {
			Book book = bookList[i];
			String bookName = book.getBookName();
			if(bookName.equals(name)) {
				if(!book.isRental()) {
					book.setRental(true);
					book.rentalCountUp();
					System.out.printf("책 %s이 대여되었습니다.\n", name);
				} else {
					System.out.printf("책 %s이 대여중입니다.\n", name);
				}
			}
		}
		
	}
	
	//5.책 반납
	public void returnBook(String name) {
		for(int i = 0; i < this.bookCount; i++) {
			Book book = bookList[i];
			String bookName = book.getBookName();
			if(bookName.equals(name)) {
				book.setRental(false);
				System.out.printf("책 %s이 반납되었습니다.\n", name);
			}
		}
	}
	
	//6.대여횟수를 기준으로 인기순위 확인
	public void showRank() {
		Book[] rank = new Book[bookCount];
		System.arraycopy(bookList, 0, rank, 0, bookCount);
		
		for(int i = 0; i < rank.length-1; i++) {
			for(int j = i + 1; j < rank.length; j++) {
				if(rank[i].getRentalCount() < rank[j].getRentalCount()) {
					Book temp = rank[i];
					rank[i] = rank[j];
					rank[j] = temp;
				}
			}
		}
		
		for(Book book : rank) {
			System.out.println(book);
		}
		
	}
}
