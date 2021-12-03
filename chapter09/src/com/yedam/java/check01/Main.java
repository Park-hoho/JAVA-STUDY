package com.yedam.java.check01;

public class Main {

	public static void main(String[] args) {
		Anonymous any = new Anonymous();
		any.field.start();
		any.method1();
//		any.method2(new Worker() {
//			@Override
//			public void start() {
//				System.out.println("테스트를 합니다.");
//			}
//		});
	}

}
