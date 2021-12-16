package com.yedam.java.app.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

public class ManagerDAOImpl extends DAO implements ManagerDAO {
	//싱글톤
	private static ManagerDAO instance = new ManagerDAOImpl();
	private ManagerDAOImpl() {}
	public static ManagerDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Manager> selectAll() {
		List<Manager> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM managers";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Manager manager = new Manager();
				manager.setManagerId(rs.getInt("manager_id"));
				manager.setManagerName(rs.getString("manager_name"));
				manager.setManagerPwd(rs.getString("manager_pwd"));
				manager.setStoreId(rs.getInt("store_id"));
				list.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Manager selectOne(int managerId) {
		Manager manager = new Manager();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM managers WHERE manager_id = " + managerId;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				manager.setManagerId(rs.getInt("manager_id"));
				manager.setManagerName(rs.getString("manager_name"));
				manager.setManagerPwd(rs.getString("manager_pwd"));
				manager.setStoreId(rs.getInt("store_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return manager;
	}

	@Override
	public void insert(Manager manager) {
		try {
			connect();
			String insert = "INSERT INTO managers VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, manager.getManagerId());
			pstmt.setString(2, manager.getManagerName());
			pstmt.setString(3, manager.getManagerPwd());
			pstmt.setInt(4, manager.getStoreId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void update(Manager manager) {
		try {
			connect();
			String update = "UPDATE managers SET store_id = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, manager.getStoreId());
			pstmt.setInt(2, manager.getManagerId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다.(매니저)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void delete(int managerId) {
		try {
			connect();
			String delete = "DELETE FROM managers WHERE manager_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, managerId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.(매니저)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
