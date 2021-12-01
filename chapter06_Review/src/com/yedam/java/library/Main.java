package com.yedam.java.library;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
		String name = null;
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("1.책정보 입력 | 2.전체조회 | 3.단건조회 | 4.책대여 | 5.책반납 | 6.인기순위 | 7.종료");
			System.out.println("선택> ");
			int menuNo = sc.nextInt();
			
			switch(menuNo) {
			case 1:
				System.out.println("책 정보>");
				name = sc.next();
				String writer = sc.next();
				library.addBook(name, writer);
				break;
			case 2:
				library.printBookList();
				break;
			case 3:
				System.out.println("책 이름>");
				name = sc.next();
				library.selectBookInfo(name);
				break;
			case 4:
				System.out.println("책 이름>");
				name = sc.next();
				library.rentalBook(name);
				break;
			case 5:
				System.out.println("책 이름>");
				name = sc.next();
				library.returnBook(name);
				break;
			case 6:
				library.showRank();
				break;
			case 7:
				run = false;
				System.out.println("프로그램 종료");
			}
		}
		sc.close();
	}

}
