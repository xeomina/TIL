package com.edu.test;
/*
 * static 1,2,3�� ���� �ڵ�
 * 1. static���� ������ ����� ��ü ������ �ʿ� ���� �ٷ� �����ؼ� ��� �����ϴ�
 * 2. class(�������� - byteCode)������ �޸�(JVM)�� �δ��Ǵ� �������� �̸� �޸𸮿� �ö󰣴�
 * 3. static���� ������ ������ local�������� ����� �� ����
 */

class Member{
	static String name = "ȫ�浿";	//static V
	static int age = 19;			//static V
	int count = 1;					//field
	
	//static
	public static void getMember() {
		System.out.println("�������� " + name);
	}
	
	//non-static
	public void getMember2() {
		//static�� local ������ ����� �� ����
//		static String address = "�ѳ���";
		System.out.println("�������� " + name);
	}
	
	//static
	public static void getMember3() {
		System.out.println("�������� " + name);
//		count++; //non-static - ����
	}
}

public class StaticExamTest1 {

	public static void main(String[] args) { 			//main�� static
		//Member�� �ִ� getMember()�� ��� - ȣ��
		//static���� ������ �͵��� ��ü ���� �ʿ���� Ŭ���� �̸�.���� �ٷ� ��� ���� (�޸𸮿� �̸� �ö�)
		Member.getMember(); 
		
//		Member.getMember2();	//static �������� non-static ��� ��� �Ұ� - static�� static����
		Member m = new Member(); //��ü ����(�޸� �ø�) ������ ��� ����
		m.getMember2();

	}

}
