package com.yedam.java.quiz3;

public class StudentExample {

	public static void main(String[] args) {
		Student studentLee = new Student();
		System.out.println(Student.getSerialNum());
		Student studentSon = new Student();
		System.out.println(Student.getSerialNum());
		
		studentLee.setStudentName("이지원");
		System.out.println(studentLee.getStudentName() + "의 학번 : " + studentLee.getStudentId());
		System.out.println(studentLee.getStudentName() + "의 학생 카드 번호 : " + studentLee.getCardNumber());
		
		studentSon.setStudentName("손수경");
		System.out.println(studentSon.getStudentName() + "의 학번 : " + studentSon.getStudentId());
		System.out.println(studentSon.getStudentName() + "의 학생 카드 번호 : " + studentSon.getCardNumber());
	}

}
