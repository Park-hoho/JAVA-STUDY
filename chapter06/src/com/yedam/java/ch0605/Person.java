package com.yedam.java.ch0605;

public class Person {
	//필드
	final String nation = "Korea";
	final String ssn;
	String name;
	
	//생성자
	Person(String nation) {
		this.nation = nation;
	}
	Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
	//메서드
}	
