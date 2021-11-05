package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

/*
 * Heterogeneous Collection <-> Homogeneous Collection
 * 
 * ���� �ٸ� Ÿ���� ������ �̱������� ����ü
 * -> �̱������� �ڽ� Ŭ�������� �θ�Ÿ������ �����ϰ� ����
 * 
 * �迭�� �������� - SameDataType 
 * -> ���⼭�� Manager/Engineer/Secretary�� ���� �ٸ� Ŭ���� Ÿ��
 * -> Employee ���
 * 
 * �׷��� �������� ������ x -> Heterogeneous Collection
 */

public class HeterogeneousTest2 {

	public static void main(String[] args) {
		//�̱������� �پ��� �ڽ�Ŭ�������� �����ϰ� �����ϱ� ���ؼ��� �θ�Ÿ���� []�� ��ƾ�
		Employee[]emps= {
				new Manager("James", new MyDate(1990,1,1), 30000.0, "IT"),
				new Engineer("Tom", new MyDate(1980,1,1), 400000.0, "AI", 1000),
				new Secretary("Jane", new MyDate(1985,1,1), 350000.0, "Tom"),
				new Manager("Peter", new MyDate(1982,2,11), 50000.0, "Python"),
				new Manager("Juliet", new MyDate(1992,3,1), 65000.0, "Education")
		};
		
		//�ڽĵ��� �θ�Ÿ�� container�� ��� �� �ִ�
//		for(Employee e : emps) System.out.println(e.getDetails());
		
		System.out.println("=========��� ����ε��� ���� ���=========");
		
		//emps�߿��� ���������� ������ �ڽİ�ü Ÿ���� �˾ƾ��� �ʿ䰡 �ִ�
		//�θ�Ÿ������ ������ ��ü�� Manager, Engineer, Secretary ���� �˾ƾ��Ѵ�
		//�̷� �� ����ϴ� Ű���尡 instanceof Ű����
		
		for(Employee e : emps) {
			//eŸ������ ������ ��üŸ���� Engineer�� �´ٸ�
			if(e instanceof Engineer) {
				System.out.println("Information Engineer: "+e.getDetails());
				System.out.println("AnnualSalary: "+((e.getSalary())*12+((Engineer) e).getBonus()));	//int���� ���� ���� �� String�� ���� - Non String�� String ������ String���� ����
				System.out.println("------------------------------------");
			}
			else if (e instanceof Manager) {
				System.out.println("Information Manager: "+e.getDetails());
				((Manager) e).changeDept("������");
				System.out.println("Change Dept: "+((Manager) e).getDetails());
				System.out.println("------------------------------------");
			}
			else {
			System.out.println("Information: "+e.getDetails());
			System.out.println("AnnualSalary: "+e.getSalary()*12);
			System.out.println("------------------------------------");
		}
		}
		
		
	} //main

} //class
