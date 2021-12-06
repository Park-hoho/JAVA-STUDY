package com.yedam.java.ch03.system;

public class Main {
	
	public static void main(String[] args) {
		//보안관리자 설정
	//	System.setSecurityManager();
		
		//현재시각읽기
		// - currentTimeMills() : 밀리세컨드(1/1000초) 단위
		// - nanoTime() : 나노세컨드(1/10^9초) 단위
		
		long time1 = System.nanoTime();
		int sum = 0;
		for(int i = 1; i < 1_000_000; i++) {
			sum += 1;
		}
		long time2 = System.nanoTime();
		
		System.out.println("합" + sum);
		System.out.println("걸린시간 " + (time2 - time1));
	}
	
}
