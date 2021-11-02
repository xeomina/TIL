package com.edu.parent;

/*
 * 현재 생성자 4개 
 * 생성자는 모든 클래스에 하나 이상 - 보통 2~3개
 * 
 * 
 */

import com.edu.util.MyDate;

public class Employee {
	//기본값에 해당하는 상수값을 지정
	public static final double BASIC_SALARY = 100;//상수값 :  static final 자료형 대문자
	
	private String name;
	private MyDate birthDate;
	private double salary;
	
	//1.기본 생성자
	public Employee() {} 	
	
	//2.생성자
	public Employee(String name, MyDate birthDate, double salary) {		
		super();	//super 키워드는 상위 클래스를 가리키는 키워드
		
		//여기서 this는 필드 앞에 붙음 - 이 클래스의 필드!! (인자값이랑 구분)
		this.name = name;		
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	//3.생성자
	public Employee(String name, MyDate birthDate) {		//argument list가 동일하면 error - 순서 개수 타입 -> 생성자 overloading
//		super();	
//		this.name = name;
//		this.birthDate = birthDate;
		
		//여기서 this는 생성자 앞 - 한 클래스 내에서 또다른 생성자를 호출 !!
		this(name, birthDate, BASIC_SALARY);		//명시적으로 넘어온 salary값이 없을 때는 지정된 상수값을 연결해준다
	}
	
	//4.생성자
	public Employee(String name) {		//이름만으로 객체 생성 - 하나의 row 추가 / 나머지 기본값
		super();	
		this.name = name;
	}
	
	
	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;
		return name+","+birthDate+","+salary;
	}
}
