package com.yedam.java.menu;

import java.util.List;

import com.yedam.java.store.Store;

public interface MenuDAO {
	
	//전체조회(M)
	List<Menu> selectAll();
	
	//단건조회(M)
	Menu selectOne(int menuId);
	
	//입력(M)
	void insert(Menu menu);
	
	//수정(M)
	void updatePrice(int id, int price);
	
	//삭제(M)
	void delete(int menuId);
	
	//선택된 매장의 메뉴 조회(C)
	void showStoreMenus(Store store);
}
