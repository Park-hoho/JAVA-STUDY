package com.yedam.java.quiz;

public class Person {
	//필드
	int age = 40;
	String name = "james";
	boolean marriage = true;
	int child = 3;
	//생성자
	Person(int age, String name, boolean marriage, int child) {
		this.age = age;
		this.name = name;
		this.marriage = marriage;
		this.child = child;
	}
	//메소드
	void printInfo() {
		System.out.println("나이 : " + this.age);
		System.out.println("이름 : " + this.name);
		System.out.println("결혼 여부 : " + this.marriage);
		System.out.println("자녀 수 : " + this.child);
	}
}
