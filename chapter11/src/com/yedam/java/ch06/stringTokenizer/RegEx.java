package com.yedam.java.ch06.stringTokenizer;

public class RegEx {
	/*
	 정규표현식 : 문자열이 일정한 패턴을 가지는 표현식
	 - [] : 한개의 문자
	 => [abc] : a, b, c 중 하나의 문자
	 => [^abc] : a, b, c 이외의 하나의 문자
	 => [a-zA-z] : a~z, A~z 중 하나의 문자
	 - \d : 한개의 숫자, [0~9]와 동일
	 - \s : 공백
	 - \w : 한개의 알파벳 또는 한개읭 숫자,[a-zA-Z0-9]와 동일
	 - ? : 없음 또는 한개
	 - * : 없음 또는 한개이상
	 - + : 한개 이상
	 - {n} : 정확히 n개
	 - {n,} : 최소한 n개
	 - {n,m} : n개에서부터 m까지
	 - () : 그룹핑 
	 */
	
	/*
	 예를 들어, 02-123-1234 또는 010-1234-5678
	        => (02|010)-\d{3,4}-\d{4}
	 예를 들어, white@naver.com
	        =>\w+@\w+\.\w+(\.\w+)?
	*/
	
}
