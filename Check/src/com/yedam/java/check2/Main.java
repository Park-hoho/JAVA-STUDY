package com.yedam.java.check2;

public class Main {
 	//[문제1]
		public static void main(String[] args) {
   			Rectangle r = new Rectangle(2, 2, 8, 7);
   			Rectangle s = new Rectangle(5, 5, 6, 6);
   			Rectangle t = new Rectangle(1, 1, 10, 10);
   
   			r.show();
   			System.out.println("s의 면적은 "+s.square());
   			if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
   			if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
   			System.out.println();
//			- 실행결과
//			(2,2)에서 크기가 8x7인 사각형
//			s의 면적은 36
//			t는 r을 포함합니다.

// 			[문제3]
   	  		MonthSchedule april = new MonthSchedule(30); // 4월달의 할 일
   	  		april.run();
   	  		System.out.println();

		}

}
