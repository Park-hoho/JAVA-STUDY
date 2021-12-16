package com.yedam.app.emp13;

import java.util.List;


public interface NewEmpDAO {

	//전체조회
	List<NewEmployee> selectAll();
	
	//단건조회
	NewEmployee selectOne(int employeeId);
	
	//입력
	void insert(NewEmployee emp);
	
	//수정
	void update(NewEmployee emp);
	
	//삭제
	void delete(int employeeId);
}
