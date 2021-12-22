package com.yedam.java.users;

import java.util.List;

public interface UserDAO {
	
	//전체조회
	List<User> selectAll();
	
	//단건조회
	User selectOneNo(int userNo);
	User selectOneId(String userId);
	
	//수정 (User, Admin)
	void updateName(User user, String name);
	void updatePwd(User user, String password);
	
	//삭제 (Admin)
	void delete(int userNo);
	
	//회원가입 (User)
	boolean insert(User user);
		
	//로그인 (User)
	User checklogin(String id, String password);
	
	//유저수 조회
	int countAll();
	
	//탈퇴 신청
	void applicationWithdrawal(User user, String reason);
	
	//탈퇴 취소 신청
	void cancelWithdrawal(User user);
	
}
