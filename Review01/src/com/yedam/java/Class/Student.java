package com.yedam.java.Class;

public class Student {
	//필드
	private static int serialNumber = 1000;
	private final static int MAX_SUBJECTS = 3;
	
	private int studentId;//학번
	private String name;//이름
	private Subject[] subjects; //수강과목 목록 -> 최대 3과목까지
	private int count;//수강과목 목록에 저장된 수강과목 수
	
	//생성자
	//매개변수로 학번과 이름을 받아서 필드를 초기화
	Student(String name) {
		serialNumber++;
		studentId = serialNumber;
		this.name = name;
		this.subjects = new Subject[MAX_SUBJECTS];
		count = 0;
	}
	
	//메서드
	//학생이 가지고 있는 과목정보
	public void addSubject(String subjectName, int scorePoint) {
		if(this.count < Student.MAX_SUBJECTS) {
			Subject subject = new Subject();
			subject.setSubjectName(subjectName);
			subject.setScorePoint(scorePoint);
			subjects[count++] = subject;			
		} else {
			System.out.println("수강과목정보를 더이상 입력할 수 없습니다.");
		}
	}
	
	//출력형태 1) 학생 홍길동의 수학 과목은 80점입니다.
	//출력형태 2) 학생 홍길동의 총점은 300점입니다.
	public void showStudentSubjectInfo() {
		int sum = 0;
		for(int i = 0; i < count; i++) {
			sum += subjects[i].getScorePoint();
			System.out.printf("학생 %s의 %s 과목은 %d점입니다.\n", this.name, subjects[i].getSubjectName(), subjects[i].getScorePoint());			
		}
		System.out.printf("학생 %s의 총점은 %d점입니다.\n", this.name, sum);
	}
	
	public void showStudentInfo() {
		System.out.printf("학생정보 - 학번 : %d, 이름 : %s, 수강과목수 : %d\n", studentId, name, count);
	}
}
