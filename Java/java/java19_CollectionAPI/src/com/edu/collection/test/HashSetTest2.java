package com.edu.collection.test;

import java.util.HashSet;

/*
 * 		Set
 * 		 |
 *    HashSet		�� ������ ���� ����� �˾ƺ��� ������ �ۼ�
 * ������ ���� : ���������� index ������ �ȵȴ�
 * �ߺ��� ������� �ʴ´� : ���� �ߺ��� �Ǿ��� �ϴ��� ������� �ʴ´�
 * 
 * 	add(E)
 *  size()
 *  remove(E) boolean
 *  clear()
 *  isEmpty()
 *  contains()
 * 
 * 
 */
public class HashSetTest2 {

	public static void main(String[] args) {
		//<E> Set�ȿ� ����ִ� ��ü Ÿ���� �̸� ������ �� �ִ�
		HashSet<String> set = new HashSet<String>();
		set.add("������");
		set.add("�̼���");
		set.add("��ȣ��");
		set.add("��ȣ��");
		set.add("����ö");
		
		System.out.println("���? " +set.size()); 	//4 -> �ߺ����x
		
		//Set�ȿ� ����ִ� �����͸� ���	
		//1.�Էµ� ������� ��µ��� �ʴ´� - ������ ������ Ȯ��
		//2.Collection������ toString()�� �����͸� �����ϵ��� ��ü������ �������̵� �Ǿ����ִ�
		System.out.println(set.toString());			//[������, ��ȣ��, �̼���, ����ö]
		System.out.println(set);					//���� ���� - �ּҰ� x
		
		//�迵ö�� ���ԵǾ��� �ִ��� ����
		System.out.println("�迵ö�� ����? "+set.contains("�迵ö"));	//false
		
		//��ȣ���� ����
		set.remove("��ȣ��");
		System.out.println(set);	//[������, �̼���, ����ö]
		
		//set�� ����� ��� �����͸� ����
		set.clear();
		
		System.out.println("set���� �� ����� �ִ°�? "+set.isEmpty());		//true
		System.out.println(set);	//[]
		
		

	}

}
