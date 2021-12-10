package com.java.test;

import java.util.ArrayList;
import java.util.Comparator;

public class Sort {
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int start, end, command, length;
        for(int i = 0; i < commands.length; i++) {
        	ArrayList<Integer> list = new ArrayList<>();
        	start = commands[i][0] - 1;
        	end = commands[i][1];
        	command = commands[i][2] - 1;
        	length = end - start;
        	for(int j = 0; j < length; j++) list.add(array[start++]);
        	list.sort(Comparator.naturalOrder());
        	System.out.println(list.get(command));
        	answer[i] = list.get(command);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = Sort.solution(array, commands);
		for(int i:answer) {
			System.out.println(i);
		}
	}
}
