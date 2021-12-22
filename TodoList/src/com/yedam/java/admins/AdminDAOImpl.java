package com.yedam.java.admins;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class AdminDAOImpl extends DAO implements AdminDAO {
	//싱글톤
	private static AdminDAO instance = new AdminDAOImpl();
	private AdminDAOImpl() {}
	public static AdminDAO getInstance() {
		return instance;
	}
		
	@Override
	public List<Admin> selectAll() {
		List<Admin> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM admins";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Admin admin = new Admin();
				admin.setAdminNo(rs.getInt("admin_no"));
				admin.setAdminName(rs.getString("admin_name"));
				admin.setAdminId(rs.getString("admin_id"));
				admin.setAdminPwd(rs.getString("admin_pwd"));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Admin selectOne(int adminNo) {
		Admin admin = new Admin();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM admins WHERE admin_no = " + adminNo;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				admin.setAdminNo(rs.getInt("admin_no"));
				admin.setAdminName(rs.getString("admin_name"));
				admin.setAdminId(rs.getString("admin_id"));
				admin.setAdminPwd(rs.getString("admin_pwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}

	@Override
	public void insert(Admin admin) {
		try {
			connect();
			String insert = "INSERT INTO admins VALUES (ADMIN_NO_SEQ.nextval,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, admin.getAdminName());
			pstmt.setString(2, admin.getAdminId());
			pstmt.setString(3, admin.getAdminPwd());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("회원가입 완료하셨습니다");
			} else {
				System.out.println("회원가입에 실패하셨습니다.");
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("동일한 아이디가  존재합니다. 다시 시도하세요!");
		}  catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void updateName(Admin admin, String name) {
		// 이름 수정
		try {
			connect();
			String update = "UPDATE admins SET admin_name = ? WHERE admin_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, name);
			pstmt.setInt(2, admin.getAdminNo());
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
	public void updateId(Admin admin, String id) {
		// 아이디 수정
		try {
			connect();
			String update = "UPDATE admins SET admin_id = ? WHERE admin_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, id);
			pstmt.setInt(2, admin.getAdminNo());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(id + "으로 변경 완료되었습니다.");
			} else {
				System.out.println("아이디 변경 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void updatePwd(Admin admin, String password) {
		// 비밀번호 변경
		try {
			connect();
			String update = "UPDATE admins SET admin_pwd = ? WHERE admin_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, password);
			pstmt.setInt(2, admin.getAdminNo());
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
	public void delete(int adminNo) {
		try {
			connect();
			String delete = "DELETE FROM admins WHERE admin_no = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, adminNo);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public Admin checklogin(String id, String password) {
		// 로그인
		Admin admin = new Admin();
		try {
			connect();
			String select = "SELECT * FROM admins WHERE admin_id = ? AND admin_pwd = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.isBeforeFirst()) {
				while(rs.next()) {
					admin.setAdminNo(rs.getInt("admin_no"));
					admin.setAdminName(rs.getString("admin_name"));
					admin.setAdminId(rs.getString("admin_id"));
					admin.setAdminPwd(rs.getString("admin_pwd"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return admin;
	}

}
