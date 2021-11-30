package com.yedam.java.ch01;

public class MyClass {
	//field
	RemoteControl rc = new Television();
	
	//constructor
	MyClass() {}

	MyClass(RemoteControl rc) {
		this.rc = rc;
		this.rc.turnOn();
		this.rc.setVolume(5);
	}
	
	//method
	void methodA() {
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.setVolume(3);
	}
	
	void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(8);
	}
	
}
