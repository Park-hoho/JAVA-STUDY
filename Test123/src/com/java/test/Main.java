package com.java.test;

import java.util.HashMap;

public class Main {
	
    public static void main(String[] args) {
    	String[] arr1 = {"mislav", "stanko", "mislav", "ana"};
    	String[] arr2 = {"stanko", "ana", "mislav"};
    	
		System.out.println(m1(arr1, arr2));
	}
    
    public static String m1(String[] participant, String[] completion) {
		String answer = "";
		String name = "";
		HashMap<String, Integer> mp1 = new HashMap<>();
		int i = 0;
		for(; i < participant.length; i++) {
			name = participant[i];
			//mp1.put(name, mp1.get(name) + 1);
			mp1.put(name, mp1.containsKey(name) ? 1 + mp1.get(name) : 1);
		}
		
		for(i = 0; i < completion.length; i++) {
			name = completion[i];
			mp1.put(name, mp1.get(name) - 1);
		}
        
		for(String key:mp1.keySet()) {
			if(mp1.get(key) > 0) {
				answer = key;
				break;
			}
		}
		
		return answer;
	}
    
}
