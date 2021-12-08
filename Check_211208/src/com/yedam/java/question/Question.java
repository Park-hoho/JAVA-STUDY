package com.yedam.java.question;

public class Question {
/*
 	 문제1) 다음을 만족하는 클래스 SalaryMan을 선언하세요.
		· 필드 salary는 월 급여액를 저장하며, int형으로 초기 값으로 1000,000 저장
		· 메소드 getAnnualGross()는 연봉을 반환하는 메소드로 12개월치 월급에 한달치 급여액 * 보너스 500%을 더함
		· 기본 생성자에서 필드 salary의 초기 값을 사용하며, 정수형 인자인 생성자에서 인자가 월 급여액으로 지정
		· 다음과 같이 객체를 생성하여 메소드 getAnnualGrass()를 호출하여 출력
		public static void main(String[] args){
			System.out.println(new SalaryMan().getAnnualGross());
			System.out.println(new SalaryMan(2000000).getAnnualGross());
		}
		
	 문제2) 원을 표현하는 다음 Circle 클래스가 있습니다. 
	 	   Circle 클래스를 상속받은 NamedCircle 클래스를 선언하여, 다음 main()을 실행할 때 다음 실행 결과와 같이 출력되도록 하세요.
	 	   - class Circle {
				private int radius;
				public Circle(int radius) {
					this.radius = radius;
				}
				public void show() {
					System.out.println("반지름 = " + this.radius);
				}
			}
			
			- 실행코드
			public static void main(String[] args) {
				Circle w = new NamedCircle(5, "Waffle");
				w.show();
			}
			
			- 실행결과
			Waffle, 반지름 = 5
			
	 문제3) 인터페이스 AdderInterface의 코드는 다음과 같습니다. 
	 	   AdderInterface를 상속받은 클래스 MyAdder를 선언하여, 다음 main() 을 실행할 때 아래 실행 결과와 같이 출력되도록 하세요.
	 	   - interface AdderInterface {
				int add(int x, int y);
				int add(int n);
			}
			
			- 실행코드
			public static void main(String[] args) {
				AdderInterface adder = new MyAdder();
				System.out.println(adder.add(5,10));
				System.out.println(adder.add(10));
			}
			
			- 실행결과 
				15
				55
	  문제4) 아래와 같이 데이터가 주어졌을 경우 남녀 수와 만 20세 이하인 인원을 구하세요.
	  		String[] persons = {"010302-2","991203-1","969513-2","881125-1","050105-2"};
	  		
	  		- 실행결과
	  		남 2, 여 3
	  		만 20세 이하 2
	
 */
}
