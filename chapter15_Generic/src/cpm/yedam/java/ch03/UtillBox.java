package cpm.yedam.java.ch03;

public class UtillBox {
	//선언, return타입, method name
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
		
	}
}
