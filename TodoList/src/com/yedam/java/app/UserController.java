package com.yedam.java.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.yedam.java.todolist.Todo;
import com.yedam.java.todolist.TodoListDAOImpl;
import com.yedam.java.users.User;

public class UserController {
	Scanner sc = new Scanner(System.in);
	User user;
	String userName;
	public static String USER_GRADE;
	public static List<Todo> TODO_LIST = new ArrayList<>();
	public static List<Todo> COMPLETED_LIST = new ArrayList<>();
	public static int COMPLETED_COUNT;
	SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd E요일");
	
	protected UserController() {
		this.user = UserFrame.USER_INFO;
		userName = this.user.getUserName();
		getUserTodoList();
		COMPLETED_COUNT = COMPLETED_LIST.size();
		USER_GRADE = getUserGrade();
		run();
	}

	private void run() {
		while(true) {
			
			showUserInterface();
			
			String str = sc.nextLine();
			String[] strArr = str.split(",");
			if (str.length() == 1 && Pattern.matches("^[0-9]*$", strArr[0])) {
				
				int selected = Integer.parseInt(strArr[0]);
				if (selected == 1) {
					
					// 할 일 추가 
					inputTodo();
					
				} else if (selected == 2) {
					
					//완료된 목록 보기
					showCompletedList();
					
				} else if (selected == 3) {
					
					// TODO 리스트 정렬
					sortTodoList();
					refreshList();
					
				} else if (selected == 9) {
					
					// 내정보 관리
					new MyInfoController();
					
				} else if (selected == 0) {
					System.out.println("프로그램 종료");
					System.exit(0);
				} else { System.out.println("잘못된 입력입니다."); }
			} else if (strArr.length == 2) {
				
				int selected = Integer.parseInt(strArr[0]);
				Todo todo = TODO_LIST.get(selected - 1);
				if (strArr[1].equals("완료")) {
					
					// 할 일 완료처리
					TodoListDAOImpl.getInstance().updateTodoCheck(todo, true);
					refreshList();
					
				} else if (strArr[1].equals("수정")) {
					
					// 할 일 수정
					modifyTodo(todo);
					refreshList();
					
				} else if (strArr[1].equals("삭제")) {
					
					// 할 일 삭제
					TodoListDAOImpl.getInstance().delete(todo.getTodoId());
					refreshList();
					
				} else { System.out.println("잘못된 입력입니다."); }
			} else { System.out.println("잘못된 입력입니다."); }
		}
	}
	
	private void showUserInterface() {
		java.util.Date time = new java.util.Date();
		String today = format.format(time);
		System.out.println("\n===================================================");
		System.out.printf("%s님 환영합니다.  |  완료된 할 일: %d |  등급: %s\n",
				userName, COMPLETED_COUNT, USER_GRADE);
		System.out.println("today: " + today);
		System.out.println("\n할 일 목록 "+TODO_LIST.size()+"개");
		showList(TODO_LIST);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("1.할 일 추가  2.완료 목록 보기  3.정렬  9.내정보 관리  0.종료");
		System.out.println("※할 일 체크(번호,명령어) ex)2,완료 1,수정 4,삭제");
		System.out.println();
		System.out.print("메뉴입력>>");
	}

	private void sortTodoList() {
		// TODO 정렬
		System.out.println("1.마감순  2.등록순  3.중요도순  9.취소");
		int selectSortOption = Integer.parseInt(sc.nextLine());
		if (selectSortOption == 1) {
			
		} else if (selectSortOption == 2) {
			
		}
	}

	private void modifyTodo(Todo todo) {
		while(true) {
			System.out.println("1.내용 수정  2.마감기한 수정  3.중요도 수정  9.뒤로가기");
			System.out.print("선택>>");
			int selectOption = Integer.parseInt(sc.nextLine());
			if (selectOption == 1) {
				
				System.out.print("내용>>");
				String task = sc.nextLine();
				TodoListDAOImpl.getInstance().updateTodoTask(todo, task);
				
			} else if (selectOption == 2) {
				
				System.out.print("마감기한(yyyy-mm-dd)>>");
				String strDate = sc.nextLine();
				TodoListDAOImpl.getInstance().updateTodoDeadline(todo, strDate);
				
			} else if (selectOption == 3) {
				
				System.out.print("중요:1, 보통:0>>");
				int importance = Integer.parseInt(sc.nextLine());
				TodoListDAOImpl.getInstance().updateTodoImportance(todo, importance);
				
			} else if (selectOption == 9) {
				break;
			} else { System.out.println("잘못된 입력입니다."); }
		}
	}

	private void inputTodo() {
		System.out.println("할 일 추가");
		System.out.print("내용>>");
		String todo = sc.nextLine();
		System.out.print("마감기한(yyyy-mm-dd)>>");
		String strDate = sc.nextLine();
		System.out.print("중요:1, 보통:0>>");
		int importance = Integer.parseInt(sc.nextLine());
		TodoListDAOImpl.getInstance().insert(user, todo, strDate, importance);
		refreshList();		
	}

	private void showCompletedList() {
		while(true) {
			System.out.println();
			System.out.println("===================================================");
			System.out.println("완료 된 목록 "+COMPLETED_LIST.size()+"개");
			showList(COMPLETED_LIST);
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			System.out.println("1.완료취소  3.삭제  9.뒤로가기");
			System.out.println();
			System.out.print("메뉴입력>>");
			int selected = sc.nextInt();
			if (selected == 1) {
				System.out.print("번호입력>>");
				int todoId = sc.nextInt();
				Todo todo = COMPLETED_LIST.get(todoId - 1);
				TodoListDAOImpl.getInstance().updateTodoCheck(todo, false);
				refreshList();
			} else if (selected == 2) {
				System.out.print("번호입력>>");
				int todoId = sc.nextInt();
				todoId = COMPLETED_LIST.get(todoId - 1).getTodoId();
				TodoListDAOImpl.getInstance().delete(todoId);
				refreshList();
			} else if (selected == 3) {
				
			} else if (selected == 9) {
				break;
			} else { System.out.println("잘못된 입력입니다."); }
		}
	}

	private void getUserTodoList() {
		COMPLETED_LIST.clear();
		TODO_LIST.clear();
		List<Todo> list = TodoListDAOImpl.getInstance().selectUserTodoAll(user);
		for (Todo todo : list) {
			if (todo.getTodoCheck().equals("Y")) {
				COMPLETED_LIST.add(todo);
			} else {
				TODO_LIST.add(todo);
			}
		}
	}
	
	private String getUserGrade() {
		// 유저 등급
		String grade = "";
		if (COMPLETED_COUNT < 10) { grade = "브론즈"; }
		else if (COMPLETED_COUNT < 30) { grade = "실버"; }
		else if (COMPLETED_COUNT < 100) { grade = "골드"; }
		else if (COMPLETED_COUNT < 300) { grade = "플레티넘";}
		else if (COMPLETED_COUNT < 700) { grade = "다이아몬드"; }
		return grade;
	}
	
	private void showList(List<Todo> list) {
		int index = 1;
		for (Todo todo : list) {
			System.out.print(index++ +". ");
			System.out.print(todo.getTodoImportance() == 1 ? "★ " : "");
			System.out.print(todo.getTodo() + " / ");
			System.out.print(todo.getTodoDeadline());
			System.out.print(todo.getTodoCheck().equals("Y") ?  " [●]\n" : " [ ]\n");
		}
	}
	
	
	// 리스트 다시 불러오기
	private void refreshList() {
		getUserTodoList();
		COMPLETED_COUNT = COMPLETED_LIST.size();
		USER_GRADE = getUserGrade();
	}
	
}
