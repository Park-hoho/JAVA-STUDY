package com.yedam.java.ch01_01;

public class Outer {
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {
		int num = 100;
		
		class MyRunnable implements Runnable { //연산은 일어날수없다.
			int localNum = 10;
			
			@Override
			public void run() {
				System.out.println("i = " + i);
				System.out.println("num = " + num);
				System.out.println("localNum = " + localNum);
				System.out.println("outNum = " + outNum);
				System.out.println("Outer.sNum" + sNum);
				
			}
			
		}
		
		return new MyRunnable();
	}
}
