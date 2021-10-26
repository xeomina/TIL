package com.edu.test;
/* 
 * Polymorphism
 * 
 * 부모 타입의 클래스로 자식을 생성하는 것
 * 2가지 이슈가 발생 -> 해결 -> 정확한 이해
 * 1)왜 결과가 멀쩡하게 출력?
 *   -> Virtual Method Invocation
 * 2)왜 에러?
 * 	 -> Object Casting
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
		
		//Polymorphism 방식으로 자식 객체를 생성
//		Employee e = new Employee("Peter", new MyDate(2000,1,1));	//부모
		Employee m = new Manager("James", new MyDate(1990,1,1), 30000.0, "IT");
		Employee eg = new Engineer("Tom", new MyDate(1980,1,1), 400000.0, "AI", 1000);
		Employee s = new Secretary("Jane", new MyDate(1985,1,1), 350000.0, "Tom");
		
		//1)
		System.out.println(m.getDetails());		//Employee의 getDetails 호출 -> 왜 다 출력??
		System.out.println(eg.getDetails());
		System.out.println(s.getDetails());
		
		//2)
		m.changeDept("Marketing");
		

	}

}
