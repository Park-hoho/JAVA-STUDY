package com.yedam.java.app.customer;

import java.sql.SQLException;

import com.yedam.java.app.common.DAO;

public class CustomerDAOImpl extends DAO implements CustomerDAO {
	//싱글톤
	private static CustomerDAO instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	@Override
	public Customer selectOne(String email) {
		// 내정보 조회 -> 등급, 별 까지
		Customer customer = new Customer();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM customers WHERE customer_email = " + email;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				customer.setCustomerId(rs.getInt("manager_id"));
				customer.setCustomerName(rs.getString("manager_name"));
				customer.setCustomerPwd(rs.getString("manager_pwd"));
				customer.setCustomerId(rs.getInt("store_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return customer;
	}

	@Override
	public void showCardInfo(Customer customer) {
		// 카드정보조회
		try {
			connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void insert(Customer customer) {
		// 회원가입
		try {
			connect();
			String insert = "INSERT INTO managers VALUES "
					+ "(CUSTORMER_ID_SEQ.nextval,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, customer.getCustomerEmail());
			pstmt.setString(2, customer.getCustomerName());
			pstmt.setString(3, customer.getCustomerPwd());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updateName(String name) {
		// 이름 수정
		try {
			connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updateEmail(String email) {
		// 이메일 수정
		try {
			connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updatePwd(String password) {
		// 비밀번호 변경
		try {
			connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void delete(Customer customer) {
		// 계정삭제
		try {
			connect();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
