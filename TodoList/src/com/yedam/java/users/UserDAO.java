package com.yedam.java.users;

import java.util.List;

public interface UserDAO {
	
	//전체조회
	List<User> selectAll();
	
	//단건조회
	User selectOne(int userNo);
	
	//수정 (User, Admin)
	void updateName(User user, String name);
	void updatePwd(User user, String password);
	
	//삭제 (Admin)
	void delete(int userNo);
	
	//회원가입 (User)
	void insert(User user);
		
	//로그인 (User)
	User checklogin(String id, String password);
}
