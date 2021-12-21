package com.yedam.java.withdrawallist;

import java.util.List;

import com.yedam.java.users.User;

public interface WithdrawalDAO {
	
	//전체조회
	List<Withdrawal> selectAll();
	
	//단건조회
	Withdrawal selectOne(int withdrawalId);
	
	//입력
	void insert(User user, Withdrawal wdl);
	
	//수정
	void update(Withdrawal wdl);
	
	//삭제
	void delete(int withdrawalId);
}
