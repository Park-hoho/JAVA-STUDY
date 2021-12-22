package com.yedam.java.todolist;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;
import com.yedam.java.users.User;

public class TodoListDAOImpl extends DAO implements TodoListDAO {
	//싱글톤
	private static TodoListDAO instance = new TodoListDAOImpl();
	private TodoListDAOImpl() {}
	public static TodoListDAO getInstance() {
		return instance;
	}

	@Override
	public List<Todo> selectAll() {
		List<Todo> list = new ArrayList<>();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM todo_list";
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoId(rs.getInt("todo_id"));
				todo.setUserNo(rs.getInt("user_no"));
				todo.setTodo(rs.getString("todo"));
				todo.setTodoDeadline(rs.getDate("todo_deadline"));
				todo.setTodoImportance(rs.getInt("todo_importance"));
				todo.setTodoCheck(rs.getString("todo_check"));
				todo.setRegDate(rs.getDate("reg_date"));
				todo.setUpdateCount(rs.getInt("update_count"));
				todo.setUpdateDate(rs.getDate("update_date"));
				list.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	@Override
	public List<Todo> selectUserTodoAll(User user) {
		List<Todo> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM todo_list WHERE user_no = ? ORDER BY 1";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, user.getUserNo());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoId(rs.getInt("todo_id"));
				todo.setUserNo(rs.getInt("user_no"));
				todo.setTodo(rs.getString("todo"));
				todo.setTodoDeadline(rs.getDate("todo_deadline"));
				todo.setTodoImportance(rs.getInt("todo_importance"));
				todo.setTodoCheck(rs.getString("todo_check"));
				todo.setRegDate(rs.getDate("reg_date"));
				todo.setUpdateCount(rs.getInt("update_count"));
				todo.setUpdateDate(rs.getDate("update_date"));
				list.add(todo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Todo selectOne(int todoId) {
		Todo todo = new Todo();
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT * FROM todo_list WHERE todo_id = " + todoId;
			rs = stmt.executeQuery(select);
			while(rs.next()) {
				todo.setTodoId(rs.getInt("todo_id"));
				todo.setUserNo(rs.getInt("user_no"));
				todo.setTodo(rs.getString("todo"));
				todo.setTodoDeadline(rs.getDate("todo_deadline"));
				todo.setTodoImportance(rs.getInt("todo_importance"));
				todo.setTodoCheck(rs.getString("todo_check"));
				todo.setRegDate(rs.getDate("reg_date"));
				todo.setUpdateCount(rs.getInt("update_count"));
				todo.setUpdateDate(rs.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return todo;
	}

	@Override
	public void insert(User user, String todo, String strDate, int importance) {
		//할 일 추가
		if (!validationDate(strDate)) {
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			return;
		}
		try {
			connect();
			String insert = "INSERT INTO todo_list "
			+ "VALUES (TODO_ID_SEQ.nextval,?,?,TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss'),?,'N',sysdate,0,null)";
			pstmt = conn.prepareStatement(insert);
			String date = strDate + " 23:59:59";
			pstmt.setInt(1, user.getUserNo());
			pstmt.setString(2, todo);
			pstmt.setString(3, date);
			pstmt.setInt(4, importance);
			int result = pstmt.executeUpdate();
			System.out.println(result + "건 입력완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	

	@Override
	public void delete(Todo todo) {
		try {
			connect();
			String delete = "DELETE FROM todo_list WHERE todo_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, todo.getTodoId());
			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void updateTodoCheck(Todo todo, boolean check) {
		// task 완료, 취소 체크
		try {
			connect();
			String update = "UPDATE todo_list SET todo_check = ? WHERE todo_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, check ? "Y" : "N");
			pstmt.setInt(2, todo.getTodoId());
			int result = pstmt.executeUpdate();
			System.out.println
			(result == 1 ? (check ? "완료처리 되었습니다." : "완료 취소하였습니다.") : "실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void updateTodoTask(Todo todo, String task) {
		// task 내용 수정
		try {
			connect();
			String update = "UPDATE todo_list SET todo = ? WHERE todo_id = ?";
			int todoId = todo.getTodoId();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, task);
			pstmt.setInt(2, todoId);
			int result = pstmt.executeUpdate();
			System.out.println(result == 1 ? "내용이 수정되었습니다." : "수정하지 못하였습니다.");
			
			update = "UPDATE todo_list SET update_date = sysdate WHERE todo_id = " + todoId;
			pstmt = conn.prepareStatement(update);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void updateTodoDeadline(Todo todo, String strDate) {
		// task 마감일자 수정
		try {
			connect();
			String update = "UPDATE todo_list SET todo_deadline = TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss') WHERE todo_id = ?";
			String date = strDate + " 23:59:59";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, date);
			pstmt.setInt(2, todo.getTodoId());
			int result = pstmt.executeUpdate();
			System.out.println(result == 1 ? "마감기한이 수정되었습니다." : "수정하지 못하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	@Override
	public void updateTodoImportance(Todo todo, int importance) {
		// task 중요도 수정
		try {
			connect();
			String update = "UPDATE todo_list SET todo_importance = ? WHERE todo_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, importance);
			pstmt.setInt(2, todo.getTodoId());
			int result = pstmt.executeUpdate();
			System.out.println(result == 1 ? "중요도가 수정되었습니다." : "수정하지 못하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public boolean validationDate(String checkDate){
		// 날짜 입력 양식 체크
		try {
			SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(false);
			dateFormat.parse(checkDate);
			return  true;
		} catch (ParseException  e){
			return  false;
		}
	}
	
	@Override
	public long countAll() {
		long count = 0;
		try {
			connect();
			stmt = conn.createStatement();
			String select = "SELECT COUNT(*) FROM todo_list";
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
	
}
