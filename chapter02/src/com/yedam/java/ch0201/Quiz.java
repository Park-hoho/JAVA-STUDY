package com.yedam.java.ch0201;

public class Quiz {

	public static void main(String[] args) {
		//문제1) 정수형 변수 3개를 이용하여 
		//정수값 54와 36을 아래와 같이 출력하는 프로그램을 만들어라
		//54+36=90
		//54-36=18
		//54*36=
		//54/36=
		
		int x = 54, y = 36, result;
		result = x + y;
		System.out.println(x+"+"+y+"="+result);
		result = x-y;
		System.out.println(x+"-"+y+"="+result);
		result = x*y;
		System.out.println(x+"*"+y+"="+result);
		result = x/y;
		System.out.println(x+"/"+y+"="+result);
		
		//문제2)
		int a = 10, b = 50, c=90;
		// a:50 ,b:90 ,c:10
		int d=a;
		a=b;
		b=c;
		c=d;
		System.out.println("a:"+a+" b:"+b+" c:"+c);
		
		
		//문제3)
		int m = 10;
		
		if(m==10) {
			int n=21;
			int sum = m+n;
			System.out.println("sum:"+sum);
		}
		
	}

}