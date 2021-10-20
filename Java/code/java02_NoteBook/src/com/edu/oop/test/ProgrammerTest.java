package com.edu.oop.test;

import com.edu.oop2.Programmer;

/*
 * 1. Programmer�� 2�� ����...pro1, pro2
 * 2. ������ Programmer�� ���� �Է�
 *    �Էµ� ������ ���� �ַܼ� ���
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

