package com.yedam.app.dept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;

public class DeptDAOImpl extends DAO implements DeptDAO {
	//싱글톤
	private static DeptDAO instance = new DeptDAOImpl();
	private DeptDAOImpl() {}
	public static DeptDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Dept> selectAll() {
		List<Dept> list = new ArrayList<>();
		try {
			connect();
			
			stmt = conn.createStatement();
			
			String select = "SELECT * FROM departments ORDER BY department_id";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Dept selectOne(int departmentId) {
		Dept dept = null;
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM departments WHERE department_id = " + departmentId;
			rs = stmt.executeQuery(select);
		
			while(rs.next()) {
				dept = new Dept();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getInt("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return dept;
	}

	@Override
	public void insert(Dept dept) {
		try {
			connect();
			String insert = "INSERT INTO departments VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setInt(3, dept.getManagerId());
			pstmt.setInt(4, dept.getLocationId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void update(Dept dept) {
		try {
			connect();
			String update = "UPDATE departments SET department_name = ? WHERE department_id = ?";
			pstmt = conn.prepareStatement(update);
			
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2, dept.getDepartmentId());
			int result = pstmt.executeUpdate();

			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void delete(int departmentId) {
		try {
			connect();
			
			String delete = "DELETE FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, departmentId);
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
