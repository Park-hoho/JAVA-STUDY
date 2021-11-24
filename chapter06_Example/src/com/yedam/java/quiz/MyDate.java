package com.yedam.java.quiz;

public class MyDate {
	//필드
	private int day;
	private int month;
	private int year;
	
	//생성자
	MyDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//메서드
	

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public boolean isValid() {
		int startOfMonth = 1;
		int endOfMonth = 0;
		switch(this.month) {
		case 2:
			endOfMonth = 28;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			endOfMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			endOfMonth = 30;
			break;
		}
		if (this.day >= startOfMonth && this.day <= endOfMonth) {
			return true;
		}else {
			
		}
	}
	
}
