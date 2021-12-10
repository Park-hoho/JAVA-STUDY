package com.yedam.java.check2;

import java.util.Scanner;

public class CircleManager {
	//	[문제2]
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 		Circle c[] = new Circle[3]; // 3개의 Circle 배열 선언
 		double x, y;
 		int radius;
 		for(int i=0; i < c.length; i ++) {
    		System.out.print("x, y, radius >>");
    		x = sc.nextDouble();
    		y = sc.nextDouble();
    		radius = sc.nextInt();
    		c[i] = new Circle(x, y, radius); // Circle 객체 생성
 		}
 		for(int i=0; i<c.length; i++) c[i].show(); // 모든 Circle 객체 출력
 		sc.close();
 		System.out.println();
	}
//	x, y, radius >>3.0 3.0 5
//	x, y, radius >>2.5 2.7 6
//	x, y, radius >>5.0 2.0 4
//	(3.0,3.0)5
//	(2.5,2.7)6
//	(5.0,2.0)4
}
