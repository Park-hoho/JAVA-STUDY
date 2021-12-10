package com.java.test;

//import java.util.ArrayList;

public class KakaoLevel101 {
	
	public static int solution(String s) {
		String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for(int i = 0; i < strArr.length; i++) {
			s = s.replaceAll(strArr[i], Integer.toString(i));
		}
        return Integer.parseInt(s);
    }
	
	public static void main(String[] args) {
		String s = "1zerotwozero3";
		System.out.println(KakaoLevel101.solution(s));
	}
}
