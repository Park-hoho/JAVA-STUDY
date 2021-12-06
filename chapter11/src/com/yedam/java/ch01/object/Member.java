package com.yedam.java.ch01.object;

public class Member implements Cloneable {
	//필드
	public String id;
	public String name;
	public String password;
	public int age;
	public boolean adult;
	
	//constructor
	public Member(String id) {
		this.id = id;
	}

	public Member(String id, String name, String password, int age, boolean adult) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
	}
	
	//method
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return cloned;
	}
	
}
