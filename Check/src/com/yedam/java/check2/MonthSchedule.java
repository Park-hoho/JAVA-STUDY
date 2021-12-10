package com.yedam.java.check2;

import java.util.Scanner;

public class MonthSchedule {
	Day[] todo;
	
	MonthSchedule(int totalDay) {
		todo = new Day[totalDay];
	}
	
	public void input(int d, String work) {
		//할일넣기
		todo[d-1] = new Day();
		todo[d-1].set(work);
	}
	
	public void view(int d) {
		//할일보기
		if(todo[d-1] == null) todo[d-1] = new Day();
		System.out.printf("%d일의 할 일은 ", d);
		todo[d-1].show();
	}
	
	public void finish() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void run() {
		boolean start = true;
		int selectNo, d;
		String work;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이번달 스케쥴 관리 프로그램.");
		while(start) {
			System.out.print("할일(입력:1, 보기:2, 끝내기:3) >>");
			selectNo = Integer.parseInt(sc.nextLine());
			switch(selectNo) {
			case 1:
				System.out.print("날짜(1~30)?");
				d = Integer.parseInt(sc.nextLine());
				System.out.print("할일(빈칸없이입력)?");
				work = sc.nextLine();
				input(d, work);
				break;
			case 2:
				System.out.print("날짜(1~30)?");
				d = Integer.parseInt(sc.nextLine());
				view(d);
				break;
			case 3:
				finish();
				start = false;
				break;
			}
		}
		sc.close();
	}
}
