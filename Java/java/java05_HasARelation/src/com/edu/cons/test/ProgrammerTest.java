package com.edu.cons.test;

import com.edu.cons.NoteBook;
import com.edu.cons.Programmer;


public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. Programmer ��ü ���� - James
		 * 2. James�� �Ｚ ��Ʈ�� �Ѵ� ����
		 * 3. James�� ������ ��Ʈ���� ������ ���
		 *    �̶� James�� �����(mainSkill)�� �Բ� ���
		 */
		
		//James ��ü ����
		Programmer james = new Programmer("James", "LA", "AI", 5000000);
		
		//James�� ��Ʈ���� ���� - Has a Relation
		james.buyNoteBook(new NoteBook("SAMSUNG", 150, 1234));
		
		//James�� ������ ��Ʈ�� ���� ���
		james.getNoteBook().printInfo();
		
		//James�� �����(mainSkill) ���
		System.out.println("mainSkill: " + james.getMainSkill());
		
		
/*		�� �ڵ�	
 *		NoteBook nb = new NoteBook("SAMSUNG", 150, 1234);
		Programmer pro = new Programmer("James", "LA", "AI", 5000000);
		pro.buyNoteBook(nb);
		pro.getNoteBook().printInfo();
		System.out.println(pro.getProgrammerInfo());*/
	}
}
