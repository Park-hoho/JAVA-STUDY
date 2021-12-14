package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. JDBC 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. DB 서버 접속
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String password = "hr";
		
		Connection conn = DriverManager.getConnection(url, id, password);
		
		//3. Statement or PreparedStatement 객체 생성
		String sql = "SELECT * FROM employees WHERE salary BETWEEN 2000 AND 10000";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//4. SQL 실행
		ResultSet rs = pstmt.executeQuery();
		
		//5. 결과값 연산
		while(rs.next()) {
			String name = rs.getString("first_name");
			int income = (int)(rs.getInt("salary") * 1.1);
			System.out.println("이름: " + name + ", 10% 인상 연봉: " + income);
		}
		
		//6. 자원 해제
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		if (conn != null) conn.close();
	}

}
