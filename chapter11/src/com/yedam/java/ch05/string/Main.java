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
	}

}
