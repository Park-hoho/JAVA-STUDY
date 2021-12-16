package com.yedam.app.emp;

import java.util.List;

public interface EmpDAO {
	
	//전체조회
	List<Employee> selectAll();
	
	//단건조회
	Employee selectOne(int employeeId);
	
	//입력
	void insert(Employee emp);
	
	//수정
	void update(Employee emp);
	
	//삭제
	void delete(int employeeId);
	
}
