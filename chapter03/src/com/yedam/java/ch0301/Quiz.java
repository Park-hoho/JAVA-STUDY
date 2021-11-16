package com.yedam.java.ch0301;

public class Quiz {

	public static void main(String[] args) {
		// 문제1)
		int x = 10;
		int y = 10;
		int result;
		
		//1-1)
		result = -x;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);
		
		//1-2)
		result = x + y++;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);
		
		//1-3)
		result = x + --y;
		System.out.printf("x : %d, y : %d, result : %d\n", x, y, result);
		
		//1-4)
		System.out.printf("몫 : %d, 나머지 : %d\n",  (x / y), (x % y));
		
		// 문제2)
		int value = 365;
		result = (value / 100) * 100;
		System.out.println(result);
		result = value - (value % 100);
		System.out.println(result);
		
		// 문제3)
		int m = 10;
		int n = 5;
		
		System.out.println((m > 7) && (n <= 5)); // true
		System.out.println((m%3 != 1) || (n%2 == 0)); // false
		
		// 문제4)
		int val = 0;
		val += 10;
		val -= 10;
		val *= 10;
		val /= 10;
		
		// 문제5)
		int num = (val > 0) ? val : 0;
		System.out.println(num);
	}

}
