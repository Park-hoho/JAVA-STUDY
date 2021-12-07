package com.yedam.java.ch05.string;

public class Quiz {
	
	public static void main(String[] args) {
		//문제 1번
		System.out.println(initcap("hello"));
		System.out.println(initcap("java"));
		//문제 2번
		System.out.println();
		System.out.println(printInversion("hello"));
		System.out.println(printInversion2("hello"));
	}
	
	public static String initcap(String str) {
		//매개변수로 받은 문자열에서 각 단어의 첫 글자만 대분자로 변환해서
		//반환하는 메소드 ex) hello world java => Hello World Java
		String data = "";
		String first = str.substring(0, 1).toUpperCase();
		String str1 = str.substring(1);
		
		data = first + str1;
		
		return data;
	}
	
	public static String printInversion(String str) {
		//매개변수로 받은 문자를 뒤집어서 반환
		//예를 들어, hello -> olleh
		byte[] bytes1 = new byte[str.length()];
		byte[] bytes2 = new byte[str.length()];
		
		bytes1 = str.getBytes();
		for (int i = bytes1.length - 1, j = 0; i >= 0; i--, j++) {
			bytes2[j] = bytes1[i];
		}
		String data = new String(bytes2);
		return data;
	}
	
	public static String printInversion2(String str) {
		String data = "";
		for(int i = str.length()-1; i>=0; i--) {
			data += str.charAt(i);
		}
		return data;
	}
	
}
