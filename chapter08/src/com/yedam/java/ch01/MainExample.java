package com.yedam.java.ch01;

public class MainExample {

	public static void main(String[] args) {
		RemoteControl rc1;
		rc1 = new Audio();
		rc1.turnOn();
		rc1 = new Television();
		rc1.turnOn();
		
		// 익명 구현 객체 -> 재사용은 불가하다.
		RemoteControl rc2 = new RemoteControl() {

			@Override
			public void turnOn() {
				System.out.println("전원on");
			}

			@Override
			public void turnOff() {
				System.out.println("전원off");				
			}

			@Override
			public void setVolume(int volume) {
				System.out.println(volume);
			}
			
		}; 
		
		rc2.turnOn();
		rc2.setVolume(3);
		System.out.println();
		
		RemoteControl rc3;
		rc3 = new Television();
		rc3.turnOn();
		rc3.setMute(true);
		System.out.println();
		
		rc3 = new Audio();
		rc3.turnOn();
		rc3.setMute(true);
		System.out.println();
		
		RemoteControl.changeBattery();
		System.out.println();
		
		SmartTelevision tv = new SmartTelevision();
		RemoteControl rc = tv;
		Searchable searchable = tv;
		
		System.out.println("1)-------------------------");
		MyClass myClass1 = new MyClass();
		myClass1.rc.turnOn();
		myClass1.rc.setVolume(5);
		
		System.out.println("2)-------------------------");
		MyClass myClass2 = new MyClass(new Audio());
		
		
		System.out.println("3)-------------------------");
		MyClass myClass3 = new MyClass();
		myClass3.methodA();
		
		System.out.println("4)-------------------------");
		MyClass myClass4 = new MyClass();
		myClass3.methodB(new Television());
	
	}

}
