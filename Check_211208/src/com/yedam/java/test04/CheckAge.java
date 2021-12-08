package com.yedam.java.test04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckAge {
	int age;
	int todayYear;
	int todayMonth;
	int todayDay;
	int ssnYear;
	int ssnMonth;
	int ssnDay;
	SimpleDateFormat md = new SimpleDateFormat("yyyyMMdd");
	String today = md.format(new Date());
	
	CheckAge(int ssnYear, int ssnMonth, int ssnDay) {
		todayYear = Integer.parseInt(today.substring(0, 4));
		todayMonth = Integer.parseInt(today.substring(4, 6));
		todayDay = Integer.parseInt(today.substring(6, 8));
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
