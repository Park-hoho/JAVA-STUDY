package com.yedam.java.ch02;

public class TryCatchfinallyException {
	public static void main(String[] args) {
		//try~catch~finally 블록
		try {
			//실제로 실행되어야하는 코드
		} catch(Exception e) {
			//예외가 발생했을 때 처리하는 코드
		} finally {
			//(생략가능)실제로 실행이 되었든, 예외가 발생했든
			//반드시 실행되어야 하는 코드
		}
		
		//일반 예외 처리
		try {
			Class clazz = Class.forName("java.lang.String2");
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
		//실행 예외 처리
		String data1 = null;
		String data2 = null;
		
		try {
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
		}
		
		try {
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			
			System.out.printf("%d + %d = %d\n", value1, value2, result);
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변활할 수 없습니다.");			
		} finally {
			System.out.println("다시 실행하세요.");
		}
		System.out.println();
		
		//다중 catch
		try {
			String data3 = args[0]; //여기서 예외발생하고 아래 코드는 실행자체가 안된다.
			String data4 = args[1];
			
			int value3 = Integer.parseInt(data3);
			int value4 = Integer.parseInt(data4);
			int result = value3 + value4;
			System.out.printf("%d + %d = %d\n", value3, value4, result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개값의 수가 부족합니다.");
		} catch(NumberFormatException e) {
			System.out.println("숫자로 변환할 수 없습니다.");
		} catch(Exception e) {
			System.out.println("실행에 문제가 있습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
		
		findClass();
//		try {
//			findClass();
//		} catch (ClassCastException e) {
//			System.out.println("no class");
//		}
		
	}
	//throws - 메서드를 호출한 곳에서 예외처리를 한다.
	public static void findClass() throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String2");
	}
}
