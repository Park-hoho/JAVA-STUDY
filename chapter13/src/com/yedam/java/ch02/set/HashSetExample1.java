package com.yedam.java.ch02.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample1 {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servlet/JSP");
		set.add("Java");
		set.add("ibatis");
		
		int size = set.size();
		System.out.println("총 객체수 : " + size);
		
		//반복자
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("JDBC");
		set.remove("ibatis");
		System.out.println("총 객체수 : " + set.size());
		
		set.forEach(element -> System.out.println(element));
		set.clear();
		System.out.println(set.isEmpty() ? "비어있음" : "있음");
	}
	
}
