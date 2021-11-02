package com.edu.test;

import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class EmployeeTest1 {

	public static void main(String[] args) {
		
		Employee e = new Employee("Peter", new MyDate(2000,1,1));
		Manager m = new Manager("James", new MyDate(1990,1,1), 30000.0, "IT");
		
		System.out.println(m.getDetails());		
		System.out.println(e.getDetails());		//기본값 없을 때: Peter,2000-1-1,0.0 -> 기본값 생성: Peter,2000-1-1,100.0
		
		m.changeDept("Marketing");
		System.out.println(m.getDetails());		
		

	}

}
