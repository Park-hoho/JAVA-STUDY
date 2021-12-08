package com.yedam.java.ch10.random;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//선택번호
		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.print("선택 번호 : ");
		for(int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		//당첨번호
		int[] winNum = new int[6];
		random = new Random(5);
		System.out.print("당첨 번호 : ");
		for(int i = 0; i < 6; i++) {
			winNum[i] = random.nextInt(45) + 1;
			System.out.print(winNum[i] + " ");
		}
		System.out.println();
		
		//당첨여부
		Arrays.sort(selectNumber);
		Arrays.sort(winNum);
		boolean result = Arrays.equals(selectNumber, winNum);
		System.out.print("당첨 여부 : ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
	}

}
