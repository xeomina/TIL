package com.edu.test;

import com.edu.child.Student;
import com.edu.child.Teacher;

public class PersonTest1 {
	public static void main(String[] args) {
		Student stu = new Student("아이유", 28, "신사동", 123);
		Teacher tea = new Teacher("강호동", 45, "신림동", "Java");
		
		System.out.println(stu.getDetails());
		System.out.println(tea.getDetails());
		
		System.out.println("==================");
		
		System.out.println(stu);	//같은 결과지만 더 간결
		System.out.println(tea);
		
		
	}
}
