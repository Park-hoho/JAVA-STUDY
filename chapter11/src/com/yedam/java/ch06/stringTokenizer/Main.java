package com.yedam.java.ch06.stringTokenizer;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		//문자열이 특정 구분자로 연결되어있을 경우
		//구분자를 기준으로 부분 문자열로 분리하는 방법
		
		//String.split() -> 정규표현식
		String text1 = "홍길동&이수홍,박연수,김자바-최명호";
		String[] names = text1.split("&|,|-");
		for(String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		//StringTokenizer 클래스 -> 문자
		StringTokenizer st = new StringTokenizer(text1, "&,-");
		int countT = st.countTokens();
		for(int i = 0; i < countT; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println();
		
		// hasMoreElements()는 밖으로 빼내는거라 재사용이 불가하다.
		String text2 = "홍길동/이수홍/박연수";
		st = new StringTokenizer(text2, "/");
		while(st.hasMoreElements()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println();
		// StringBuilder
		StringBuilder sb = new StringBuilder();
		
		//문자열을 끝에 추가
		sb.append("Java ");
		sb.append("Program Study");
		System.out.println(sb);
		
		sb.insert(4, "2");
		//index4 앞에 2를 삽입
		System.out.println(sb.toString());
		
		sb.setCharAt(4, '6');
		//index4 위치의 문자를 6으로 변경
		System.out.println(sb.toString());
		
		sb.replace(6, 13, "Book");
		//index6부터 index13 '전'까지를 "Book" 문자열로 대치
		System.out.println(sb.toString());
		
		sb.delete(4, 5);
		//index4부터 index5 '전'까지 삭제
		System.out.println(sb.toString());
		
		//총 문자 수 얻기
		int length = sb.length();
		System.out.println("총문자수 : " + length);
		
		String result = sb.toString();
		System.out.println(result);
		System.out.println();
		// Pattern
		
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-123-4567";
		boolean resultData = Pattern.matches(regExp, data);
		if(resultData) {
			System.out.println("일치");
		} else {
			System.out.println("불일치");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angle@naver.com";
		resultData = Pattern.matches(regExp, data);
		if(resultData) {
			System.out.println("일치");
		} else {
			System.out.println("불일치");
		}
				
	}

}
