package com.yedam.java.test;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		int diceNum = 0;
		int dice;
		int count = 0;
		int[] diceArr = null;
		
		while(run) {
			System.out.println("===1.주사위 크기 2.주사위 굴리기 3.결과 보기 4.가장 많이 나온 수 5.종료===");
			System.out.print("메뉴 >");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			switch(selectNo) {
			case 1:
				System.out.print("주사위 크기 >");
				boolean run2 = true;
				while(run2) {
					diceNum = Integer.parseInt(scanner.nextLine());
					switch(diceNum) {
					case 5:
					case 6:
					case 7:
					case 8:
					case 9:
					case 10:
						run2 = false;
						 diceArr = new int[diceNum];
						break;
					default:
						System.out.println("5 ~ 10 사이의 숫자를 입력해주세요.");
						System.out.print("주사위 크기 >");
					}
				}
				break;
			case 2:
				// 굴리기
				while(true) {
					dice = (int)(Math.random() * diceNum) + 1;
					diceArr[dice - 1] += 1;
					count++;
					if (dice == 5) {
						break;
					}
				}
				System.out.println("5가 나올 때까지 주사위를 "+ count +"번 굴렸습니다.");
				break;
			case 3:
				for(int i = 0; i < diceNum; i++) {
					System.out.printf("%d은 %d번 나왔습니다.\n", i+1, diceArr[i]);
				}
				break;
			case 4:
				int max = 0;
				int bestNum = 0;
				for (int i = 0; i < diceArr.length; i++) {
					if (diceArr[i] > max) {
						max = diceArr[i];
					}
				}
				for (int i = 0; i < diceArr.length; i++) {
					if (max == diceArr[i]) {
						bestNum = i + 1;
						break;
					}
				}
				System.out.printf("가장 많이 나온 수는 %d입니다.\n", bestNum);
				break;
			case 5:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
