package com.yedam.java.ch11.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		//Date 클래스
		Date now = new Date();
		String strNow1 = now .toString();
		System.out.println(strNow1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
		//Calendat 클래스
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "회";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		case Calendar.SUNDAY:
			strWeek = "일";
			break;
		}
		
		int amPm = cal.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		}else {
			strAmPm = "오후";
		}
		
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE) + 1;
		int second = cal.get(Calendar.SECOND);
		
		System.out.print(year + " ");
		System.out.print(month + " ");
		System.out.print(day + " ");
		System.out.println(strWeek + " ");
		System.out.print(strAmPm + " ");
		System.out.print(hour + " ");
		System.out.print(min + " ");
		System.out.print(second + " ");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
