package com.edu.oop.test;
/*
 * ~Test class
 * ::
 * ����Ŭ����...main
 * ::
 * 1. ��ü ����
 * 2. �޸𸮿� �ö� ����� ����...
 *    field ---> �� �Ҵ� (assign)
 *    method ---> ȣ�� (calling)
 */

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		//1. NoteBook Ŭ���� ��ü�� ���� -> NoteBook ����� �޸𸮿� �ø�
		NoteBook nb = new NoteBook();
		
		//2. ����� ���� -> �� �Ҵ�
		nb.brandName = "SAMSUNG";
		nb.price = 150;	
		nb.serialNumber = 1234;
		
		nb.printInfo(); //void�� �� ���ʿ��� ��µǰ� 
		System.out.println(nb.getBrandName()); //String�� �� �������� ���ϵ� ���� ���
		

	}
}
