package com.yedam.java.ch02.Objects;

import java.util.Objects;

public class Main {
	
	public static void main(String[] args) {
		//java.utill.Objects
		
		Student s1 = new Student(1);
		Student s2 = new Student(2);
		Student s3 = new Student(3);
		
		int result = Objects.compare(s1, s2, new StudentComparator());
		System.out.println(result);
		
		Integer o1 = 1000;
		Integer o2 = 1000;
		System.out.println(o1 == o2);
		System.out.println(Objects.equals(o1, o2));
		System.out.println();
		
		Integer[] arr1 = {1, 2};
		Integer[] arr2 = {1, 2};
		System.out.println(arr1 == arr2);
		System.out.println(Objects.equals(arr1, arr2));
		System.out.println(Objects.deepEquals(arr1, arr2));
		System.out.println();
		
		Student s4 = new Student(1, "홍");
		Student s5 = new Student(1, "홍");
		System.out.println(s4 == s5);
		System.out.println(s4.hashCode());
		System.out.println(Objects.hashCode(s5));
		System.out.println();
		
		String str1 = "홍길";
		String str2 = null;
		System.out.println(Objects.isNull(str1));
		System.out.println(Objects.nonNull(str2));
		System.out.println(Objects.requireNonNull(str1));
		String name = Objects.requireNonNull(str2, "이름이 없다");
		System.out.println(name);
		
	}
	
}
