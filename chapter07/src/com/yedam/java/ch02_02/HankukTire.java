package com.yedam.java.ch02_02;

public class HankukTire extends Tire {
	public HankukTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//method
	@Override
	public boolean roll() {
		accumulatedRotation++;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " HankukTire 수명 : " +
					(maxRotation - accumulatedRotation) + " 회");
			return true;
		} else {
			System.out.println("*** " + location + " Tire 펑크 ***");
			return false;
		}
	}
}
