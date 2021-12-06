package com.yedam.java.ch01.object;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) {
		//객체 동등 비교
		Member obj1 = new Member("blue");
		Member obj2 = new Member("blue");
		Member obj3 = new Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("1과 2는 동등");
		} else {
			System.out.println("1과 2는 다름");
		}
		
		if(obj1.equals(obj3)) {
			System.out.println("1과 3는 동등");
		} else {
			System.out.println("1과 3는 다름");
		}
		
		System.out.println();
		
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		hashMap.put(new Key(1), "홍길동");
		
		String value = hashMap.get(new Key(1));
		System.out.println(value);
		System.out.println();
		
		Object obj4 = new Object();
		System.out.println(obj4.toString());
		
		SmartPhone my = new SmartPhone("google", "Android");
		String st = my.toString();
		System.out.println(st);
		System.out.println();
		
		Member or = new Member("blue", "홍길동", "12", 25, true);
		
		Member cloned = or.getMember();
		cloned.password = "5643";
		System.out.println("복제");
		System.out.println(cloned.id);
		System.out.println(cloned.name);
		System.out.println(cloned.password);
		System.out.println(cloned.age);
		System.out.println(cloned.adult);
		System.out.println();
		System.out.println("원본");
		System.out.println(or.id);
		System.out.println(or.name);
		System.out.println(or.password);
		System.out.println(or.age);
		System.out.println(or.adult);
		System.out.println();
		
	}
	
}
