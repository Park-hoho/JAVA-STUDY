package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExample {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String password = "hr";
		
		// JDBC 드라이버 로딩, DB 서버 접속
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, password);
		
		/*** INSERT ***/
		
		// Statement OR PreparedStatement 객체 생성
		String insert = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insert);
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "Kil-Dong");
		pstmt.setString(3, "Hong");
		pstmt.setString(4, "kdHong@google.com");
		pstmt.setString(5, "82.10.1234.1234");		
		pstmt.setString(6, "21/11/05");		
		pstmt.setString(7, "SA_REP");		
		pstmt.setInt(8, 6000);
		pstmt.setDouble(9, 0.15);
		pstmt.setInt(10, 149);
		pstmt.setInt(11, 80);
		
		// SQL문 실행
		int result = pstmt.executeUpdate();
		
		// 결과값 연산
		System.out.println("insert 결과: " + result);
		
		/*** UPDATE ***/
		
		// Statement OR PreparedStatement 객체 생성
		String update = "UPDATE employees SET last_name = ? WHERE employee_id = ?";
		pstmt = conn.prepareStatement(update);
		pstmt.setString(1, "Kang");
		pstmt.setInt(2, 1000);
		
		// SQL문 실행
		result = pstmt.executeUpdate();
		
		// 결과값 연산
		System.out.println("update 결과: " + result);
		
		/*** SELECT ***/
		
		// Statement OR PreparedStatement 객체 생성
		String select = "SELECT * FROM employees ORDER BY employee_id";
		Statement stmt = conn.createStatement();
		
		// SQL문 실행
		ResultSet rs = stmt.executeQuery(select);
		
		// 결과값 연산
		while(rs.next()) {
			String name = rs.getString("first_name")+" "+rs.getString("last_name");
			System.out.println("이름: " + name);
		}
		
		/*** DELETE ***/
		
		// Statement OR PreparedStatement 객체 생성
		String delete = "DELETE FROM employees WHERE employee_id = ?";
		pstmt = conn.prepareStatement(delete);
		pstmt.setInt(1, 1000);
		
		// SQL문 실행
		result = pstmt.executeUpdate();
		
		// 결과값 연산
		System.out.println("delete 결과: "+result);
		
		// 자원 해제
		if(rs != null) rs.close();
		if(pstmt != null) rs.close();
		if(stmt != null) rs.close();
		if(conn != null) rs.close();
		
	}
	
}