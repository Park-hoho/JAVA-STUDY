package com.yedam.java.app01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	//필드
	//Oracle 연결정보
	private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId = "hr";
	private String connectedPwd = "hr";
	
	//각 메서드에서 공통적으로 사용하는 필드
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//싱글톤
	private static EmpDAO empDAO = null;
	
	private EmpDAO() {}

	public static EmpDAO getInstance() {
		if (empDAO == null) {
			empDAO = new EmpDAO();
		}
		return empDAO;
	}

	//1. JDBC 드라이버 로딩
	//2. DB 서버 접속
	//=>DB와 연결
	public void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로딩에 실패");
		} catch (SQLException e) {
			System.out.println("DB 실패");
		}
		
	}

	//6. 자원 해제
	public void disconnect() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(SQLException e) {
			System.out.println("자원을 해제하는 데에 실패");
		}
		
	}
	
	
	//3. Statement or preparedStatement
	//4. SQL문
	//5. 결과값 연산
	//=>조회, 입력, 수정, 삭제 메서드
	
	//전체 조회
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();
		//list에 값을 담음
		try {
			connect();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM employees ORDER BY employee_id");
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				
				list.add(emp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//단건 조회
	
	//입력
	
	//수정
	
	//삭제
	
}
