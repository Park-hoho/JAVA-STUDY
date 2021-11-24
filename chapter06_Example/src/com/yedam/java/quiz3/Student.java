package com.yedam.java.quiz3;

public class Student {
	//필드
	private static int serialNum = 1000;
	
	private int studentId;//학번
	private String studentName;//학생이름
	private int grade;
	private String address;
	private int cardNumber;
	
	//생성자
	public Student() {
		Student.serialNum++;
		this.studentId = serialNum;
		this.cardNumber = this.studentId + 100;
	}
	
	//메서드
	
	public static int getSerialNum() {
		return serialNum;
	}
	public static void setSerialNum(int serialNum) {
		Student.serialNum = serialNum;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
}
