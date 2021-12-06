package com.yedam.java.ch02.Objects;

import java.util.Objects;

public class Student {
	int sno;
	String name;
	
	Student(int sno) {
		this.sno = sno;
	}
	
	Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.sno, this.name);
	}
	
	
	
}
