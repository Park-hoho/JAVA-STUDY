package com.yedam.app.emp13;

public class NewEmployee {
	private int employeeId;
	private String lastName;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int departmentId;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getCommissionPct() {
		return commissionPct;
	}
	public void setCommissionPct(double commissionPct) {
		this.commissionPct = commissionPct;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	@Override
	public String toString() {
		return "직원 [사원번호: " + employeeId + ", 이름: " + lastName + ", 업무: " + jobId + ", 급여: "
				+ salary + ", 보너스: " + commissionPct + ", 부서번호: " + departmentId + "]";
	}
	
	
}
