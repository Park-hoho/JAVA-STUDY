package com.yedam.java.todolist;

import java.sql.Date;

public class Todo implements Comparable<Todo> {
	private int todoId;
	private int userNo;
	private String todo;
	private Date todoDeadline;
	private int todoImportance;
	private String todoCheck;
	private Date regDate;
	private	int updateCount;
	private Date updateDate;
	
	public int getTodoId() {
		return todoId;
	}
	public void setTodoId(int todoId) {
		this.todoId = todoId;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public Date getTodoDeadline() {
		return todoDeadline;
	}
	public void setTodoDeadline(Date todoDeadline) {
		this.todoDeadline = todoDeadline;
	}
	public int getTodoImportance() {
		return todoImportance;
	}
	public void setTodoImportance(int todoImportance) {
		this.todoImportance = todoImportance;
	}
	public String getTodoCheck() {
		return todoCheck;
	}
	public void setTodoCheck(String todoCheck) {
		this.todoCheck = todoCheck;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	@Override
	public String toString() {
		return "Todo [todoId=" + todoId + ", userNo=" + userNo + ", todo=" + todo + ", todoDeadline=" + todoDeadline
				+ ", todoImportance=" + todoImportance + ", todoCheck=" + todoCheck + ", regDate=" + regDate
				+ ", updateCount=" + updateCount + ", updateDate=" + updateDate + "]";
	}
	
	@Override
	public int compareTo(Todo todo) {
		if (this.todoDeadline.before(todo.getTodoDeadline())) {
            return -1;
        } else if (!this.todoDeadline.before(todo.getTodoDeadline())) {
            return 1;
        }
        return 0;
	}
}
