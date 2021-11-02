package com.edu.parent;
/*
 * �θ� Ŭ���� �ۼ�
 */

import com.edu.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthDate;
	private double salary;
	
//	public Employee() {} 	//default constructor
	public Employee(String name, MyDate birthDate, double salary) {
		super();	//super Ű����� ���� Ŭ������ ����Ű�� Ű����
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;
		return name+","+birthDate+","+salary;
	}
}
