package com.yedam.java.app03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	//Oracle 연결정보
	private String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String connectedId = "hr";
	private String connectedPwd = "hr";
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	//싱글톤
	private static EmpDAO instance = null;
	private EmpDAO() {}
	public static EmpDAO getInstance() {
		if (instance == null) {
			instance = new EmpDAO();
		}
		return instance;
	}
	
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
	
	//전체조회
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM emp13";
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
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
	
	//단건조회
	public Employee selectOne(int employeeId) {
		Employee emp = new Employee();
		
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM emp13 WHERE employee_id = " + employeeId;
			rs = stmt.executeQuery(select);
			
			while(rs.next()) {
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setDepartmentId(rs.getInt("department_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return emp;
	}

	//입력
	public void insert(Employee emp) {
		try {
			connect();
			String insert = "INSERT INTO emp13 VALUES(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, emp.getEmployeeId());
			pstmt.setString(2, emp.getLastName());
			pstmt.setString(3, emp.getJobId());
			pstmt.setDouble(4, emp.getSalary());
			pstmt.setDouble(5, emp.getCommissionPct());
			pstmt.setInt(6, emp.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 등록되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//수정
	public void update(Employee emp) {
		try {
			connect();
			//PreparedStatement 객체 생성
			String update = "UPDATE emp13 SET salary = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setDouble(1, emp.getSalary());
			pstmt.setInt(2, emp.getEmployeeId());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	//삭제
	public void delete(int employeeId) { 
		try {
			connect();
			String delete = "DELETE FROM emp13 WHERE employee_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, employeeId);
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch ( SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
}
