package com.java.test;

import java.util.Arrays;

public class Stacktest2 {
	
	
	public static int[] solution(int[] progresses, int[] speeds) {
		int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
	
	public static void main(String[] args) {
		int[] progresses = {99, 99, 99};
		int[] speeds = {1, 1, 1};
		int[] answer = Stacktest2.solution(progresses, speeds);
		for(int i:answer) {
			System.out.printf("%d, ", i);
		}
		
	}
	
}
