package com.yedam.java.ch01_01;

public class MainExample {

	public static void main(String[] args) {
		// 클래스 상속

		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		System.out.println("모델 : " + dmbCellPhone.model);
		System.out.println("컬러 : " + dmbCellPhone.color);
		System.out.println("채널 : " + dmbCellPhone.channel);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요.");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		dmbCellPhone.sendVoice("반갑습니다.");
		dmbCellPhone.hangUp();
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		System.out.println();
		// ===부모 생성자 호출
		Student student = new Student("홍길동", "12345-12345467", 1);
		System.out.println("이름 : " + student.name);
		System.out.println("ssn : " + student.ssn);
		System.out.println("학번 : " + student.studentNo);
		
		System.out.println();
		// ===메서드 재정의
		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("원면적 : " + calculator.areaCircle(r));
		
		Computer computer = new Computer();
		System.out.println("원면적 : " + computer.areaCircle(r));
		
		System.out.println();
		//=== 부모메서드 호출
		SupersonicAirplane sa = new SupersonicAirplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicAirplane.NORMAL;
		sa.fly();
		
		sa.land();
		
	
	}

}
