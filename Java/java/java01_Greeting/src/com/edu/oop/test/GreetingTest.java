package com.edu.oop.test;

import com.edu.oop.Greeting;

/*
 * main method�� ���� ���� Ŭ����
 * ~~Test.java
 * 
 * 1) ��ü�� �����Ѵ� -> Ŭ������ ��� ��Ҹ� �޸𸮿� �ø���
 * 2) �޸𸮿� �ö� ������ method�� �����Ѵ� 
 *    ������ ���� -> �� �Ҵ� / method�� ���� -> ȣ��
 */


public class GreetingTest {

	public static void main(String[] args) {
		// ��ü ���� (��ü �̸� = g) -> Greeting Ŭ������ ��� ��Ұ� �޸𸮿� �ö� => why? ����Ϸ���		
		Greeting g = new Greeting();
		
		// �޸𸮿� �ö� ���(������ method)�� ����
		g.message = "�ȳ��ϼ��� ������";	// ����(variable)�� ������(literal value) �Ҵ�(assign)
		g.printMessage();			// method ȣ��(calling)

	}
}
