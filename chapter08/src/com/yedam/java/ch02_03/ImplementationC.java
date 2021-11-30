package com.yedam.java.ch02_03;

public class ImplementationC implements InterfaceC{
	// C가 A, B 두개 다 상속을 받으므로 총 3개를 받는다
	
	@Override
	public void methodA() {
		System.out.println("C - methodA 실행");
	}

	@Override
	public void methodB() {
		System.out.println("C - methodB 실행");
	}

	@Override
	public void methodC() {
		System.out.println("C - methodC 실행");
	}

}
