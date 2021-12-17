package com.yedam.java.app;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=============================");
		System.out.println("1.Customer  2.Manager  3.EXIT");
		System.out.println("=============================");
		System.out.print("선택>>");
		int selected = sc.nextInt();
		
		if (selected == 1) {
			new CustomerFrame();
		} else if (selected == 2) {
			new ManagerFrame();
		}
		
		sc.close();
	}

}
