package com.yedam.java.library;

public class Book {
	public static int serialNumber = 1000;
	
	public int bookNo;
	public String bookName;
	public String bookWriter;
	public int rentalCount;
	public boolean rental;
	
	public Book(String name, String writer) {
		Book.serialNumber++;
		this.bookNo = Book.serialNumber;
		this.bookName = name;
		this.bookWriter = writer;
		this.rentalCount = 0;
		this.rental = false;
	}
	
	//method
	public static int getSerialNumber() {
		return serialNumber;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	
	public void setBookName(String name) {
		this.bookName = name;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookWriter(String writer) {
		this.bookWriter = writer;
	}
	
	public String getBookWriter() {
		return bookWriter;
	}
	
	public void rentalCountUp() {
		this.rentalCount++;
	}
	
	public int getRentalCount() {
		return rentalCount;
	}
	
	public void setRental(boolean rental) {
		this.rental = rental;
	}
	
	public boolean isRental() {
		return rental;
	}

	@Override
	public String toString() {
		String rental = this.rental ? "유" : "무";
		return "책 정보, 고유번호 : " + bookNo + 
				", 이름 : " + bookName +
				", 지은이 : " + bookWriter +
				", 대여 : " + rental +
				", 대여횟수 : " + rentalCount;
	}
	
	
}
