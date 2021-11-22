package com.yedam.java.ch0503;

import java.util.Calendar;

public class EnumerationExample {

	public static void main(String[] args) {
		Week week = null;
		
		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(today) {
		case 1:
			week = Week.SUNDAY;
			break;
		case 2:
			week = Week.MONDAY;
			break;
		case 3:
			week = Week.TUESDAY;
			break;
		case 4:
			week = Week.WEDNSEDAY;
			break;
		case 5:
			week = Week.THURSDAY;
			break;
		case 6:
			week = Week.FRIDAY;
			break;
		case 7:
			week = Week.SATURDAY;
			break;
		}
		
		System.out.println("오늘 요일 : " + week);
		
		if (week == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바를 공부합니다.");
		}
	}

}
