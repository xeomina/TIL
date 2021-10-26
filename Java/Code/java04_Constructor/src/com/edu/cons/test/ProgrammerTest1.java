package com.edu.cons.test;

import com.edu.cons.NoteBook;
import com.edu.cons.Programmer;


public class ProgrammerTest1 {

	public static void main(String[] args) {
		/*
		 * 1. NoteBook ��ü�� 2�� ���� - nb1,nb2
		 *    �̶� ���� ���� ��θ� �����ڷ� - set ��� x
		 * 2. Programmer ��ü�� 2�� ���� - pro1, pro2
		 *    �̶� ���� ���� ��θ� �����ڷ� - set ��� x
		 * 3. nb1,nb2 ���� ���
		 * 4. pro1,pro2  ���� ���
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
