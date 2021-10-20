package com.edu.oop.test;

import com.edu.oop2.NoteBook;
/*
 * NoteBookTest2 문제
 * 1) 클래스의 filed에 값 할당하는 부분이 코드라인을 너무 길게 만듦
 *    만약에 필드가 여러개 더 추가된다면 필드값 할당하는 부분이 늘어남
 *    더욱이 객체 생성을 여러개 한다면 기하급수적으로 코드라인이 늘어남
 *    -> 재사용성을 떨어뜨리는 결정적인 요인
 *    
 */
public class NoteBookTest2 {

	public static void main(String[] args) {
		
		NoteBook nb = new NoteBook();
		NoteBook nb2 = new NoteBook();
		
/*		nb.brandName = "SAMSUNG";
		nb.price = 150;	
		nb.serialNumber = 1234;
		
		nb2.brandName = "LG";
		nb2.price = 200;	
		nb2.serialNumber = 5678;*/			// ctrl + shift + / or \
		
		nb.setNoteBookInfo("SAMSUNG", 150, 1234);
		nb2.setNoteBookInfo("LG", 200, 5678);
		
		nb.printInfo(); 
		System.out.println(nb.getBrandName()); 
		
		System.out.println("=============================="); 
		
		nb2.printInfo(); 
		System.out.println(nb2.getBrandName()); 
		

	}
}
