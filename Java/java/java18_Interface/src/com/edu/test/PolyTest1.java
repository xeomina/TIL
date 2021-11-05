package com.edu.test;
/* 
 * Polymorphism
 * 
 * 부모 타입의 클래스로 자식을 생성하는 것
 * 2가지 이슈가 발생 -> 해결 -> 정확한 이해
 * 1)왜 결과가 멀쩡하게 출력?
 *   -> Virtual Method Invocation
 *   부모타입으로 자식객체를 생성하고
 *   Overriding된 메소드를 부모타입의 변수로 호출하면 발생하는 원리
 *    
 *    -  Compile Type Method : 부모의 메소드가 호출됨
 *    -  Runtime Type Method : 자식의 메소드가 호출됨
 *   
 * 2)왜 에러?
 * 	 -> Object Casting
 * 	 Employee가 아닌 Manager를 캐스팅 !!
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
		System.out.println(m.getDetails());		//James,1990-1-1,30000.0,IT
		System.out.println(eg.getDetails());	//Tom,1980-1-1,400000.0,AI
		System.out.println(s.getDetails());		//Jane,1985-1-1,350000.0,Tom
		
		//2)
		((Manager)m).changeDept("Marketing");
		System.out.println(m.getDetails());		//James,1990-1-1,30000.0,Marketing
		

	}

}
