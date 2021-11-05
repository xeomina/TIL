package com.edu.service;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;

/*
 * Employee의 자식 클래스인
 * Manager,Engineer,Secretary 객체들을 핸들링하는 기능만으로 이뤄진 Service 클래스
 * 
 * 						Employee
 * 
 * 			Manager		Engineer	Secretary
 * 
 * 
 * 위 구조를 핸들링할 때 사용하는 메소드 기법 - 추가에 관련된 기능을 정의하는 경우
 * 
 * 1) 가장 저차원적 - 절대 이렇게 하면 안됨!!! 코드 가동력 떨어짐
 * public void addManager(Manager m){ }
 * public void insertEngineer(Engineer eg){ }
 * public void manageSec(Secretary sc){ } 	 
 * 
 * 2) 위 보단 조금 나은 정의 - 일관성 있음
 * public void addManager(Manager m){ }
 * public void addEngineer(Engineer eg){ }
 * public void addSecretary(Secretary sc){ }
 * 
 * 3) 2단계와 비슷하지만 훨씬 더 일관성과 가독성을 높임
 * 	  - method overloading
 * public void addEmployee(Manager m){ }
 * public void addEmployee(Engineer eg){ }
 * public void addEmployee(Secretary sc){ } 
 * 
 * 4) 3단계와 같은 역할을 하지만 한번만 정의하면 된다
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
			((Manager) e).changeDept("오락부");
			System.out.println("Manager Change Dept: "+((Manager) e).getDetails());
		  }
	   }
	   
	   public void printAllEmployee(Employee[ ] emps) {
	      for(Employee e : emps)
	         System.out.println(e.getDetails());
	   }
	}//class