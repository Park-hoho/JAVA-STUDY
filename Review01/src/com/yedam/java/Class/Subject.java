package com.yedam.java.Class;

public class Subject {
	//필드
	private String subjectName;//과목 이름
	private int scorePoint;//과목점수
	
	//메소드
	//각 필드의 getter, setter
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getScorePoint() {
		return scorePoint;
	}
	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
	}
}
