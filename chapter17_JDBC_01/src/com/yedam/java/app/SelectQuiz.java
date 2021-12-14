package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectQuiz {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String password = "hr";
		String sql = "SELECT e.last_name AS name\n"
				+ "FROM employees e JOIN departments d\n"
				+ "ON (e.department_id = d.department_id)\n"
				+ "WHERE d.department_name = 'IT'\n"
				+ "AND e.salary <= 10";
		
		//1, 2 드라이버 로딩, 서버 접속
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, password);
		//3 객체 생성
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//4 SQL 실행
		ResultSet rs = pstmt.executeQuery();
		//5
		if (rs.isBeforeFirst()) { 
			while(rs.next()) {
				String name = rs.getString("name"); //e.last_name -> 별칭 name
				System.out.println("이름: " + name);
			}
		} else {
			System.out.println("해당 조건에 만족하는 자료가 없다"); 
		}
		
		//6. 자원 해제
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
		
	}
}
