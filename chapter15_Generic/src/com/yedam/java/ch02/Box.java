package com.yedam.java.ch02;

public class Box<T> {
	//모든 T에 String으로 변환이 된다.
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
}
