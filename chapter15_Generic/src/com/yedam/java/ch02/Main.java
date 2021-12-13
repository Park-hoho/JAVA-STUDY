package com.yedam.java.ch02;

import cpm.yedam.java.ch03.Box;

public class Main {

	public static void main(String[] args) {
		Box<String> box1 = new Box<String>();
		box1.set("홍길동");
		String name = box1.get();
		
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		powderPrinter.set(new Powder());
		Powder powder = powderPrinter.get();
		System.out.println(powder);
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.set(new Plastic());
		Plastic plastic = plasticPrinter.get();
		System.out.println(plastic);
	}

}
