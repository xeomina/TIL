package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		//1. NoteBook Ŭ���� ��ü�� ���� == NoteBook ����� �޸𸮿� �ø�
		NoteBook nb = new NoteBook();
		
		//2. ����� ����
		nb.brandName = "LG Gram";
		nb.price = 170;
		
		nb.printInfo();

	}
}
