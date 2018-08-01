package com.ab.nativeQueries;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Details")
@NamedNativeQueries({
	@NamedNativeQuery(name="getAllEmployees", query="select * from employee_details"),
	@NamedNativeQuery(name="getSpecificEmployee", query="select * from employee_details where id=:id")
})
@NamedQueries({
	@NamedQuery(name="getAll", query="from EmployeeDetails"),
	@NamedQuery(name="getSpecific", query="from EmployeeDetails where id=:id")
})
public class EmployeeDetails {

	@Id
	private int id;
	private String name;
	private String department;
	private String email;
	private String password;
	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDetails(int id, String name, String department, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "\n EmployeeDetails [id=" + id + ", name=" + name + ", department=" + department + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
}//EmployeeDetails
