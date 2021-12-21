package com.yedam.java.admins;

import java.util.List;

public interface AdminDAO {
	//전체조회
	List<Admin> selectAll();
	
	//단건조회
	Admin selectOne(int adminNo);
	
	//입력
	void insert(Admin admin);
	
	//수정
	void updateName(Admin admin, String name);
	
	//삭제
	void delete(int adminNo);
			
	//로그인
	Admin checklogin(String id, String password);
}
