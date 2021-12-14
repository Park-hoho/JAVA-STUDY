package com.yedam.java.app01;

import java.util.List;

public class EmpApp {
	
	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();
		List<Employee> datas = dao.selectAll();
		for(Employee data : datas) {
			System.out.println(data);
		}
		
		
	}
	
}
