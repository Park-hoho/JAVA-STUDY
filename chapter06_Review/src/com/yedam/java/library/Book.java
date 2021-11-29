<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'main' of https://github.com/Park-hoho/javaGit.git
