package com.yedam.java.ch0201;

public class VariableExample {

	public static void main(String[] args) {
		// 변수 선언
		int score;
		score = 100;

		int value = 30;
		int result = value + 10;

		// result값 =/= value값
		
		System.out.println(result + score);
		System.out.println();

		// 변수 사용
		
		int hour = 3;
		int minute = 5;
		System.out.println(hour + "시간" + minute + "분");

		int totalMinute = (hour * 60) + minute;
		System.out.println("총" + totalMinute + "분");
		System.out.println();
		
		/*
		 int x; int y; int z;
		*/

		int x, y, z;

		x = 1;
		y = 2;
		z = x + y;

		System.out.println(x + "+" + y + "=" + z);

		// 변수 값 교환

		int m = 3;
		int n = 5;
		// m = 5 , n = 3 으로 교환

		int temp = m;
		m = n;
		n = temp;
		System.out.println("m: " + m + ", n: " + n);

		int a = 10, b = 20;

		temp = a;
		a = b;
		b = temp;

		System.out.println("a: " + a + ", b:" + b);

		// 변수의 사용범위

		int value1 = 15;
		if (value > 10) {
			int value2;
			value2 = value1 - 10;
		}
		int value3 = value1 + value2 + 5;
		System.out.println("1:" + value1 + ", 2:" + value2 + ", 3" + value3);
		
		int v1 = 0;
		if (v1 == 0) {
			v1 = 1;
			int v2 = 0;
			if (v2 == 0) {
				v2 = 2;
				int v3 = v1 + v2;
				System.out.println(v1 + "+" + v2 + "=" + v3);
			}
			System.out.println(v1 + "+" + v2 + "=" + v3);
		}
		System.out.println(v1 +"+"+v2+"="+v3);
		
	}

}