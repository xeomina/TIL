package com.edu.oop.test;

import com.edu.oop.Greeting;

/*
 * main �޼ҵ带 ���� ���� Ŭ����
 * ~~Test.java
 * :: 
 * 
 * 1) ��ü�� �����Ѵ� == Ŭ������ ��� ��Ҹ� �޸𸮿� �ø���.
 * 2) �޸𸮿� �ö� ������ �޼ҵ忡 �����Ѵ�.
 *    ������ ����---> ���Ҵ�
 *    �޼ҵ� ���� ---> ȣ��
 */
public class GreetingTest {
	public static void main(String[] args) {
		//��ü ���� == Greeting Ŭ������ ��� ��Ұ� �޸𸮿� �ö󰣴�.
		Greeting g = new Greeting();
		
		//�޸𸮿� �ö� ���(������ �޼ҵ�)�� ����
		g.message = "�ȳ�^^ �����ο�~~"; //�� �Ҵ�
		g.printMessage(); //�޼ҵ� ȣ��(Calling)

	}
}




