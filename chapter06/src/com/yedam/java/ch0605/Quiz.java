package com.yedam.java.ch0605;

public class Quiz {
	
	public static void main(String[] args) {
		
	//문제1 : 책 페이지 268, 3번
	MemberService memberService = new MemberService();
	boolean result = memberService.login("hong", "12345");
	if(result) {
		System.out.println("로그인 되었습니다.");
		memberService.logout("hong");
	}else {
		System.out.println("id 또는 password가 올바르지 않습니다.");
	}
	
	//문제2 : 책 페이지 269, 4번
	Printer printer = new Printer();
	printer.println(10);
	printer.println(true);
	printer.println(5.7);
	printer.println("홍길동");
	
	//문제3 : 책 페이지 285, 3번
	ShopService obj1 = ShopService.getInstance();
	ShopService obj2 = ShopService.getInstance();
	
	if(obj1 == obj2) {
		System.out.println("같은 ShopService 객체입니다.");
	}else {
		System.out.println("다른 ShopService 객체입니다.");
	}
	
	}
	
}
