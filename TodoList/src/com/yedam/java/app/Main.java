package com.yedam.java.app;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Todo List Application===");
		System.out.println("1.User  2.Admin  0.EXIT");
		System.out.print("선택>>");
		int selected = sc.nextInt();
		
		if (selected == 1) {
			new UserFrame();
		} else if (selected == 2) {
			new AdminFrame();
		}
		
		sc.close();
	}
	
}
