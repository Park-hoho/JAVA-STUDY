package com.yedam.java.quiz;

public class Person {
	//필드
	int age;
	String name;
	String gender;
	boolean isMarried;
	int children;
	//생성자
	Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	//메서드
	public void isMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
	
	public void setChildren(int children) {
		this.children = children;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public boolean isMarried() {
		return isMarried;
	}
	
	public int getChildren() {
		return children;
	}
	
}
