package com.edu.oop2;
/*
 * Programmer�� ����(�ʵ�, ���)�� ��� �ִ� Ŭ����
 * field(4) :: �̸�, ��°�, ���, ����(String, int)
 * method(2) :: 
 * 1) �ʵ��ʱ�ȭ
 * 2) �ʵ��� ��� ���� �����ϴ� ���
 * 
 */
public class Programmer {
	String name;
	String address;
	String mainSkill;
	int salary;
	
	public String getProgrammerInfo() {
		return name+"\t"+address+"\t"+mainSkill+"\t"+salary;
	}
	
	public void setProgrammerInfo(String name,
			String address,String mainSkill, int salary ) {
		//�ʵ��ʱ�ȭ
		this.name = name;
		this.address = address;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}

	
	//������ �����ϴ� ����� �ۼ�
	public int getAnnualSalary() {
		//������ ����� method�� �� �µ��� �˾Ƽ� �����Ѵ�
		return salary*12;
	}
}
