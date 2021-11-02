package com.edu.cons.test;

import com.edu.cons.NoteBook;
import com.edu.cons.Programmer;


public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. Programmer 객체 생성 - James
		 * 2. James가 삼성 노트북 한대 구매
		 * 3. James가 구매한 노트북의 정보를 출력
		 *    이때 James의 기술셋(mainSkill)도 함께 출력
		 */
		
		//James 객체 생성
		Programmer james = new Programmer("James", "LA", "AI", 5000000);
		
		//James가 노트북을 구매 - Has a Relation
		james.buyNoteBook(new NoteBook("SAMSUNG", 150, 1234));
		
		//James가 구매한 노트북 정보 출력
		james.getNoteBook().printInfo();
		
		//James가 기술셋(mainSkill) 출력
		System.out.println("mainSkill: " + james.getMainSkill());
		
		
/*		내 코드	
 *		NoteBook nb = new NoteBook("SAMSUNG", 150, 1234);
		Programmer pro = new Programmer("James", "LA", "AI", 5000000);
		pro.buyNoteBook(nb);
		pro.getNoteBook().printInfo();
		System.out.println(pro.getProgrammerInfo());*/
	}
}
