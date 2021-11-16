package com.yedam.java.ch0301;

public class OperatorExample {

	public static void main(String[] args) {
		// 부호연산자
		int a = -100;
		int result1 = +a;
		int result2 = -a;
		System.out.println("a : " + a);
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		
		byte b = 100;
		// byte result3 = -b;
		int result3 = -b;
		System.out.println("result3 : " + result3);
		
		// 증감연산자
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("------------------------");
		x++;
		++x;
		System.out.println("x : " + x);
		
		System.out.println("------------------------");
		y--;
		--y;
		System.out.println("y : " + y);
		
		System.out.println("------------------------");
		z = x++;
		System.out.println("z : " + z); // 12 증감연산자가 뒤에 붙어있어서 그럼
		System.out.println("x : " + x); // 13
		
		System.out.println("------------------------");
		z = ++x;
		System.out.println("z : " + z); // 14
		System.out.println("x : " + x); // 14
		
		System.out.println("------------------------");
		z = ++x + y++;
		// x+1 => X -> z = X + y -> y+1
		System.out.println("z : " + z); // 23
		System.out.println("x : " + x); // 15
		System.out.println("y : " + y); // 9
		
		x = 5;
		y = 5;
		
		System.out.println("------------------------");
		z = x++ + --y;
		System.out.println("z : " + z); // 9
		System.out.println("x : " + x); // 6
		System.out.println("y : " + y); // 4
		
		System.out.println("------------------------");
		z = --x + y++;
		System.out.println("z : " + z); // 9
		System.out.println("x : " + x); // 5
		System.out.println("y : " + y); // 5
	
		// 논리 부정 연산자
		boolean play = true;
		System.out.println(play);
		
		play = !play;
		System.out.println(play);
		
		play = !play;
		System.out.println(play);
		
		// 산술 연산자
		int v1 = 5;
		int v2 = 2;
		int result;
		
		result = v1 + v2;
		System.out.println("+ : " + result);
		
		result = v1 - v2;
		System.out.println("- : " + result);
		
		result = v1 * v2;
		System.out.println("* : " + result);
		
		result = v1 / v2;
		System.out.println("/ : " + result);
		
		result = v1 % v2;
		System.out.println("% : " + result);
		
		// char 타입의 산술연산
		char c1 = 'A' + 1;
		char c2 = 'A';
		//char c3 = c2 + 1;
		int r1 = c2 + 1;
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("r1의 유니코드 : " + r1);
		System.out.println("r1의 출력문자 : " + (char)r1);
		
		// 문자열 결합 연산
		String str1 = "JDK" + 6.0;
		String str2 = str1 + " 특징";
		System.out.println(str2);
		
		String str3 = "JDK" + 3 + 3.0;
		String str4 = 3 + 3.0 + "JDK";
		System.out.println(str3);
		System.out.println(str4);
		
		// 비교 연산자
		int num1 = 10;
		int num2 = 10;
		boolean bResult1 = (num1 == num2);
		boolean bResult2 = (num1 != num2);
		boolean bResult3 = (num1 <= num2);
		System.out.println("== : " + bResult1);
		System.out.println("!= : " + bResult2);
		System.out.println("<= : " + bResult3);
		
		char char1 = 'A';
		char char2 = 'B';
		boolean bResult4 = (char1 < char2);
		System.out.println(bResult4);
		
		int v3 = 1;
		double v4 = 1.0;
		System.out.println(v3 == v4);
		
		double v5 = 0.1;
		float v6 = 0.1f;
		System.out.println((float)v5 == v6);
		
		// 논리연산자
		int charCode = 'A';
		
		// 유니코드 중 65보다 크거나 같으며 90보다 작거나 같으면 대문자
		if((charCode >= 65) && (charCode <= 90)) {
			System.out.println("대문자");
		}
		// 유니코드 중 97보다 크거나 같으며 122보다 작거나 같으면 소문자
		if((charCode >= 97) && (charCode <= 122)) {
			System.out.println("소문자");
		}
		// 유니코드 중 48보다 크고 57보다 작으면 숫자 0~9
		if((charCode > 48) && (charCode < 57)) {
			System.out.println("숫자 0~9");
		}
		
		int numValue = 6;
		if((numValue % 2 == 0) || (numValue % 3 == 0)) {
			System.out.println("2 또는 3의 배수군요.");
		}
		
		// 대입연산자
		int result10 = 0;
		result10 += 10;
		System.out.println("+= : " + result10);
		result10 -= 5;
		System.out.println("-= : " + result10);
		result10 *= 3;
		System.out.println("*= : " + result10);
		result10 /= 5;
		System.out.println("/= : " + result10);
		result10 %= 3;
		System.out.println("%= : " + result10);
		
		// 삼항연산자
		int score = 95;
		char grade = (score > 90) ? 'A' : 'B';
		/*
		 char grade;
		 if (score > 90) {
		 	grade = 'A';
		 } else {
		 	grade = 'B';
		 }
		 */
		System.out.printf("성적은 %d점이고 등급은 %c 입니다\n", score, grade);
		
		int age = 27;
		String str = (age >= 20) ? "성인" : "미성년";
		System.out.printf("나이는 %d이고 %s입니다.\n", age, str);
		
		
		
		
		
	}

}
