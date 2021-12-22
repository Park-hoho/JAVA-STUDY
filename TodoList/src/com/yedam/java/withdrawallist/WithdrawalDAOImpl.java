package com.yedam.java.withdrawallist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;
import com.yedam.java.users.User;

public class WithdrawalDAOImpl extends DAO implements WithdrawalDAO {
	//싱글톤
	private static WithdrawalDAO instance = new WithdrawalDAOImpl();
	private WithdrawalDAOImpl() {}
	public static WithdrawalDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Withdrawal> selectAll() {
		List<Withdrawal> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM withdrawal_list";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Withdrawal wdl = new Withdrawal();
				wdl.setWithdrawalId(rs.getInt("withdrawal_id"));
				wdl.setUserNo(rs.getInt("user_no"));
				wdl.setWithdrawalStatus(rs.getString("withdrawal_status"));
				wdl.setApplicationDate(rs.getDate("application_date"));
				wdl.setCompleteDate(rs.getDate("complete_date"));
				wdl.setWithdrawalReason(rs.getString("withdrawal_reason"));
				wdl.setCancelDate(rs.getDate("cancel_date"));
				list.add(wdl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	@Override
	public List<Withdrawal> selectAllProgress() {
		List<Withdrawal> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT w.withdrawal_id, w.user_no, w.application_date, w.withdrawal_reason, w.complete_date, u.user_name, u.user_id, u.join_date\n"
					+ "FROM withdrawal_list w JOIN users u\n"
					+ "ON (w.user_no = u.user_no)\n"
					+ "WHERE w.withdrawal_status = 'Y'";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Withdrawal wdl = new Withdrawal();
				User user = new User();
				wdl.setWithdrawalId(rs.getInt("withdrawal_id"));
				wdl.setUserNo(rs.getInt("user_no"));
				wdl.setApplicationDate(rs.getDate("application_date"));
				wdl.setWithdrawalReason(rs.getString("withdrawal_reason"));
				wdl.setCompleteDate(rs.getDate("complete_date"));
				user.setUserName(rs.getString("user_name"));
				user.setUserId(rs.getString("user_id"));
				user.setJoinDate(rs.getDate("join_date"));
				wdl.setUser(user);
				list.add(wdl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Withdrawal selectOne(int withdrawalId) {
		Withdrawal wdl = new Withdrawal();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM withdrawal_list WHERE withdrawal_id = " + withdrawalId;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				wdl.setWithdrawalId(rs.getInt("withdrawal_id"));
				wdl.setUserNo(rs.getInt("user_no"));
				wdl.setWithdrawalStatus(rs.getString("withdrawal_status"));
				wdl.setApplicationDate(rs.getDate("application_date"));
				wdl.setCompleteDate(rs.getDate("complete_date"));
				wdl.setWithdrawalReason(rs.getString("withdrawal_reason"));
				wdl.setCancelDate(rs.getDate("cancel_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return wdl;
	}

	@Override
	public boolean insert(User user, String reason) {
		try {
			connect();
			String insert = "INSERT INTO withdrawal_list "
					+ "VALUES (WIDL_ID_SEQ.nextval,?,'Y',sysdate,null,?,null)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, user.getUserNo());
			pstmt.setString(2, reason);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				System.out.println("탈퇴신청 문제");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}		
		return false;
	}

	@Override
	public void update(User user, Withdrawal wdl) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void delete(int withdrawalId) {
		// 탈퇴 신청서 삭제
		try {
			connect();
			String delete = "DELETE FROM withdrawal_list WHERE withdrawal_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, withdrawalId);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public boolean cancel(User user) {
		try {
			connect();
			String update = "UPDATE withdrawal_list "
					+ "SET withdrawal_status = 'N', cancel_date = sysdate "
					+ "WHERE user_no = ? AND cancel_date IS NULL";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, user.getUserNo());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				System.out.println("취소신청 문제");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("취소신청 문제");
		} finally {
			disconnect();
		}
		return false;
	}

}
