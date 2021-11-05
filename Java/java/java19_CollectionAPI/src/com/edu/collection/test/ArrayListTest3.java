package com.edu.collection.test;

import java.util.ArrayList;
import java.util.List;

/*
 *  	List
 * 		 |
 *    ArrayList		�� ������ ���� ����� �˾ƺ��� ������ �ۼ�
 * ������ �ִ� : ���������� index�� �����ȴ�
 * ������ �ߺ��� ����Ѵ�
 * 
 * 
 */
public class ArrayListTest3 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();  //<> , <String> �Ѵ� �������.
		
		list.add("��ȣ��");
		list.add("�̼���");
		list.add("��ȣ��");
		list.add("�迵ö");
		list.add("������");
		
		System.out.println(list); 	//������ ����(�Է��� ������� ���), �ߺ� ���
		
		//2��°(index 1)������ ����
		String removeName=list.remove(1); //������ ������ ��ü�� ����
		System.out.println(removeName+" ���� ����");
		System.out.println(list);
		
		//���� ù��°�� ����ö�� �߰�
		list.add(0,"����ö");
		System.out.println(list);
		
		//list�� ����� �߿��� �̸��� �������� ����� ã�Ƽ� ���
		//for, equals, get
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals("������"))
				System.out.println(list.get(i));
					}
		
		
				

	}

}
