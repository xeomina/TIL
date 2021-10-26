package com.edu.parent;

/*
 * ���� ������ 4�� 
 * �����ڴ� ��� Ŭ������ �ϳ� �̻� - ���� 2~3��
 * 
 * 
 */

import com.edu.util.MyDate;

public class Employee {
	//�⺻���� �ش��ϴ� ������� ����
	public static final double BASIC_SALARY = 100;//����� :  static final �ڷ��� �빮��
	
	private String name;
	private MyDate birthDate;
	private double salary;
	
	//1.�⺻ ������
	public Employee() {} 	
	
	//2.������
	public Employee(String name, MyDate birthDate, double salary) {		
		super();	//super Ű����� ���� Ŭ������ ����Ű�� Ű����
		
		//���⼭ this�� �ʵ� �տ� ���� - �� Ŭ������ �ʵ�!! (���ڰ��̶� ����)
		this.name = name;		
		this.birthDate = birthDate;
		this.salary = salary;
	}
	
	//3.������
	public Employee(String name, MyDate birthDate) {		//argument list�� �����ϸ� error - ���� ���� Ÿ�� -> ������ overloading
//		super();	
//		this.name = name;
//		this.birthDate = birthDate;
		
		//���⼭ this�� ������ �� - �� Ŭ���� ������ �Ǵٸ� �����ڸ� ȣ�� !!
		this(name, birthDate, BASIC_SALARY);		//��������� �Ѿ�� salary���� ���� ���� ������ ������� �������ش�
	}
	
	//4.������
	public Employee(String name) {		//�̸������� ��ü ���� - �ϳ��� row �߰� / ������ �⺻��
		super();	
		this.name = name;
	}
	
	
	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;
		return name+","+birthDate+","+salary;
	}
}
