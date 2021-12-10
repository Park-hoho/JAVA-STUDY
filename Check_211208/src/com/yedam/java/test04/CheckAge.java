package com.yedam.java.test04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckAge {
	SimpleDateFormat md = new SimpleDateFormat("yyyyMMdd");
	String today = md.format(new Date());
	int age;
	private static int todayYear = Integer.parseInt(today.substring(0, 4));
	private static int todayMonth = Integer.parseInt(today.substring(4, 6));
	private static todayDay = Integer.parseInt(today.substring(6, 8));
	int ssnYear;
	int ssnMonth;
	int ssnDay;
	
	CheckAge(int ssnYear, int ssnMonth, int ssnDay) {
		this.ssnYear = ssnYear;
		this.ssnMonth = ssnMonth;
		this.ssnDay = ssnDay;
	}
	
	public int getAge() {
		
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
