package com.yedam.java.ch02;

public class GenericPrinter<T> {
	private T material;
	
	public void set(T t) {
		this.material = t;
	}
	
	public T get() {
		return material;
	}
}
