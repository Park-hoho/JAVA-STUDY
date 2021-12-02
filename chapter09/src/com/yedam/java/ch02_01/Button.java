package com.yedam.java.ch02_01;

public class Button {
	private OnClickListener listener;
	
	public void setOnClickListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void touch() {
		listener.onClick();
	}
	static interface OnClickListener{
		void onClick();
	}
}
