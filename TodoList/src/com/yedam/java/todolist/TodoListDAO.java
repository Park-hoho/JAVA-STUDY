package com.yedam.java.todolist;

import java.util.List;

import com.yedam.java.users.User;

public interface TodoListDAO {
	
	//전체조회 (Ad)
	List<Todo> selectAll();
	
	//유저 Todo list 조회 (User)
	List<Todo> selectUserTodoAll(User user);
	
	//단건조회 (User)
	Todo selectOne(int todoId);
	
	//입력 (User)
	void insert(User user, String todo, String strDate, int importance);
	
	//수정 (User)
	void updateTodoCheck(Todo todo, boolean check);
	void updateTodoTask(Todo todo, String task);
	void updateTodoDeadline(Todo todo, String strDate);
	void updateTodoImportance(Todo todo, int importance);
	
	//삭제 (User)
	void delete(Todo todo);
	
	//총 todo 수
	long countAll();
	
}
