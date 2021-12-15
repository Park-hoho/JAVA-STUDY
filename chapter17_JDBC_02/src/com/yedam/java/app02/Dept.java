package com.yedam.java.app02;

public class Dept {
	private int departmentId;
	private String departmentName;
	private String lastName;
	private String city;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Dept [departmentId=" + departmentId + ", departmentName=" + departmentName + ", lastName=" + lastName
				+ ", city=" + city + "]";
	}

}
