package com.yedam.java.ch01.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "Database");
		list.add("iBatis");
		System.out.println(list);

		int size = list.size();
		System.out.println("총 객체 수 : " + size);
		
		String skill = list.get(2);
		System.out.println("2 : " + skill);
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("iBatis");
		
		list.forEach(name -> System.out.println(name));
		IntStream.range(0, list.size()).forEach(index -> System.out.println((index + 1) + " : " + list.get(index)));
	}

}
