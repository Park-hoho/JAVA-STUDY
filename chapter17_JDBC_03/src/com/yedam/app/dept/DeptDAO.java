package com.yedam.app.dept;

import java.util.List;

public interface DeptDAO {
	//기능 정의
	//전체조회
	List<Dept> selectAll();
	
	//단건조회
	Dept selectOne(int departmentId);
	
	//등록
	void insert(Dept dept);
	
	//수정
	void update(Dept dept); 

	//삭제
	void delete(int departmentId); 
	
}
