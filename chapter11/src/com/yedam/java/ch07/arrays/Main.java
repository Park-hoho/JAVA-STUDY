package com.yedam.java.ch07.arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//배열복사
		char[] arr1 = {'J', 'A', 'V', 'A'};
		char[] arr2 = Arrays.copyOf(arr1, arr1.length);
		System.out.println(Arrays.toString(arr2));
		
		//부분복사
		char[] arr3 = Arrays.copyOfRange(arr2, 1, 3);
		System.out.println(Arrays.toString(arr3));
		
		//배열 항목 비교 - 이중배열 복사에서 얕은복제는 원본이 변경되면 함께 변경
		int[][] original = {{1,2}, {3,4}};
		
		//얕은 복사 후 비교
		System.out.println("=== 얕은 복제 후 비교 ===");
		int[][] cloned1 = Arrays.copyOf(original, original.length);
		System.out.println("배열 번지 비교 : " + original.equals(cloned1));
		System.out.println("1차 배열 항목값 비교 : " + Arrays.equals(original, cloned1));
		System.out.println("중첩 배열 항목값 비교 : " + Arrays.deepEquals(original, cloned1));
		System.out.println(original[0] == cloned1[0]);
		
		//깊은 복사 후 비교
		System.out.println("=== 깊은 복제 후 비교 ===");
		int[][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2[0] = Arrays.copyOf(original[0], original[0].length);
		cloned2[1] = Arrays.copyOf(original[1], original[1].length);
		
		System.out.println("배열 번지 비교 : " + original.equals(cloned2));
		System.out.println("1차 배열 항목값 비교 : " + Arrays.equals(original, cloned2));
		System.out.println("중첩 배열 항목값 비교 : " + Arrays.deepEquals(original, cloned2));
		System.out.println(original[0] == cloned2[0]);
		System.out.println();
		
		//배열 항목 정렬
		// - 기본 타입 또는 String 배열은 자동으로 오름차순 정렬
		// - 사용자 정의 클래스 타입은 클래스 내에 Comparable 인터페이스를 구현
		int[] scores = {99, 97, 98};
		Arrays.sort(scores);
		for(int i = 0; i < scores.length; i++) {
			System.out.println("scores[" + i + "] : " + scores[i]);
		}
		System.out.println();
		
		String[] na = {"홍길", "박동", "김민"};
		Arrays.sort(na);
		for(int i = 0; i < na.length; i++) {
			System.out.println("names["+i+"] : "+na[i]);
		}
		System.out.println();
		
		Member m1 = new Member("홍길동");
		Member m2 = new Member("박");
		Member m3 = new Member("김");
		Member[] mes = {m1, m2, m3};
		Arrays.sort(mes);
		for(Member m : mes) {
			System.out.println(m.name);
		}
		System.out.println();
		
		//배열 항목 검색
		int[] scores1 = {99, 97, 98};
		Arrays.sort(scores1);
		int index = Arrays.binarySearch(scores1, 99);
		System.out.println("찾은 인덱스 : "+index);
		
		String[] names1 = {"홍길", "박동", "김민"};
		Arrays.sort(names1);
		index = Arrays.binarySearch(names1, "김민");
		System.out.println("찾은 인덱스 : "+index);
		
		Member m4 = new Member("홍길동");
		Member m5 = new Member("박동수");
		Member m6 = new Member("김미수");
		Member[] mList = {m4, m5, m6};
		Arrays.sort(mList);
		System.out.println(m6.name);
		index = Arrays.binarySearch(mList, m6);
		System.out.println("찾은 인덱스 : "+index);
	}

}
