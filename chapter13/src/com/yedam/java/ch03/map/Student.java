package com.yedam.java.ch03.map;

public class Student {
	public int sno;
	public String name;
	
	public Student(int sno, String name) {
		super();
		this.sno = sno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return sno + name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student student = (Student) obj;
			return student.name.equals(this.name) && (student.sno == this.sno);
		} else {
			return false;
		}
	}
	
	
}
