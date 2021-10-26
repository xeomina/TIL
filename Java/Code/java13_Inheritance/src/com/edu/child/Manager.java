package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

/*
 * Employee�� �ڽ� Ŭ����
 * �θ� ���� ��� ������ �����ް�
 * 			+
 * �ڽŸ��� ����� �߰�
 *  
 *  
 * ��ӿ��� �ڽ� Ŭ����
 * �ʵ� -> �ڽŸ��� �ʵ带 �߰�
 * �޼ҵ� -> �θ� ������ ����� �ڱ⿡�� �°� ���ľ���
 * (�������̵�: ��Ӱ��迡 �ִ� 2���� Ŭ���������� ����)
 */


//�θ� Employee�� ���� Ȯ��� �ڽ� Ŭ���� Manager ����
public class Manager extends Employee{				//Field 4�� + Method 1�� = 5��

	
	private String dept;
	
	public Manager(String name, MyDate birthDate, double salary, String dept) {
/*		this.name = name;					//Error !!
		this.birthDate = birthDate;
		this.salary = salary;*/
		
//		super(); 							//Employee();ȣ�� - null,null,0.0
		super(name, birthDate, salary);		//				  James,1990-1-1,30000.0 -> �θ� Ŭ���� ��� -> public Employee() {} ���� ����
		this.dept = dept;
	}
	
/*
 * ��Ӱ��迡 �ִ� 2���� Ŭ�������� method�� ��ӵ� �� �Ͼ�� ��
 * Method overriding
 * 1 step. �θ� ���� method�� �״�� �����޴´�.
 * 2.step. �װ� ��ģ��
 * 
 * �θ� ���� �޼ҵ带 �����޾Ƽ� ����� �ڽĿ��� �°� �ٽ� ���ļ� ����ϴ� ��
 * ����� �ٲ���� ������ ���ο� �޼ҵ尡 ��������ٰ� �����ص� �ȴ� - �޼ҵ� ������ !!!
 * 
 * <Rule>
 * 1. �޼ҵ� ����δ� ��� ��ġ - �̸�, ���ڰ�, ����Ÿ��
 * 2. �޼ҵ� �����δ� �޶�� �Ѵ� - ����� �޶�����
 * 3. ���� �ٸ� ��Ӱ����� Ŭ�������� �߻��Ѵ�  - ���x �߻����� ����!!
 * 
 */
	public String getDetails() {
//		return name+","+birthDate.getDate()+","+salary;		//����x - private
		return super.getDetails()+","+dept;		//Method overriding - James,1990-1-1,30000.0,IT
	}
	
	//�ڽĸ��� ����� ���Ӱ� �߰��� ��� - �������̵��� �������.
	public void changeDept(String dept) {
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}


}
