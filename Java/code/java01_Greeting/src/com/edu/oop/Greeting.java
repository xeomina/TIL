package com.edu.oop;


/*
 * �λ񸻿� ���� ������ ����� ��� �ִ� Ŭ����
 * �λ�--? (��) -> ���� = ���� ��� ����
 * �λ��� �ܼ�â�� ����ϴ� ���-- method, �Լ�

 * Greeting Ŭ���� ���� ��
 * ���� / ��� 
 */

public class Greeting {
	public String message; // ���� (message) ����
	
	// method ���� = method ���� + method ����
	public void printMessage() {								// method ����
		System.out.println("Greeting Message = " + message); 	// method ���� -> worker
	
	}
}
