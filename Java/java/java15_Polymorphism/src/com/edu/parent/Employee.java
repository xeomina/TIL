package com.edu.parent;

import com.edu.util.MyDate;

public class Employee {
	public static final double BASIC_SALARY = 100;
	
	private String name;
	private MyDate birthDate;
	private double salary;
	
	public Employee() {} 	
	
	public Employee(String name, MyDate birthDate, double salary) {		
		super();	
		
		this.name = name;		
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	public Employee(String name, MyDate birthDate) {		
		this(name, birthDate, BASIC_SALARY);		
	}
	
	public Employee(String name) {		
		super();	
		this.name = name;
	}
	
	public String getDetails() {
		return name+","+birthDate+","+salary;
	}
}
