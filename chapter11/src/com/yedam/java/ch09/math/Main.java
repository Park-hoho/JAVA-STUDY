package com.yedam.java.ch09.math;

public class Main {

	public static void main(String[] args) {
		//절대값
		int v1 = Math.abs(-5);
		double v2 = Math.abs(-3.14);
		System.out.println("v1 = " +v1);
		System.out.println("v2 = " +v2);
		
		//올림값
		double v3 = Math.ceil(5.3324);
		double v4 = Math.ceil(-5.3);
		System.out.println("v3 = " + v3);
		System.out.println("v4 = " + v4);

		//버림값
		double v5 = Math.floor(5.93234);
		double v6 = Math.floor(-5.1);
		System.out.println("v5 = " + v5);
		System.out.println("v6 = " + v6);

		int v7 = Math.max(5, 9);
		double v8 = Math.max(5.6, 5.4);
		System.out.println("v7 = " + v7);
		System.out.println("v8 = " + v8);
		
		int v9 = Math.min(5, 9);
		double v10 = Math.min(5.6, 5.4);
		System.out.println("v9 = " + v9);
		System.out.println("v10 = " + v10);
		
		double v11 = Math.random();
		System.out.println("v11 = " + v11);
	
		//가까운 정수의 실수값
		double v12 = Math.rint(5.4);
		double v13 = Math.rint(5.7243);
		System.out.println("v12 = " + v12);
		System.out.println("v13 = " + v13);
		
		//반올림
		long v14 = Math.round(5.4);
		long v15 = Math.round(5.72341);
		System.out.println("v14 = " + v14);
		System.out.println("v15 = " + v15);
	
		double value = 12.3456;
		double tp1 = value * 100;
		long tp2 = Math.round(tp1);
		double v16 = tp2/100.0;
		System.out.println("v16 = "+v16);
		System.out.println(Math.round(value));
	}

}
