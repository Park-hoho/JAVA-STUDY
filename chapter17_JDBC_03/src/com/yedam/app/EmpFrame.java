package com.yedam.app;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.app.emp.EmpDAOImpl;
import com.yedam.app.emp.Employee;

public class EmpFrame {
	//필드
	Scanner sc = new Scanner(System.in);
	
	public EmpFrame() {
		while(true) {
			//메뉴 출력
			menuPrint();
			//메뉴 선택
			int menuNo = menuSelect();
			
			//메뉴1 : 입력
			if (menuNo == 1) { 
				insertEmp();
			}
			//메뉴2 : 수정
			else if (menuNo == 2) {
				updateEmp();
			}
			//메뉴3 : 삭제
			else if (menuNo == 3) {
				deleteEmp();
			}
			//메뉴4 : 단건조회
			else if (menuNo == 4) {
				selectOne();
			}
			//메뉴5 : 전체조회
			else if (menuNo == 5) {
				selectAll();
			}
			//메뉴9 : 종료
			else if (menuNo == 9) {
				end();
				break;
			}
		}
	}
	
	void menuPrint() {
		System.out.println();
		System.out.println("=============================================");
		System.out.println("1.등록  2.수정  3.삭제  4.사원조회  5.전체조회  9.종료");
		System.out.println("=============================================");
		System.out.print("선택>>");
	}
	
	int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = sc.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}
	
	void insertEmp() {
		//값을 입력받아야 함
		Employee emp = inputAll();
		//insert
		EmpDAOImpl.getInstance().insert(emp);
	}
	
	void updateEmp() {
		Employee emp = inputAll();
		EmpDAOImpl.getInstance().update(emp);
	}

	void deleteEmp() {
		int employeeId = inputEmpId();
		EmpDAOImpl.getInstance().delete(employeeId);
	}
	
	void selectOne() {
		int employeeId = inputEmpId();
		Employee emp = EmpDAOImpl.getInstance().selectOne(employeeId);
		System.out.println(emp);
	}
	
	void selectAll() {
		List<Employee> list = EmpDAOImpl.getInstance().selectAll();
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
	
	void end() {
		System.out.println("프로그램을 종료합니다.");
	}
	
	Employee inputAll() {
		Employee emp = new Employee();
		System.out.print("사번>>");
		emp.setEmployeeId(sc.nextInt());
		System.out.print("이름>>");
		emp.setFirstName(sc.next());
		System.out.print("성>>");
		emp.setLastName(sc.next());
		System.out.print("이메일>>");
		emp.setEmail(sc.next());
		System.out.print("전화번호>>");
		emp.setPhoneNumber(sc.next());
		System.out.print("입사일(YYYY-MM-DD)>>");
		emp.setHireDate(Date.valueOf(sc.next())); //입력형식 : YYYY-MM-DD
		System.out.print("직급>>");
		emp.setJobId(sc.next());
		System.out.print("연봉>>");
		emp.setSalary(sc.nextDouble());
		System.out.print("상여>>");
		emp.setCommissionPct(sc.nextDouble());
		System.out.print("상사>>");
		emp.setManagerId(sc.nextInt());
		System.out.print("부서>>");
		emp.setDepartmentId(sc.nextInt());
		
		return emp;
	}
	
	int inputEmpId() {
		int employeeId = 0;
		System.out.println("사원번호>>");
		employeeId = sc.nextInt();
		return employeeId;
	}
}
