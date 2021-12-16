package com.yedam.java.app.manager;

import java.util.List;

public interface ManagerDAO {

	//전체조회
	List<Manager> selectAll();
	
	//단건조회
	Manager selectOne(int managerId);
	
	//입력
	void insert(Manager manager);
	
	//수정
	void update(Manager manager);
	
	//삭제
	void delete(int managerId);
}
