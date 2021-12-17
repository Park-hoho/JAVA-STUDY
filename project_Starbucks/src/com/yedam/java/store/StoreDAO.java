package com.yedam.java.store;

import java.util.List;

public interface StoreDAO {
	
	//전체조회
	List<Store> selectAll();
	
	//단건조회
	Store selectOne(String storeName);
	
	//입력
	void insert(Store store);
	
	//수정
	void updateName(int storeId, String name);
	
	//삭제
	void delete(int storeId);
}
