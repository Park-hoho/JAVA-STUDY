package com.yedam.java.test03;

public class Main {
//	문제3) 인터페이스 AdderInterface의 코드는 다음과 같습니다. 
// AdderInterface를 상속받은 클래스 MyAdder를 선언하여, 
//	다음 main() 을 실행할 때 아래 실행 결과와 같이 출력되도록 하세요.
	
//	- 실행코드
	public static void main(String[] args) {
		AdderInterface adder = new MyAdder();
		System.out.println(adder.add(5,10));
		System.out.println(adder.add(10));
	}
	
//	- 실행결과 
//		15
//		55
}
