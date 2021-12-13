package com.yedam.java.ch04.lifofifo;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> mQ = new LinkedList<Message>();
		
		//Stack 클래스의 push()
		mQ.offer(new Message("센드EMAIL", "홍길동이"));
		mQ.offer(new Message("센드SMS", "신용권이"));
		mQ.offer(new Message("센드kakao", "홍두깨"));
		
		while(!mQ.isEmpty()) {
			Message me = mQ.poll();
			switch(me.command) {
			case "센드EMAIL":
				System.out.println(me.to + "님에 메일 보냄");
				break;
			case "센드SMS":
				System.out.println(me.to + "님에 SMS 보냄");
				break;
			case "센드kakao":
				System.out.println(me.to + "님에 kakao 보냄");
				break;
			}
		}
	}
	
}
