package com.yedam.java.withdrawallist;

import java.util.List;

import com.yedam.java.users.User;

public interface WithdrawalDAO {
	
	//전체조회
	List<Withdrawal> selectAll();
	List<Withdrawal> selectAllProgress();
	
	//단건조회
	Withdrawal selectOne(int withdrawalId);
	
	//입력
	boolean insert(User user, String reason);
	
	//수정
	void update(User user, Withdrawal wdl);
	
	//취소 처리
	boolean cancel(User user);
	
	//삭제
	void delete(int withdrawalId);
}
