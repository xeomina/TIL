package com.edu.test;

import com.edu.child.Student;
import com.edu.child.Teacher;

public class PersonTest1 {
	public static void main(String[] args) {
		Student stu = new Student("������", 28, "�Ż絿", 123);
		Teacher tea = new Teacher("��ȣ��", 45, "�Ÿ���", "Java");
		
		System.out.println(stu.getDetails());
		System.out.println(tea.getDetails());
		
		System.out.println("==================");
		
		System.out.println(stu);	//���� ������� �� ����
		System.out.println(tea);
		
		
	}
}
