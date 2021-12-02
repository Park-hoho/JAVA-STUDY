package com.yedam.java.ch02_01;

public class Main {

	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		//익명객체 필드 사용
		anony.field.wake();
		
		//익명객체 로컬변수 사용
		anony.method1();
		
		//익명객체 매개값 사용
		anony.method2(new Person() {
			@Override
			public void wake() {
				System.out.println("8시에 일어납니다.");
				study();
			}
			
			public void study() {
				System.out.println("공부합니다.");
			}
		});
		System.out.println();
		RC rc = new RC();
		//익명객체 필드 사용
		rc.field.turnOn();
		//익명객체 로컬변수 사용
		rc.method1();
		//익명객체 매개변수 사용
		rc.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("STV를 켭니다.");				
			}
			
			@Override
			public void turnOff() {
				System.out.println("STV를 끕니다.");								
			}
		});
		
		System.out.println();
		
		Window w = new Window();
		w.button1.touch();
		w.button2.touch();
		
	}

}
