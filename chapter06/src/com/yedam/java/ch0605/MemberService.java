package com.yedam.java.ch0605;

public class MemberService {
	//필드
	String id = "hong";
	String password = "12345";
	//생성자
	MemberService() {
		
	}
	//메서드
	public boolean login(String id, String password) {
		if (id == this.id && password == this.password) {
			return true;			
		} else {
			return false;
		}
	}
	
	public void logout(String id) {
		System.out.println("로그아웃 되었습니다.");
	}
}
