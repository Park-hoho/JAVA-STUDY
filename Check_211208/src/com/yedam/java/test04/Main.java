package com.yedam.java.test04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
//		문제4) 아래와 같이 데이터가 주어졌을 경우 남녀 수와 만 20세 이하인 인원을 구하세요.
		String[] persons = {"010302-2","991203-1","969513-2","881125-1","050105-2"};
		
		int boy = 0;
		int girl = 0;
		int underTwenty = 0;
		int ssnSex;
		int age;
		SimpleDateFormat md = new SimpleDateFormat("yyyyMMdd");
		String today = md.format(new Date());
		
		int todayYear = Integer.parseInt(today.substring(0, 4));
		int todayMonth = Integer.parseInt(today.substring(4, 6));
		int todayDay = Integer.parseInt(today.substring(6, 8));
		
		for(int i = 0; i < persons.length; i++) {
			ssnSex = Integer.parseInt(persons[i].substring(7, 8));
			
			int ssnYear = Integer.parseInt(persons[i].substring(0, 2));
			int ssnMonth = Integer.parseInt(persons[i].substring(2, 4));
			int ssnDay = Integer.parseInt(persons[i].substring(4, 6));
			age = checkAge(ssnYear, ssnMonth, ssnDay, todayYear, todayMonth, todayDay);
		
			if(ssnSex == 1) {
				boy++;
			} else if (ssnSex == 2) {
				girl++;
			}
			
			if(age <= 20) {
				underTwenty++;
			}
			
		}
		
		System.out.println("남 " + boy + ", 여 " + girl);
		System.out.println("만 20세 이하 " + underTwenty);
//		- 실행결과
//		남 2, 여 3
//		만 20세 이하 2

	}
	
	public static int checkAge(int ssnYear, int ssnMonth, int ssnDay, int todayYear, int todayMonth, int todayDay) {
		int age;
		
		if(ssnYear > 50) {
			ssnYear += 1900;
		} else {
			ssnYear += 2000;
		}
		
		age = todayYear - ssnYear;
		if(ssnMonth > todayMonth) {
			age -= 1;
		} else if (ssnMonth == todayMonth) {
			if (ssnDay > todayDay) {
				age -= 1;
			}
		}
		return age;
	}

}
