package com.yedam.java.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;
import com.yedam.java.store.Store;

public class MenuDAOImpl extends DAO implements MenuDAO {
	//싱글톤
	private static MenuDAO instance = new MenuDAOImpl();
	private MenuDAOImpl() {}
	public static MenuDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Menu> selectAll() {
		List<Menu> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM menus";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Menu menu = new Menu();
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenuType(rs.getString("menu_type"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getInt("menu_price"));
				menu.setStoreId(rs.getInt("store_id"));
				list.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Menu selectOne(int menuId) {
		Menu menu = new Menu();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM menus WHERE menu_id = " + menuId;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				menu.setMenuId(rs.getInt("menu_id"));
				menu.setMenuType(rs.getString("menu_type"));
				menu.setMenuName(rs.getString("menu_name"));
				menu.setMenuPrice(rs.getInt("menu_price"));
				menu.setStoreId(rs.getInt("store_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
 		return menu;
	}

	@Override
	public void insert(Menu menu) {
		try {
			connect();
			String insert = "INSERT INTO menus VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, menu.getMenuId());
			pstmt.setString(2, menu.getMenuType());
			pstmt.setString(3, menu.getMenuName());
			pstmt.setInt(4, menu.getMenuPrice());
			pstmt.setInt(5, menu.getStoreId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void updatePrice(int id, int price) {
		try {
			connect();
			String update = "UPDATE menus SET menu_price = ? WHERE menu_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setDouble(1, id);
			pstmt.setInt(2, price);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void delete(int menuId) {
		try {
			connect();
			String delete = "DELETE FROM menus WHERE menu_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, menuId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void showStoreMenus(Store store) {
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM menus WHERE store_id = " + store.getStoreid();
			rs = stmt.executeQuery(select);
			String prev = null;
			String type = null;
			while(rs.next()) {
				type = rs.getString("menu_type");
				if (type.equals(prev)) {
					System.out.println(rs.getInt("menu_id")+"/ "+rs.getString("menu_name") + ", 가격: " + rs.getInt("menu_price"));
				} else {
					prev = rs.getString("menu_type");
					System.out.println("======" + type);
					System.out.println(rs.getInt("menu_id")+"/ "+rs.getString("menu_name") + ", 가격: " + rs.getInt("menu_price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
