package com.yedam.java.ch04.Class;

import com.yedam.java.ch01.object.Car;

public class Main {

	public static void main(String[] args) {
		//Class clazz = Car.class;
		Car car = new Car();
		Class clazz = car.getClass();
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
		System.out.println(clazz.getConstructors());
	}

}
