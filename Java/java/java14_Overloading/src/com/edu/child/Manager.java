package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

//부모 Employee로 부터 확장된 자식 클래스 Manager 선언
public class Manager extends Employee{				//Field 4개 + Method 1개 = 5개

	
	private String dept;
	
	public Manager(String name, MyDate birthDate, double salary, String dept) {
/*		this.name = name;					//Error !!
		this.birthDate = birthDate;
		this.salary = salary;*/
		
//		super(); 							//Employee();호출 - null,null,0.0
		super(name, birthDate, salary);		//				  James,1990-1-1,30000.0 -> 부모 클래스 명시 -> public Employee() {} 생략 가능
		this.dept = dept;
	}
	

	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;		//접근x - private
		return super.getDetails()+","+dept;		//Method overriding - James,1990-1-1,30000.0,IT
	}
	
	//자식만의 멤버로 새롭게 추가한 기능 - 오버라이딩과 상관없다.
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}


}
