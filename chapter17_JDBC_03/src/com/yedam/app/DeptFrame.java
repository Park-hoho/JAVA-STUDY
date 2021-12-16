package com.yedam.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.dept.Dept;
import com.yedam.app.dept.DeptDAOImpl;

public class DeptFrame {
	
	Scanner sc = new Scanner(System.in);
	
	public DeptFrame() {
		while(true) {
			menuPrint();
			int menuNo = menuSelect();
			
			if (menuNo == 1) {
				insertDept();
			} else if (menuNo == 2) {
				updateDept();
			} else if (menuNo == 3) {
				deleteDept();
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
	
	void menuPrint() {
		System.out.println();
		System.out.println("==============================================");
		System.out.println("1.등록  2.수정  3.삭제  4.부서조회  5.전체조회  9.종료");
		System.out.println("==============================================");
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
	
	void insertDept() {
		Dept dept = inputAll();
		DeptDAOImpl.getInstance().insert(dept);
	}
	
	void updateDept() {
		Dept dept = inputAll();
		DeptDAOImpl.getInstance().update(dept);
	}
	
	void deleteDept() {
		int deptNo = inputDeptNo();
		DeptDAOImpl.getInstance().delete(deptNo);
	}
	
	void selectOne() {
		int deptNo = inputDeptNo();
		Dept dept = DeptDAOImpl.getInstance().selectOne(deptNo);
		if (dept == null) {
			System.out.println(deptNo + ": 없는 부서입니다.");
		} else {
			System.out.printf("검색결과는 부서번호: %d, 부서명: %s, 매니저: %d\n",
					dept.getDepartmentId(), dept.getDepartmentName(), dept.getManagerId());
		}
	}
	
	void selectAll() {
		List<Dept> list = DeptDAOImpl.getInstance().selectAll();
		for(Dept dept : list) {
			System.out.printf("부서: %d, %s - 매니저: %d\n", dept.getDepartmentId(), dept.getDepartmentName(), dept.getManagerId());
		}
	}
	
	void end() {
		System.out.println("프로그램을 종료 합니다.");
	}
	
	Dept inputAll() {
		Dept dept = new Dept();
		
		System.out.print("부서 아이디>>");
		dept.setDepartmentId(sc.nextInt());
		System.out.print("부서명>>");
		dept.setDepartmentName(sc.next());
		System.out.print("매니저 아이디>>");
		dept.setManagerId(sc.nextInt());
		System.out.print("지역 아이디>>");
		dept.setLocationId(sc.nextInt());
		
		return dept;
	}
	
	int inputDeptNo() {
		int deptNo = 0;
		System.out.print("부서 아이디>>");
		deptNo = sc.nextInt();
		return deptNo;
	}
	
}
