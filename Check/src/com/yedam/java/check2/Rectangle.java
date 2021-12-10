package com.yedam.java.check2;

public class Rectangle {
	int x;
	int y;
	int width;
	int height;
	
	Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int square() {
		return width * height;
	}
	
	public void show() {
		System.out.printf("(%d, %d)에서 크기가 %dx%d인 사각형\n", x, y, width, height);
	}
	
	public boolean contains(Rectangle r) {
		if(x < r.x && y < r.y) {
			if(x+width > r.x+r.width && y+height > r.y + r.height) {
				return true;
			}
		}
		return false;
	}
}
