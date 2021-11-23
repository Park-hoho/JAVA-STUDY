package com.yedam.java.ch0605;

public class MainExample {
	String message;
	
	void println() {
		System.out.println(this.message);
	}
	
	
	public static void main(String[] args) {
		// 인스턴스 멤버와 this
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		yourCar.run();
		
		// 정적 멤버 사용
		double result1 = 10 * 10 * Calculator.pi;
		int result2 = Calculator.plus(10, 5);
		int result3 = Calculator.minus(10, 5);
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		System.out.println("result3 : " + result3);
		
		// 정적 메서드 선언 시 주의 점
		MainExample main = new MainExample();
		main.message = "Today is ... !";
		main.println();
		
		// 싱글톤
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2) {
			System.out.println("같은 singleton 객체입니다.");
			// 같은 주소값
		}else {
			System.out.println("다른 singleton 객체입니다.");
		}
		
		//final 필드 테스트
		Person p1 = new Person("123456-1234567", "홍길동");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
//		p1.ssn = "654321-7654321";
		p1.name = "홍삼원";
		
		// 상수 선언 및 사용
		System.out.println("지구의 반지름 : " + Earth.EARTH_RADIUS + "km");
		System.out.println("지구의 표면적 : " + Earth.EARTH_AREA + "km^2");
	}

}
