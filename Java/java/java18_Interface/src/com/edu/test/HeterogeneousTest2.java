package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

/*
 * Heterogeneous Collection <-> Homogeneous Collection
 * 
 * 서로 다른 타입을 가지는 이기종간의 집합체
 * -> 이기종간의 자식 클래스들을 부모타입으로 단일하게 관리
 * 
 * 배열의 전제조건 - SameDataType 
 * -> 여기서는 Manager/Engineer/Secretary로 서로 다른 클래스 타입
 * -> Employee 상속
 * 
 * 그러나 동종간의 집합은 x -> Heterogeneous Collection
 */

public class HeterogeneousTest2 {

	public static void main(String[] args) {
		//이기종간의 다양한 자식클래스들을 단일하게 관리하기 위해서는 부모타입의 []에 담아야
		Employee[]emps= {
				new Manager("James", new MyDate(1990,1,1), 30000.0, "IT"),
				new Engineer("Tom", new MyDate(1980,1,1), 400000.0, "AI", 1000),
				new Secretary("Jane", new MyDate(1985,1,1), 350000.0, "Tom"),
				new Manager("Peter", new MyDate(1982,2,11), 50000.0, "Python"),
				new Manager("Juliet", new MyDate(1992,3,1), 65000.0, "Education")
		};
		
		//자식들은 부모타입 container에 담길 수 있다
//		for(Employee e : emps) System.out.println(e.getDetails());
		
		System.out.println("=========모든 고용인들의 연봉 출력=========");
		
		//emps중에서 실질적으로 생성된 자식객체 타입을 알아야할 필요가 있다
		//부모타입으로 생성된 객체가 Manager, Engineer, Secretary 인지 알아야한다
		//이럴 때 사용하는 키워드가 instanceof 키워드
		
		for(Employee e : emps) {
			//e타입으로 생성된 객체타입이 Engineer가 맞다면
			if(e instanceof Engineer) {
				System.out.println("Information Engineer: "+e.getDetails());
				System.out.println("AnnualSalary: "+((e.getSalary())*12+((Engineer) e).getBonus()));	//int끼리 먼저 연산 후 String과 연산 - Non String과 String 붙으면 String으로 계산됨
				System.out.println("------------------------------------");
			}
			else if (e instanceof Manager) {
				System.out.println("Information Manager: "+e.getDetails());
				((Manager) e).changeDept("교육부");
				System.out.println("Change Dept: "+((Manager) e).getDetails());
				System.out.println("------------------------------------");
			}
			else {
			System.out.println("Information: "+e.getDetails());
			System.out.println("AnnualSalary: "+e.getSalary()*12);
			System.out.println("------------------------------------");
		}
		}
		
		
	} //main

} //class
