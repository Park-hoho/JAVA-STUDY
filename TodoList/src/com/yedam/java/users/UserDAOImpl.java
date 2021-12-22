package com.yedam.java.users;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;
import com.yedam.java.withdrawallist.WithdrawalDAOImpl;

public class UserDAOImpl extends DAO implements UserDAO {
	//싱글톤
	private static UserDAO instance = new UserDAOImpl();
	private UserDAOImpl() {}
	public static UserDAO getInstance() {
		return instance;
	}

	@Override
	public List<User> selectAll() {
		List<User> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM users";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				User user = new User();
				user.setUserNo(rs.getInt("user_no"));
				user.setUserName(rs.getString("user_name"));
				user.setUserId(rs.getString("user_id"));
				user.setUserPwd(rs.getString("user_pwd"));
				user.setJoinDate(rs.getDate("join_date"));
				user.setLastAccessDate(rs.getDate("last_access_date"));
				user.setWithdrawalStatus(rs.getString("withdrawal_status"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public User selectOneNo(int userNo) {
		User user = new User();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM users WHERE user_no = " + userNo;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				user.setUserNo(rs.getInt("user_no"));
				user.setUserName(rs.getString("user_name"));
				user.setUserId(rs.getString("user_id"));
				user.setUserPwd(rs.getString("user_pwd"));
				user.setJoinDate(rs.getDate("join_date"));
				user.setLastAccessDate(rs.getDate("last_access_date"));
				user.setWithdrawalStatus(rs.getString("withdrawal_status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
 		return user;
	}

	@Override
	public void updateName(User user, String name) {
		// 이름 수정
		try {
			connect();
			String update = "UPDATE users SET user_name = ? WHERE user_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, name);
			pstmt.setInt(2, user.getUserNo());
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
	public void updatePwd(User user, String password) {
		// 비밀번호 변경
		try {
			connect();
			String update = "UPDATE users SET user_pwd = ? WHERE user_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, password);
			pstmt.setInt(2, user.getUserNo());
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
	public void delete(int userNo) {
		// TODO 탈퇴 처리 탈퇴신청리스트에도 추가
		try {
			connect();
			String delete = "DELETE FROM users WHERE user_no = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, userNo);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(result + "건이 삭제되었습니다.");
			} else {
				System.out.println("계정 삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public boolean insert(User user) {
		// 회원가입
		try {
			connect();
			String insert = "INSERT INTO users VALUES "
					+ "(USER_NO_SEQ.nextval, ?, ?, ?, sysdate, null, 'N')";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserPwd());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("회원가입 완료하셨습니다");
				return true;
			} else {
				System.out.println("회원가입에 실패하셨습니다.");
				return false;
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("동일한 아이디가  존재합니다. 다시 시도하세요!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	@Override
	public User checklogin(String id, String password) {
		// 로그인
		User user = null;
		try {
			connect();
			String select = "SELECT * FROM users WHERE user_id = ? AND user_pwd = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.isBeforeFirst()) {
				user = new User();
				while(rs.next()) {
					user.setUserNo(rs.getInt("user_no"));
					user.setUserName(rs.getString("user_name"));
					user.setUserId(rs.getString("user_id"));
					user.setUserPwd(rs.getString("user_pwd"));
					user.setJoinDate(rs.getDate("join_date"));
					user.setLastAccessDate(rs.getDate("last_access_date"));
					user.setWithdrawalStatus(rs.getString("withdrawal_status"));
				}
				String update = "UPDATE users SET last_access_date = sysdate WHERE user_no = ?";
				pstmt = conn.prepareStatement(update);
				pstmt.setInt(1, user.getUserNo());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}
	
	@Override
	public int countAll() {
		int count = 0;
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT COUNT(*) FROM users WHERE withdrawal_status <> 'Y'";
			rs = stmt.executeQuery(select);
			while(rs.next()) { 
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return count;
	}
	
	@Override
	public User selectOneId(String userId) {
		User user = null;
		try {
			connect();
			String select = "SELECT * FROM users WHERE user_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while(rs.next()) {
					user = new User();
					user.setUserNo(rs.getInt("user_no"));
					user.setUserName(rs.getString("user_name"));
					user.setUserId(rs.getString("user_id"));
					user.setUserPwd(rs.getString("user_pwd"));
					user.setJoinDate(rs.getDate("join_date"));
					user.setLastAccessDate(rs.getDate("last_access_date"));
					user.setWithdrawalStatus(rs.getString("withdrawal_status"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
 		return user;
	}
	
	@Override
	public void applicationWithdrawal(User user, String reason) {
		//  TODO
		WithdrawalDAOImpl.getInstance().insert(user, reason);
	}
	
	@Override
	public void cancelWithdrawal(User user) {
		// TODO
		try {
			connect();
			String update = "UPDATE users SET withdrawal_status = 'N' WHERE user_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, user.getUserNo());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
