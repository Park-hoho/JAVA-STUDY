package com.yedam.java.app02;

import java.util.List;
import java.util.Scanner;

public class DeptApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		DeptDAO dao = DeptDAO.getInstance();
		Dept dept = null;
		int departmentId = 0;
		
		while(run) {
			System.out.println();
			System.out.println("============================================");
			System.out.println("1.등록  2.수정  3.삭제  4.부서조회  5.전체조회  9.종료");
			System.out.println("============================================");
			System.out.print("선택>>");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				dept = new Dept();
				System.out.print("부서아이디>>");
				dept.setDepartmentId(sc.nextInt());
				System.out.print("부서이름>>");
				dept.setDepartmentName(sc.next());
				System.out.print("매니저>>");
				dept.setLastName(sc.next());
				System.out.print("도시>>");
				dept.setCity(sc.next());
				
				dao.insert(dept);
				break;
			case 2:
				dept = new Dept();
				System.out.print("부서아이디>>");
				dept.setDepartmentId(sc.nextInt());
				System.out.print("매니저>>");
				dept.setLastName(sc.next());
				
				dao.update(dept);
				break;
			case 3:
				System.out.print("부서아이디>>");
				departmentId = sc.nextInt();
				dao.delete(departmentId);
				break;
			case 4:
				System.out.print("부서아이디>>");
				departmentId = sc.nextInt();
				dept = dao.selectOne(departmentId);
				System.out.println(dept);
				break;
			case 5:
				List<Dept> list = dao.selectAll();
				for(Dept department : list) {
					System.out.println(department);
				}
				break;
			case 9:
				run = false;
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				break;
			}
		}
	}
}
