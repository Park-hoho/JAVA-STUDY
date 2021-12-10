package com.java.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Stacktest {
	
	
	public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<>();
        int now;
        for(int i = 0; i < progresses.length; i++) queue.offer((100 - progresses[i])%speeds[i] == 0 ? (100 - progresses[i])/speeds[i] : ((100 - progresses[i])/speeds[i]) + 1);
        int prev = queue.poll();
        int index = 0;
        answer.add(1);
        while(!queue.isEmpty()) {
        	now = queue.poll();
        	if(prev >= now) {
        		answer.set(index, answer.get(index)+1);
        	} else {
        		prev = now;
        		answer.add(1);
        		index++;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] progresses = {99, 99, 99};
		int[] speeds = {1, 1, 1};
		ArrayList<Integer> answer = new ArrayList<>(Stacktest.solution(progresses, speeds));
		for(int i:answer) {
			System.out.printf("%d, ", i);
		}
		
	}
	
}
