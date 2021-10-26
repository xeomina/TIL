package com.edu.child;

import com.edu.parent.Person;

//��ӿ��� �ڽ��� ������ �θ��� ������ ���� ���� �������� �Ѵ�
//�θ� �����Ǿ� ���� �ʰ��� ���� �ڽ��� ���� �� ����
//�θ�� �ڽ� Ŭ������ ���� �ٸ� Ŭ����������, �޸𸮿����� �Ѹ����� �ö󰣴�
public class Student extends Person{
	private int stuId;
	
	public Student(String name, int age, String address, int stuId) {
		super(name, age, address);	//�⺻ �����ڰ� �ƴ� ����� �����ڷ� �θ�! (super(); - x)
		this.stuId = stuId;
	}
	
	/*
	 * 1.�θ� ���� �޼ҵ带 �����޴´�
	 * 2.�װ� �ڽ����� �°� ���ľ���
	 * -> �θ��� ��ɰ� �ڽ��� ����� �޶�����
	 * -> �ڽĿ��� �´� ������� �ٽ� ���Ľ��
	 */

	@Override
	public String getDetails() {
		return super.getDetails()+","+stuId;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+stuId;
	}
}
