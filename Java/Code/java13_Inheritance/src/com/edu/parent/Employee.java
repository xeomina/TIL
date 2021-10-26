package com.edu.parent;
/*
 * 부모 클래스 작성
 */

import com.edu.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthDate;
	private double salary;
	
//	public Employee() {} 	//default constructor
	public Employee(String name, MyDate birthDate, double salary) {
		super();	//super 키워드는 상위 클래스를 가리키는 키워드
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;
		return name+","+birthDate+","+salary;
	}
}
