package com.yedam.java.ch0502;

public class ReferenceTypeExample {
	public static void main(String[] args) {

		int[][] javaScores = {{95, 80},{92,96,80},{100}};
		for(int i = 0; i < javaScores.length; i++) {
			for(int j = 0; j < javaScores[i].length; j++) {
				System.out.printf("javaScores[%d][%d] : %d\n", i, j, javaScores[i][j]);
			}
		}
		
		System.out.println();
		// 객체를 참조하는 배열
		String[] strArray = new String[3];
		strArray[0] = "Java";
		strArray[1] = "Java";
		strArray[2] = new String("Java");
		
		System.out.println(strArray[0] == strArray[1]);		// true
		System.out.println(strArray[0] == strArray[2]);		// false
		System.out.println(strArray[1].equals(strArray[2]));// true
		
		// for 문으로 배열 복사
		int[] oldIntArray = {1, 2, 3};
		int[] newIntArray = new int[5];
		
		for(int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];
		}
		
		// newIntArray -> {1,2,3,0,0}
		
		for(int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ",");
		}
		
		System.out.println();
		// System.arraycopy()로 배열복사
		String[] oldStrArray = {"Java", "Array", "Copy"};
		String[] newStrArray = new String[5];
		System.arraycopy(oldStrArray, 0, newStrArray, 2, oldStrArray.length);
		
		for(String str : newStrArray ) {
			System.out.println(str);
		}
		
		// 향상된 for문
		int[] scores = {95, 71, 84, 93, 87};
		
		int sum = 0;
		for( int score : scores) {
			sum += score;
		}
		
		System.out.println("점수 총합 = " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("점수 평균 = " + avg);
		
		
	}
}
