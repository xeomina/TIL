package com.edu.test;
/*
 * static Ű����� ������� ������ �� ���̴� final Ű����� �Բ� ���Ǵ� ��찡 ����
 * 
 * Usage Modifier
 * final static abstract
 * 
 * 1.final
 * "���� �������̾�" ��� �ǹ̸� ������ Ű�����̴�
 * final + ���� : ���� ������ ������ -> �����
 * final + �޼ҵ� : ���� ������ �޼ҵ�� -> �������̵� ����
 * final + Ŭ���� : ���� ������ Ŭ������ -> ��� ����
 * 
 * final�� static ������ �������
 * 
 */

class A{
	public final static int BASIC_SALAY = 1000;
	public final String test() {
		return "Overriding ����";
	}
	
final class B{
	
}

//class C extends B{}

class D extends A{
//	public String test() {
//		return "Overriding ����"+100;
//	BASIC_SALAY = 2000;
}

}
public class StaticExamTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
