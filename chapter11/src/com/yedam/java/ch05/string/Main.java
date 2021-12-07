package com.yedam.java.ch05.string;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Main {

	public static void main(String[] args) throws IOException {
		byte[] by1 = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97, 32, 72, 97, 72, 97};
		String str1 = new String(by1);
		System.out.println(str1);
		
		String str2 = new String(by1, 6, 4);
		System.out.println(str2);
		System.out.println();
		/*
		byte[] by2 = new byte[100];
		System.out.println("입>");
		int readByte = System.in.read(by2);
		
		String str3 = new String(by2, 0, readByte-2);
		System.out.println(str3);
		*/
		
		// charAt();
		String ssn = "010232-1230123";
		char gender = ssn.charAt(7);
		
		switch(gender) {
		case '1':
		case '3':
			System.out.println("man");
			break;
		case '2':
		case '4':
			System.out.println("girl");
			break;
		}
		System.out.println();
		//바이트 배열로 변환, getBytes()
		
		String str = "안녕하세요";
		byte[] bytesX = str.getBytes();
		System.out.println(bytesX.length);
		String strX = new String(bytesX);
		System.out.println(strX);
		System.out.println();
		
		try {
			byte[] byY = str.getBytes("EUC-KR");
			System.out.println(byY.length);
			String strY = new String(byY, "EUC-KR");
			System.out.println(strY);
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println();
		//문자열 찾기, indexOf()
		
		String subject = "자바 프로그래밍";
		System.out.println(subject.indexOf(" "));		
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책");
		} else {
			System.out.println("자바랑 관련x");
		}
		
		System.out.println();
		//문자열 길이, length()
		String koreaSSn = "7306241230123";
		int length = koreaSSn.length();
		if(length == 13) {
			System.out.println("ssn정상");
		} else {
			System.out.println("ssn비정상");
		}
		
		System.out.println();
		
		//문자열 잘라내기, substring(시작, 갯수);
		String firstNum = koreaSSn.substring(0, 6);
		System.out.println(firstNum);
		
		//substring(시작 index);
		String secondNum = koreaSSn.substring(6);
		System.out.println(secondNum);
		
		System.out.println();
		
		// - 알파벳 소문자 변경 : toLowerCase()
		// - 알파벳 대문자 변경 : toUpperCase()
		
		String str4 = "Java Programming";
		String str5 = "JAVA Programming";
		
		System.out.println(str4.equals(str5));
		
		String lowerStr4 = str4.toLowerCase();	
		String lowerStr5 = str5.toLowerCase();	
		System.out.println(lowerStr4.equals(lowerStr5));
		
		System.out.println(str4.equalsIgnoreCase(str5));
		System.out.println();
		
		//문자열 앞뒤 공백 잘라내기, trim()
		
		String tel1 = "        02";
		String tel2 = "123        ";
		String tel3 = "            1234";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
		
		//문자열 변환, valueOf
		String strVar3 = String.valueOf(10);
		String strVar4 = String.valueOf(10.5);
		String strVar5 = String.valueOf(true);
		
		System.out.println(strVar3);
		System.out.println(strVar4);
		System.out.println(strVar5);
		
	}

}
