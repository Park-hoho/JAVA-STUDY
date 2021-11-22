package com.yedam.java.ch0503;

import java.util.Scanner;

public class Feedback02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		String[] strArr = null;
		int strNum = 0;
		
		while (run) {
			System.out.print("입력할 문자열의 개수 : ");
			strNum = Integer.parseInt(scanner.nextLine());
			strArr = new String[strNum];
			
			for(int i = 0; i < strNum; i++) {
				System.out.printf("%d번째> ", i+1);
				strArr[i] = scanner.nextLine();
			}
			run = false;
		}
		
		// 검사
		System.out.println("검사결과");
		
		for(int i = 0; i < strNum; i++) {
			String str = strArr[i];
			str.toLowerCase();
			str = str.replaceAll(" ", "");
			
			int vowels = countChar(str);
			int consonants = str.length() - vowels;
			System.out.printf("%s : %d %d\n", strArr[i], vowels, consonants);
		}
		scanner.close();
	}

	public static int countChar(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				count++;
			} else if (str.charAt(i) == 'e') {
				count++;
			} else if (str.charAt(i) == 'i') {
				count++;
			} else if (str.charAt(i) == 'o') {
				count++;
			} else if (str.charAt(i) == 'u') {
				count++;
			}
		}
		return count;
	}

}
