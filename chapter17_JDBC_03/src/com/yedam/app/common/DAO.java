package com.yedam.app.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	//Oracle 연결정보
	protected String jdbc_driver = "oracle.jdbc.driver.OracleDriver";
	protected String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	protected String connectedId = "hr";
	protected String connectedPwd = "hr";
	
	//공통적으로 사용하는 필드
	protected Connection conn = null;
	protected Statement stmt = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	//싱글톤
	
	//연결 메소드 (JDBC 드라이버 로딩, DB 서버 접속)
	protected void connect() {
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, connectedId, connectedPwd);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	//해제 메소드 (역순으로 해제)
	protected void disconnect() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch(SQLException e) {
			System.out.println("자원을 해제하는 데에 실패");
		}
	}
	
}
