package com.edu.test;
/* 
 * Polymorphism
 * 
 * �θ� Ÿ���� Ŭ������ �ڽ��� �����ϴ� ��
 * 2���� �̽��� �߻� -> �ذ� -> ��Ȯ�� ����
 * 1)�� ����� �����ϰ� ���?
 *   -> Virtual Method Invocation
 *   �θ�Ÿ������ �ڽİ�ü�� �����ϰ�
 *   Overriding�� �޼ҵ带 �θ�Ÿ���� ������ ȣ���ϸ� �߻��ϴ� ����
 *    
 *    -  Compile Type Method : �θ��� �޼ҵ尡 ȣ���
 *    -  Runtime Type Method : �ڽ��� �޼ҵ尡 ȣ���
 *   
 * 2)�� ����?
 * 	 -> Object Casting
 * 	 Employee�� �ƴ� Manager�� ĳ���� !!
 * 
 */

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest1 {

	public static void main(String[] args) {
		
/*		Employee e = new Employee("Peter", new MyDate(2000,1,1));
		Manager m = new Manager("James", new MyDate(1990,1,1), 30000.0, "IT");
		Engineer eg = new Engineer("Tom", new MyDate(1980,1,1), 400000.0, "AI", 1000);*/
		
		//Polymorphism ������� �ڽ� ��ü�� ����
//		Employee e = new Employee("Peter", new MyDate(2000,1,1));	//�θ�
		Employee m = new Manager("James", new MyDate(1990,1,1), 30000.0, "IT");
		Employee eg = new Engineer("Tom", new MyDate(1980,1,1), 400000.0, "AI", 1000);
		Employee s = new Secretary("Jane", new MyDate(1985,1,1), 350000.0, "Tom");
		
		//1)
		System.out.println(m.getDetails());		//James,1990-1-1,30000.0,IT
		System.out.println(eg.getDetails());	//Tom,1980-1-1,400000.0,AI
		System.out.println(s.getDetails());		//Jane,1985-1-1,350000.0,Tom
		
		//2)
		((Manager)m).changeDept("Marketing");
		System.out.println(m.getDetails());		//James,1990-1-1,30000.0,Marketing
		

	}

}
