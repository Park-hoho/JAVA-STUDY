package com.yedam.java.helloWorld;

import java.util.Scanner;

public class arrayTest {
	
	public static void main(String[] args) {

		String[] name = {"김상식", "오징어", "배님"};
		for(int i = 0; i < 3; i++) {
			System.out.println(name[i]);
		}
		System.out.println(name);
		
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		
		System.out.println(strArray[0] == strArray[1]);
		System.out.println(strArray[0] == strArray[2]);
		System.out.println(strArray[0].equals(strArray[2]));
		
		System.out.println();
		// 문제4)
		int max = 0;
		int[] array = { 1, 5, 3, 8, 2};
		for (int i = 0; i < array.length; i++) {
			max = (array[i] > max) ? array[i] : max;
		}
		System.out.println("max : " + max);
		
		System.out.println();
		// 문제5)
		int[][] array2 = {
			{95, 86},
			{83, 92, 96},
			{78, 83, 93, 87, 88}				
		};
		
		int sum = 0;
		double avg = 0.0;
		int count = 0;
		for (int i = 0; i < array2.length; i++) {
			for (int z = 0; z < array2[i].length; z++) {
				sum += array2[i][z];
				count++;
			}
		}
		avg = (double) sum / count;
		System.out.println("sum: " + sum);
		System.out.println("avg: " + avg);
		
		System.out.println();
		// 문제6)
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {
				System.out.print("학생수> ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> ", i);
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d]> %d\n", i, scores[i]);
				}
			} else if (selectNo == 4) {
				int highScore = 0;
				int sum2 = 0;
				double average;
				for (int i = 0; i < studentNum; i++) {
					highScore = (scores[i] > highScore) ? scores[i] : highScore;
				}
				for (int i = 0; i < studentNum; i++) {
					sum2 += scores[i];
				}
				average = (double) sum2 / scores.length;
				System.out.println("최고 점수: " + highScore);
				System.out.println("평균 점수: " + average);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

}
