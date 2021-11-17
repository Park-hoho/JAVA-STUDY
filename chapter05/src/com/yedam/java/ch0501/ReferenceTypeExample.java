package com.yedam.java.ch0501;

public class ReferenceTypeExample {
	
	public static void main(String[] args) {
		// 문자열 String 
		String strVar1 = "신미철";
		String strVar2 = "신미철";
		
		if (strVar1 == strVar2) {
			System.out.println("strVar1와 strVar2는 참조가 같음");
		}else {
			System.out.println("strVar1와 strVar2는 참조가 다름");
		}
		
		if(strVar1.equals(strVar2)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음");
		}
		
		String strVar3 = new String("신미철");
		String strVar4 = new String("신미철");
		
		if(strVar3 == strVar4) {
			System.out.println("strVar3와 strVar4는 참조가 같음");
		}else {
			System.out.println("strVar3와 strVar4는 참조가 다름");			
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3와 strVar4는 문자열이 같음");
		}
		
		
	}
	
}
