package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExample2 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		//JDBC 드라이버 로딩
		Class.forName(driver);
		//DB 서버 접속
		Connection conn = DriverManager.getConnection(url, id, pw);
		
	/*** INSERT	 ***/
		
		//Statement OR preparedStatement 객체 생성
		String insert = "INSERT INTO departments VALUES (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insert);
		pstmt.setInt(1, 1000);
		pstmt.setString(2, "Account");
		pstmt.setInt(3, 205);
		pstmt.setInt(4, 1700);
		
		//SQL문 실행
		int result = pstmt.executeUpdate();
		
		//결과값 연산
		System.out.println("insert 결과: " + result);
		
	/*** UPDATE ***/
		
		//Statement OR preparedStatement 객체 생성
		String update = "UPDATE departments SET location_id = ? WHERE department_id = ?";
		pstmt = conn.prepareStatement(update);
		pstmt.setInt(1, 1400);
		pstmt.setInt(2, 1000);
		
		//SQL문 실행
		result = pstmt.executeUpdate();
		
		//결과값 연산
		System.out.println("update 결과: " + result);
		
	/*** SELECT ***/
		
		//Statement OR preparedStatement 객체 생성
		String select = "SELECT * FROM departments ORDER BY 1";
		Statement stmt = conn.createStatement();
		
		//SQL문 실행
		ResultSet rs = stmt.executeQuery(select);
		
		//결과값 연산
		while(rs.next()) {
			String info = "부서 아이디: " + rs.getInt("deppartment_id")
					+ "부서이름: " + rs.getString("department_name")
					+ "매니저 아이디: " + rs.getInt("manager_id")
					+ "지역 아이디: " + rs.getInt("location_id");
			System.out.println(info);
		}
	/*** DELETE ***/
		
		//Statement OR preparedStatement 객체 생성
		String delete = "DELETE FROM departments WHERE department_id = ?";
		pstmt = conn.prepareStatement(delete);
		pstmt.setInt(1, 1000);
		
		//SQL문 실행
		result = pstmt.executeUpdate();
		
		//결과값 연산
		System.out.println(result);
		
		//자원 해제
		if(rs != null) rs.close();
		if(pstmt != null) rs.close();
		if(stmt != null) rs.close();
		if(conn != null) rs.close();
		
	}
	
}
