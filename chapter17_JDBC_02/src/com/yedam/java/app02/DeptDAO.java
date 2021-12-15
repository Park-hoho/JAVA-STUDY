package com.yedam.java.app02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
	//필드 - 오라클DB정보
	private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId = "hr";
	private String connectedPwd = "hr";
	
	//필드 - 각 메서드에서 공통적으로 사용하는 변수
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//싱글톤
	private static DeptDAO instance = null;
	
	private DeptDAO() {}
	
	public static DeptDAO getInstance() {
		if (instance == null) {
			instance = new DeptDAO();
		}
		return instance;
	}
	
	//JDBC 드라이버, DB 서버 접속
	private void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}
	
	//자원해제
	private void disconnect() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(SQLException e) {
			System.out.println("자원을 해제하는 데에 실패");
		}
	}
	
	//객체 생성
	//SQL문
	//결과 연산
	//-> 전체조회, 단건조회, 입력, 수정, 삭제 메서드
	
	//전체조회
	public List<Dept> selectAll() {
		List<Dept> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM dept_test_vu";
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLastName(rs.getString("last_name"));
				dept.setCity(rs.getString("city"));
				
				list.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//자원해제
			disconnect();
		}	
		return list;
	}
	//단건조회
	public Dept selectOne(int deptId) {
		Dept dept = new Dept();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM dept_test_vu WHERE department_id = " + deptId;
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setLastName(rs.getString("last_name"));
				dept.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return dept;
	}
	
	//입력
	public void insert(Dept dept) {
		try {
			connect();
			
			String insert = "INSERT INTO departments \n"
					+ "VALUES(?, \n"
					+ "       ?, \n"
					+ "       (SELECT employee_id FROM employees WHERE last_name = ?), \n"
					+ "       (SELECT location_id FROM locations WHERE city = ?))";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setString(3, dept.getLastName());
			pstmt.setString(4, dept.getCity());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 등록되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//수정
	public void update(Dept dept) {
		try {
			connect();
			String update = "UPDATE departments\n"
					+ "SET manager_id = (SELECT employee_id FROM employees WHERE last_name = ?)\r\n"
					+ "WHERE department_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, dept.getLastName());
			pstmt.setInt(2, dept.getDepartmentId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//삭제
	public void delete(int deptId) {
		try {
			connect();
			String delete = "DELETE FROM departments WHERE department_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, deptId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
}
