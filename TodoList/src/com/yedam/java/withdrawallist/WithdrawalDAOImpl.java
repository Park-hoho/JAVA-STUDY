package com.yedam.java.withdrawallist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;
import com.yedam.java.users.User;

public class WithdrawalDAOImpl extends DAO implements WithdrawalDAO {

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
	public void insert(User user, Withdrawal wdl) {
		// TODO 탈퇴신청 추가
		try {
			connect();
			String insert = "INSERT INTO withdrawal_list VALUES (WIDL_ID_SEQ.nextval,?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			
			pstmt.setInt(1, user.getUserNo());
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}		
	}

	@Override
	public void update(Withdrawal wdl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int withdrawalId) {
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

}
