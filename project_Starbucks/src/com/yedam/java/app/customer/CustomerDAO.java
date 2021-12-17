package com.yedam.java.app.customer;

import java.util.List;

public interface CustomerDAO {

	//로그인
	Customer checklogin(String email, String password);
	
	//모든 유저 조회
	List<Customer> selectAll();
	
	//단건 조회
	Customer selectOne(int customerId);
	
	//내정보 조회
	void showMyInfo(Customer customer);
	
	//카드정보 조회
	void showCardInfo(Customer customer);
	
	//입력
	void insert(Customer customer);
	
	//수정
	void updateName(Customer customer, String name);
	void updateEmail(Customer customer, String email);
	void updatePwd(Customer customer, String password);
	
	//삭제
	void delete(Customer customer);

}
