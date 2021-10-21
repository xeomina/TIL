package com.edu.oop.test;

import com.edu.oop2.Programmer;

/*
 * 1. Programmer를 2명 생성...pro1, pro2
 * 2. 각각의 Programmer의 값을 입력
 *    입력된 각각의 값을 콘솔로 출력
 */
public class ProgrammerTest {
	public static void main(String[] args) {	
		
		Programmer pro1 = new Programmer();
		Programmer pro2 = new Programmer();
		
		pro1.setProgrammerInfo("James", "LA", "AI", 5000000);
		pro2.setProgrammerInfo("Gosling", "Texas", "Python", 3500000);
		
		System.out.println(pro1.getProgrammerInfo());
		System.out.println(pro2.getProgrammerInfo());
	
		System.out.println(pro2.getAnnualSalary());
	}
}

