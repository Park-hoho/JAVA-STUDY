package com.yedam.java.app.customer;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.app.common.DAO;

public class CustomerDAOImpl extends DAO implements CustomerDAO {
	//싱글톤
	private static CustomerDAO instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	@Override
	public Customer checklogin(String email, String password) {
		Customer customer = new Customer();
		try {
			connect();
			String select = "SELECT * FROM customers WHERE customer_email = ? AND customer_pwd = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				customer.setCustomerId(rs.getInt(1));
				customer.setCustomerEmail(rs.getString(2));
				customer.setCustomerName(rs.getString(3));
				customer.setCustomerPwd(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return customer;
	}
	
	@Override
	public Customer selectOne(int customerId) {
		Customer customer = new Customer();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM customers WHERE customer_id = " + customerId;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setCustomerEmail(rs.getString("customer_email"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerPwd(rs.getString("customer_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return customer;
	}

	@Override
	public void showMyInfo(Customer customer) {
		// 로그인 되어있으니 가지고있는 값 받아서 내정보 조회 -> 등급, 별 까지
		try {
			connect();
			String select = "SELECT * FROM my_info WHERE customer_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, customer.getCustomerId());
			rs = pstmt.executeQuery();
			System.out.println("아이디: " + customer.getCustomerId());
			System.out.println("이름: " + customer.getCustomerName());
			System.out.println("이메일: " + customer.getCustomerEmail());
			System.out.println("패스워드: " + customer.getCustomerPwd());
			while(rs.next()) {
				System.out.println("멤버쉽: " + rs.getString("membership_level"));
				System.out.println("별: " + rs.getInt("starbucks_star"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void showCardInfo(Customer customer) {
		// 카드정보조회
		try {
			connect();
			String select = "SELECT * FROM card_information WHERE customer_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, customer.getCustomerId());
			rs = pstmt.executeQuery();
			System.out.println("=========보유 기프트 카드=========");
			while(rs.next()) {
				System.out.println("카드아이디: " + rs.getString("card_id") + " 충전된 금액: " + rs.getInt("charged_amount"));
			}
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
			String insert = "INSERT INTO customers VALUES "
					+ "(CUSTORMER_ID_SEQ.nextval,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, customer.getCustomerEmail());
			pstmt.setString(2, customer.getCustomerName());
			pstmt.setString(3, customer.getCustomerPwd());
			int result = pstmt.executeUpdate();
			System.out.println(result == 1 ? "회원가입 처리중..." : "회원가입에 실패");
			
			//고객정보 추가
			insert = "INSERT INTO my_info VALUES "
					+ "((SELECT customer_id FROM customers WHERE customer_email = ?), 'C', 0)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, customer.getCustomerEmail());
			result = pstmt.executeUpdate();
			
			System.out.println(result == 1 ? "회원가입 완료하셨습니다" : "회원가입에 실패하셨습니다.");
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("동일한 이메일이 존재합니다. 다시 시도하세요!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updateName(Customer customer, String name) {
		// 이름 수정
		try {
			connect();
			String update = "UPDATE customers SET customer_name = ? WHERE customer_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, name);
			pstmt.setInt(2, customer.getCustomerId());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(name + "으로 변경 완료되었습니다.");
			} else {
				System.out.println("이름 변경 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updateEmail(Customer customer, String email) {
		// 이메일 수정
		try {
			connect();
			String update = "UPDATE customers SET customer_email = ? WHERE customer_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, email);
			pstmt.setInt(2, customer.getCustomerId());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(email + "으로 변경 완료되었습니다.");
			} else {
				System.out.println("이메일 변경 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updatePwd(Customer customer, String password) {
		// 비밀번호 변경
		try {
			connect();
			String update = "UPDATE customers SET customer_pwd = ? WHERE customer_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, password);
			pstmt.setInt(2, customer.getCustomerId());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("비밀번호 변경 완료되었습니다.");
			} else {
				System.out.println("비밀번호 변경 실패");
			}
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
			String delete = "DELETE FROM customers WHERE customer_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, customer.getCustomerId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public List<Customer> selectAll() {
		List<Customer> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM emp13";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("custormer_id"));
				customer.setCustomerEmail(rs.getString("customer_email"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerPwd(rs.getString("customer_pwd"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
