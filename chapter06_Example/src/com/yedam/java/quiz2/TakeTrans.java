package com.yedam.java.quiz2;

public class TakeTrans {

	public static void main(String[] args) {
		Student james = new Student("James", 5000);
		Student tomas = new Student("Tomas", 5000);
		Student edward = new Student("Edward", 20000);

		Bus bus100 = new Bus(100);
		james.take(bus100);
		
		Subway subwayGreen = new Subway("2호선");
		tomas.take(subwayGreen);
		
		Taxi taxi = new Taxi("19바4335");
		edward.take(taxi);
		
		james.showInfo();
		tomas.showInfo();
		edward.showInfo();
		
		bus100.showInfo();
		subwayGreen.showInfo();
		taxi.showInfo();
		
	}

}
