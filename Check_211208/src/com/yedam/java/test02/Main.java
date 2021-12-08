package com.yedam.java.test02;

public class Main {

	public static void main(String[] args) {
//		문제2) 원을 표현하는 다음 Circle 클래스가 있습니다. 
//	    Circle 클래스를 상속받은 NamedCircle 클래스를 선언하여, 
//		다음 main()을 실행할 때 다음 실행 결과와 같이 출력되도록 하세요.
//		- 실행코드
		
		Circle w = new NamedCircle(5, "Waffle");
		w.show();
		
//		- 실행결과
//		Waffle, 반지름 = 5

	}

}
