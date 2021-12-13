package cpm.yedam.java.ch03;

public class Main {

	public static void main(String[] args) {
		Product<TV, String> p1 = new Product<TV, String>();
		p1.setKind(new TV());
		p1.setModel("스마트TV");
		TV tv = p1.getKind();
		String tvModel = p1.getModel();
		
		Product<Car, String> p2 = new Product<Car, String>();
		p2.setKind(new Car());
		p2.setModel("디젤");
		Car car = p2.getKind();
		String carModel = p2.getModel();

		//tilboc_t가 매개변수레서도 
//		Box<Integer> box1 = UtilBox.<Integer>boxing(100);
//		int intVal = box1.get();
//
//		Box<String> box2 = UtilBox.<Integer>boxing("gjgd");
//		String name = box2.get();
		
//		Pair<Integer, String> d1 = new Pair<Integer, String>(1, "사과");
//		Pair<Integer, String> d2 = new Pair<Integer, String>(1, "사과");
//		boolean result1 = UtilPair.<Integer, String>compare(p1, p2);
//		
//		if (result1) {
//			System.out.println("논리적으로 동 객");
//		} else {
//			System.out.println("논리적으로 동 X 객");
//		}
//		
		Point<Integer, Double> d3 = new Point<Integer, Double>(0, 0.0);
		Point<Integer, Double> d4 = new Point<Integer, Double>(10, 10.0);
		
		double rect = GenericMethod.makeRectangle(d3, d4);
		System.out.println("두 점으로 만든 사각 넓이 : " + rect);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
