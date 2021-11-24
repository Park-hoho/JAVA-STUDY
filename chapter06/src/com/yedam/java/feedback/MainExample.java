package com.yedam.java.feedback;

import java.util.Scanner;

public class MainExample {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		int productsNum = 0;
		Product[] products = null;
		int maxName = 0;
		
		while(run) {
			System.out.println("1.상품 수 | 2.상품정보입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.print("선택> ");
			int selectNo = scanner.nextInt();
			
			switch(selectNo) {
			case 1:
				System.out.print("상품 수> ");
				productsNum = scanner.nextInt();
				products = new Product[productsNum];
				break;
			case 2:
				for (int i = 0; i < products.length; i++) {
					System.out.println("상품정보 입력>");
					String name = scanner.next();
					int price = scanner.nextInt();
					
					Product product = new Product(name, price);
					products[i] = product;
				}
				break;
			case 3:
				for (int i = 0; i < productsNum; i++) {
					Product product = products[i];
					String name = product.getName();
					int price = product.getPrice();
					System.out.println(name + " : " + price);
				}
				break;
			case 4:
				int max = 0;
			
				for (Product product : products) {
					int price = product.getPrice();
					if(price > max) {
						max = price;
					}
				}
				int sum = 0;
				String name = null;
				for(int i = 0; i < products.length; i++) {
					Product product = products[i];
					String productName = product.getName();
					int price = product.getPrice();
					if(price == max) {
						name = productName;
						continue;
					}
					sum += price;
				}
				
				System.out.println("최고 가격을 가진 제품은 " + name + "입니다.");
				System.out.println("총 합(최고가 제외) : " + sum + "원");
				break;
			case 5:
				run = false;
				break;
		}
		}
	}

}
