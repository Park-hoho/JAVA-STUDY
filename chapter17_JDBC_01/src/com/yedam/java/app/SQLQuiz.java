package com.yedam.java.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLQuiz {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "hr";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, id, pw);
		
		//INSERT
		String insert = "INSERT INTO emp13 VALUES (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(insert);
		pstmt.setInt(1, 304);
		pstmt.setString(2, "Tiger");
		pstmt.setString(3, "AD_VP");
		pstmt.setInt(4, 24000);
		pstmt.setDouble(5, 0.2);
		pstmt.setInt(6, 200);
		int result = pstmt.executeUpdate();
		System.out.println("insert:"+result);
		
		//UPDATE
		String update = "UPDATE emp13 SET salary = ? WHERE employee_id = ?";
		pstmt = conn.prepareStatement(update);
		pstmt.setInt(1, 4630);
		pstmt.setInt(2, 304);
		result = pstmt.executeUpdate();
		System.out.println("update:"+result);
		
		//SELECT
		String select = "SELECT * FROM emp13 WHERE salary > 10";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(select);
		while(rs.next()) {
			String info = "번호: "+rs.getInt("employee_id")
			+ "이름: "+rs.getString("last_name")
			+ "업무: "+rs.getString("job_id");
			System.out.println(info);
		}
		
		//DELETE
		String delete = "DELETE FROM emp13 WHERE employee_id = ?";
		pstmt = conn.prepareStatement(delete);
		pstmt.setInt(1, 304);
		result = pstmt.executeUpdate();
		System.out.println("delete:"+result);
		
		//자원 해제
		if(rs != null) rs.close();
		if(pstmt != null) rs.close();
		if(stmt != null) rs.close();
		if(conn != null) rs.close();
	}

}
