package com.yedam.java.app03;

import java.util.List;
import java.util.Scanner;

public class EmpApp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		EmpDAO dao = EmpDAO.getInstance();
		Employee emp = null;
		int employeeId = 0;
		
		while(run) {
			System.out.println();
			System.out.println("============================================");
			System.out.println("1.등록  2.수정  3.삭제  4.사원조회  5.전체조회  9.종료");
			System.out.println("============================================");
			System.out.print("선택>>");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				emp = new Employee();
				System.out.print("사번>>");
				emp.setEmployeeId(sc.nextInt());
				System.out.print("이름>>");
				emp.setLastName(sc.next());
				System.out.print("직급>>");
				emp.setJobId(sc.next());
				System.out.print("연봉>>");
				emp.setSalary(sc.nextDouble());
				System.out.print("상여>>");
				emp.setCommissionPct(sc.nextDouble());
				System.out.print("부서>>");
				emp.setDepartmentId(sc.nextInt());
				
				dao.insert(emp);
				break;
			case 2:
				emp = new Employee();
				System.out.print("사번>>");
				emp.setEmployeeId(sc.nextInt());
				System.out.print("연봉>>");
				emp.setSalary(sc.nextDouble());
				
				dao.update(emp);
				break;
			case 3:
				System.out.print("사번>>");
				employeeId = sc.nextInt();
				dao.delete(employeeId);
				break;
			case 4:
				System.out.print("사번>>");
				employeeId = sc.nextInt();
				emp = dao.selectOne(employeeId);
				System.out.println(emp);
				break;
			case 5:
				List<Employee> list = dao.selectAll();
				for(Employee employee : list) {
					System.out.println(employee);
				}
				break;
			case 9:
				run = false;
				System.out.println("프로그램 종료");
				sc.close();
				break;
			}
		}
	}
	
}
