package com.edu.service;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;


public class EmployeeServiceImpl implements EmployeeService{
	public void manageEmployee(Employee e){		 
		if(e instanceof Engineer) {
			System.out.println("Engineer AnnualSalary: "+((e.getSalary())*12+((Engineer) e).getBonus()));
		}
		
		if (e instanceof Manager) {
			((Manager) e).changeDept("¿À¶ôºÎ");
			System.out.println("Manager Change Dept: "+((Manager) e).getDetails());
		  }
	   }
	   
	   public void printAllEmployee(Employee[ ] emps) {
	      for(Employee e : emps)
	         System.out.println(e.getDetails());
	   }
	}//class