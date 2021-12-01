package com.yedam.java.Class;

public class MainExample {

	public static void main(String[] args) {
		// 1001학번 Lee와 1002학번 Kim, 두 학생이 있습니다.
		// Lee학생은 2과목을 수강합니다. 국어 점수가 100점, 수학 점수가 50점입니다.
		// Kim학생은 3과목을 수강합니다. 국어 점수가 70점, 수학 점수가 85점, 영어 점수가 100점
		// Student 클래스와 Subject 클래스를 생성한 후 두 학생의 과목성적과 총점을 각각 출력
		
		Student Lee = new Student("Lee");
		Student Kim = new Student("Kim");
		
		Lee.addSubject("국어", 100);
		Lee.addSubject("수학", 50);
		
		Lee.showStudentInfo();
		Lee.showStudentSubjectInfo();
		System.out.println();
		
		Kim.addSubject("국어", 70);
		Kim.addSubject("수학", 85);
		Kim.addSubject("영어", 100);
		
		Kim.showStudentInfo();
		Kim.showStudentSubjectInfo();
	}

}
