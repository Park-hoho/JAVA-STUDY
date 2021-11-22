package com.yedam.java.ch0503;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Quiz {

	public static void main(String[] args) {
		// 문제) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서 
	    //       최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
	    // 1) 메뉴는 다음과 같이 구성하세요.
	    //  1.상품 수 | 2.가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
	    // 2) 입력한 상품 수만큼 가격을 입력받을 수 있도록 구현하세요.
	    // 3) 각 가격에 해당하는 제품명은 인덱스+1로 합니다. 
		//    예를 들어 배열[0] = 10000 이면 10,000원인 제품은 1번째 제품입니다.
	    // 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
	    // 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		Scanner scanner = new Scanner(System.in);
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		boolean run = true;
		int[] products = null;
		int productsNum = 0;
		int maxName = 0;
		
		while(run) {
			System.out.println("-----------------------------------------------");
			System.out.println("1.상품 수 | 2.가격입력 | 3.제품별 가격 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			switch(selectNo) {
			case 1:
				System.out.print("상품 수> ");
				productsNum = Integer.parseInt(scanner.nextLine());
				products = new int[productsNum];
				break;
			case 2:
				for (int i = 0; i < productsNum; i++) {
					System.out.printf("%d번째 제품 가격> ", i+1);
					products[i] = Integer.parseInt(scanner.nextLine());
				}
				break;
			case 3:
				for (int i = 0; i < productsNum; i++) {
					String price = formatter.format(products[i]);
					System.out.printf("%s원인 제품은 %d번째 제품입니다.\n", price, i+1);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				
				for (int i = 0; i < productsNum; i++) {
					sum += products[i];
					if(products[i] > max) {
						max = products[i];
						maxName = i + 1;
					}
				}
				System.out.println("최고 가격 : " + maxName + "번째 제품 " + formatter.format(max) + "원");
				System.out.println("총 합(최고가 제외) : " + formatter.format(sum - max) + "원");
				break;
			case 5:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료.");
	}

}
