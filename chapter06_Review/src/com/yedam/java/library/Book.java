package com.yedam.java.library;

public class Book {
	//field
	private int bookNum;
	private String bookName;
	private String author;
	private int rentalCount;
	private boolean isRental;
	
	//constructor
	public Book(int bookNum, String bookName, String author) {
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.author = author;
		rentalCount = 0;
		isRental = false;
	}
	
	//method
	public int getBookNum() {
		return bookNum;
	}

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRentalCount() {
		return rentalCount;
	}

	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}

	public boolean isRental() {
		return isRental;
	}

	public void setRental(boolean isRental) {
		this.isRental = isRental;
	}
	
	
}
