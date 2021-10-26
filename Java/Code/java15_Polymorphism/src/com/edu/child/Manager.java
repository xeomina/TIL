package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Manager extends Employee{				
	
	private String dept;
	
	public Manager(String name, MyDate birthDate, double salary, String dept) {
		super(name, birthDate, salary);		
		this.dept = dept;
	}
	
	public String getDetails() {
		return super.getDetails()+","+dept;		
	}
	
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}


}
