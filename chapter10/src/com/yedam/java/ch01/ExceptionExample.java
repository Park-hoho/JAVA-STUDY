package com.yedam.java.ch01;

public class ExceptionExample {
	public static void main(String[] args) {
		//NullPointerException	
		String data = null;
		System.out.println(data);
		//System.out.println(data.toString());
	
		//ArrayIndexOutOfBoundsException
		String data1 = args[0];
		String data2 = args[1];
		
		System.out.println("arg[0] : " + data1);
		System.out.println("arg[1] : " + data2);
		
		//NumberFormatException
		String data1 = "100";
		String data2 = "a100";
		
		
	}
}
