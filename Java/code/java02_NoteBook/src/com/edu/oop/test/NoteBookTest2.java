package com.edu.oop.test;

import com.edu.oop2.NoteBook;
/*
 * NoteBookTest2 ����
 * 1) Ŭ������ filed�� �� �Ҵ��ϴ� �κ��� �ڵ������ �ʹ� ��� ����
 *    ���࿡ �ʵ尡 ������ �� �߰��ȴٸ� �ʵ尪 �Ҵ��ϴ� �κ��� �þ
 *    ������ ��ü ������ ������ �Ѵٸ� ���ϱ޼������� �ڵ������ �þ
 *    -> ���뼺�� ����߸��� �������� ����
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
