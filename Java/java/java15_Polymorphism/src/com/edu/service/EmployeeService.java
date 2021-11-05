package com.edu.service;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;

/*
 * Employee�� �ڽ� Ŭ������
 * Manager,Engineer,Secretary ��ü���� �ڵ鸵�ϴ� ��ɸ����� �̷��� Service Ŭ����
 * 
 * 						Employee
 * 
 * 			Manager		Engineer	Secretary
 * 
 * 
 * �� ������ �ڵ鸵�� �� ����ϴ� �޼ҵ� ��� - �߰��� ���õ� ����� �����ϴ� ���
 * 
 * 1) ���� �������� - ���� �̷��� �ϸ� �ȵ�!!! �ڵ� ������ ������
 * public void addManager(Manager m){ }
 * public void insertEngineer(Engineer eg){ }
 * public void manageSec(Secretary sc){ } 	 
 * 
 * 2) �� ���� ���� ���� ���� - �ϰ��� ����
 * public void addManager(Manager m){ }
 * public void addEngineer(Engineer eg){ }
 * public void addSecretary(Secretary sc){ }
 * 
 * 3) 2�ܰ�� ��������� �ξ� �� �ϰ����� �������� ����
 * 	  - method overloading
 * public void addEmployee(Manager m){ }
 * public void addEmployee(Engineer eg){ }
 * public void addEmployee(Secretary sc){ } 
 * 
 * 4) 3�ܰ�� ���� ������ ������ �ѹ��� �����ϸ� �ȴ�
 * public void addEmployee(Employee e){
 * if(e instance Manager){
 *  }
 *  if(e instance Engineer){
 *  }
 *  if(e instance Secretary){
 *  }
 *  }
 * 
 */

public class EmployeeService {
	public void manageEmployee(Employee e){		 
		if(e instanceof Engineer) {
			System.out.println("Engineer AnnualSalary: "+((e.getSalary())*12+((Engineer) e).getBonus()));
		}
		
		if (e instanceof Manager) {
			((Manager) e).changeDept("������");
			System.out.println("Manager Change Dept: "+((Manager) e).getDetails());
		  }
	   }
	   
	   public void printAllEmployee(Employee[ ] emps) {
	      for(Employee e : emps)
	         System.out.println(e.getDetails());
	   }
	}//class