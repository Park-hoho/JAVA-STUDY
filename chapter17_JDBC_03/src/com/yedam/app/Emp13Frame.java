package com.yedam.app;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.yedam.app.emp13.NewEmpDAOImpl;
import com.yedam.app.emp13.NewEmployee;

public class Emp13Frame {
	Scanner sc = new Scanner(System.in);
	
	//constructor
	public Emp13Frame() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			
			if (menuNo == 1) {
				insertEmp();
			} else if (menuNo == 2) {
				updateEmp();
			} else if (menuNo == 3) {
				deleteEmp();
			} else if (menuNo == 4) {
				selectOne();
			} else if (menuNo == 5) {
				selectAll();
			} else if (menuNo == 9) {
				end();
				break;
			}
		}
	}
	
	int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = sc.nextInt();
			if (!checkMenuNo(menuNo)) {
				System.out.println("잘못된 메뉴입니다.");
			}
		} catch (Exception e) {
			sc.next();
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}
	
	boolean checkMenuNo(int menuNo) {
		return Pattern.matches("^[1-5[9]]*$", Integer.toString(menuNo));
	}
	
	private void insertEmp() {
		NewEmployee emp = inputAll();
		NewEmpDAOImpl.getInstance().insert(emp);		
	}

	private void updateEmp() {
		NewEmployee emp = inputAll();
		NewEmpDAOImpl.getInstance().update(emp);		
	}

	private void deleteEmp() {
		System.out.print("사원번호>>");
		int employeeId = sc.nextInt();
		NewEmpDAOImpl.getInstance().delete(employeeId);		
	}

	private void selectOne() {
		System.out.print("사원번호>>");
		int employeeId = sc.nextInt();
		NewEmployee emp = NewEmpDAOImpl.getInstance().selectOne(employeeId);
		if (emp == null) {
			System.out.println(employeeId + "없는 부서입니다.");
		} else {
			System.out.println(emp);
		}
	}

	private void selectAll() {
		List<NewEmployee> list = NewEmpDAOImpl.getInstance().selectAll();
		for (NewEmployee newEmployee : list) {
			System.out.println(newEmployee);
		}
	}

	private void end() {
		System.out.println("프로그램 종료");
	}

	private void menuPrint() {
		System.out.println();
		System.out.println("=============================================");
		System.out.println("1.등록  2.수정  3.삭제  4.사원조회  5.전체조회  9.종료");
		System.out.println("=============================================");
		System.out.print("선택>>");
	}
	
	private NewEmployee inputAll() {
		NewEmployee emp = new NewEmployee();
		System.out.print("사원번호>>");
		emp.setEmployeeId(sc.nextInt());
		System.out.print("이름>>");
		emp.setLastName(sc.next());
		System.out.print("업무>>");
		emp.setJobId(sc.next());
		System.out.print("급여>>");
		emp.setSalary(sc.nextDouble());
		System.out.print("보너스>>");
		emp.setCommissionPct(sc.nextDouble());
		System.out.print("부서번호>>");
		emp.setDepartmentId(sc.nextInt());
		return emp;
	}
	
}
