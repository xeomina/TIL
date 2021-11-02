package com.edu.cons.test;

import com.edu.cons.NoteBook;
import com.edu.cons.Programmer;


public class ProgrammerTest1 {

	public static void main(String[] args) {
		/*
		 * 1. NoteBook 객체를 2개 생성 - nb1,nb2
		 *    이때 값의 주입 통로를 생성자로 - set 사용 x
		 * 2. Programmer 객체를 2개 생성 - pro1, pro2
		 *    이때 값의 주입 통로를 생성자로 - set 사용 x
		 * 3. nb1,nb2 정보 출력
		 * 4. pro1,pro2  정보 출력
		 * 
		 */
		
		NoteBook nb1 = new NoteBook("SAMSUNG", 150, 1234);
		NoteBook nb2 = new NoteBook("LG", 200, 5678);
		
		Programmer pro1 = new Programmer("James", "LA", "AI", 5000000);
		Programmer pro2 = new Programmer("Gosling", "Texas", "Python", 3500000);
		
		nb1.printInfo();
		nb2.printInfo();
		
		System.out.println(pro1.getProgrammerInfo());
		System.out.println(pro2.getProgrammerInfo());
				
		

	}

}
