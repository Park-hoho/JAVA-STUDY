package com.yedam.java.app.customer;

public interface CustomerDAO {

	//내정보 조회
	Customer selectOne(String email);
	
	//카드정보 조회
	void showCardInfo(Customer customer);
	
	//입력
	void insert(Customer customer);
	
	//수정
	void updateName(String name);
	void updateEmail(String email);
	void updatePwd(String password);
	
	//삭제
	void delete(Customer customer);
}
