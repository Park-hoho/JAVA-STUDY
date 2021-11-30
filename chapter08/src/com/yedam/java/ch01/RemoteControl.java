package com.yedam.java.ch01;

public interface RemoteControl {
	//상수 constant
	public int MAX_VOLUME = 10; // final static 이 생략되어 있다.
	public int MIN_VOLUME = 0;
	
	//추상메서드
	public void turnOn();
	public void turnOff();
	public void setVolume(int volume);

	//default 메서드
	/* 추상 메서드가 아닌 인스턴스 메서드이므로 구현객체가 있어야 사용할 수 있다.
	 * 인터페이스의 모든 구현 객체가 가지고 있는 기본 메서드 -> 메서드 재정의도 가능
	 */
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리함");
		} else {
			System.out.println("무음 해제함");
		}
	}
	
	//정적 메서드
	/* 클래스 생성과 무관하게 사용
	 * 
	 */
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
