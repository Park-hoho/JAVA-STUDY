package com.yedam.java.check2;

import java.util.Scanner;

public class PhoneBook {
	
	public static void main(String[] args) {
		boolean start = true;
		String searchName;
		String name, number;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원수 >> ");
		int total = Integer.parseInt(sc.nextLine());
		Phone[] phone = new Phone[total];
		
		for(int i = 0; i < total; i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>");
			name = sc.next();
			number = sc.next();
			phone[i] = new Phone(name, number);
		}
		
		System.out.println("저장되었습니다...");
		while(start) {
			boolean isSearch = false;
			System.out.print("검색할 이름 >>");
			searchName = sc.next();
			if(searchName.equals("그만")) { 
				start = false;
				break;
			}
	
			for(int j = 0; j < phone.length; j++) {
				name = phone[j].getName();
				if(searchName.equals(name)) {
					number = phone[j].getTel();
					System.out.println(name+"의 번호는 "+number+" 입니다.");
					isSearch = true;
					break;
				}
			}
			if(!isSearch) System.out.println(searchName+"이 없습니다.");
		}
		sc.close();
	}
	
}
//< 실행예시 >
//인원수 >> 3
//이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>황기태 777-7777
//이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>나명품 999-9999
//이름과 전화번호(이름과 번호는 빈 칸없이 입력)>>최자바 333-1234
//저장되었습니다...
//검색할 이름 >>황기순
//황기순이 없습니다.
//검색할 이름 >>최자바
//최자바의 번호는 333-1234 입니다.
//검색할 이름 >>그만
