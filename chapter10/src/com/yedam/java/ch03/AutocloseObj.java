package com.yedam.java.ch03;

public class AutocloseObj implements AutoCloseable{

	@Override
	public void close() throws Exception {
		System.out.println("리소스가 close() 되었습니다.");
	}
	
}
