package com.yedam.java.store;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

public class StoreDAOImpl extends DAO implements StoreDAO {
	//싱글톤
	private static StoreDAO instance = new StoreDAOImpl();
	private StoreDAOImpl() {}
	public static StoreDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Store> selectAll() {
		List<Store> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM stores";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Store store = new Store();
				store.setStoreid(rs.getInt("store_id"));;
				store.setStoreName(rs.getString("store_name"));;
				store.setStoreLocation(rs.getString("store_loaction"));;
				list.add(store);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Store selectOne(String storeName) {
		Store store = new Store();
		try {
			connect();
			String select = "SELECT * FROM stores WHERE store_name = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, storeName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				store.setStoreid(rs.getInt("store_id"));
				store.setStoreName(rs.getString("store_name"));
				store.setStoreLocation(rs.getString("store_loaction"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return store;
	}

	@Override
	public void insert(Store store) {
		try {
			connect();
			String insert = "INSERT INTO stores VALUES (?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, store.getStoreid());
			pstmt.setString(2, store.getStoreName());
			pstmt.setString(3, store.getStoreLocation());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updateName(int storeId, String name) {
		try {
			connect();
			String update = "UPDATE stores SET store_name = ? WHERE store_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, name);
			pstmt.setInt(2, storeId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(storeId +"호점의 이름이 " + name + "으로 변경되었습니다.");
			} else {
				System.out.println("매장 이름 변경 오류");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void delete(int storeId) {
		try {
			connect();
			String delete = "DELETE FROM stores WHERE store_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, storeId);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(storeId +"호점이 삭제되었습다.");
			} else {
				System.out.println("매장 삭제 오류");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}


}
