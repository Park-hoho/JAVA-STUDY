package com.yedam.java.test01;

public class SalaryMan {
	private int salary;
	
	SalaryMan() {
		salary = 1_000_000;
	}
	SalaryMan(int salary) {
		this.salary = salary;
	}
	
	public int getAnnualGross() {
		int salaryYear;
		salaryYear = (this.salary * 12) + (this.salary * 5);
		return salaryYear;
	}
	
}
