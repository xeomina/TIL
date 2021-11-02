package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

//�θ� Employee�� ���� Ȯ��� �ڽ� Ŭ���� Manager ����
public class Manager extends Employee{				//Field 4�� + Method 1�� = 5��

	
	private String dept;
	
	public Manager(String name, MyDate birthDate, double salary, String dept) {
/*		this.name = name;					//Error !!
		this.birthDate = birthDate;
		this.salary = salary;*/
		
//		super(); 							//Employee();ȣ�� - null,null,0.0
		super(name, birthDate, salary);		//				  James,1990-1-1,30000.0 -> �θ� Ŭ���� ��� -> public Employee() {} ���� ����
		this.dept = dept;
	}
	

	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;		//����x - private
		return super.getDetails()+","+dept;		//Method overriding - James,1990-1-1,30000.0,IT
	}
	
	//�ڽĸ��� ����� ���Ӱ� �߰��� ��� - �������̵��� �������.
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}


}
