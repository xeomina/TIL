package com.edu.condition.test;

import java.util.Scanner;

public class GradeIfTest1 {

	public static void main(String[] args) {
//		int grade = 88; //local V - �����Ͻ� ���� �Ҵ� -> ����÷� ��������� ��
		
		System.out.println("���� �Է� : ");
		Scanner	sc = new Scanner(System.in); 
		int grade = sc.nextInt();				
		
		
//		if(grade >= 90 & grade <= 100) {
//			System.out.println("A grade");
//		}else if(grade >= 80 & grade < 90) {
//			System.out.println("B grade");
//		}else if(grade >= 70 & grade < 80) {
//			System.out.println("C grade");
//		}else {
//			System.out.println("Try Again");
//		}
		
		
		if(grade >= 90 & grade <=100) 
			System.out.println("A grade");			
		else if(grade >=80 & grade < 90) 
			System.out.println("B grade");
		else if(grade >=70 & grade < 80)
			System.out.println("C grade");
		else 
			System.out.println("Try Again");	// {} ��������

		
	}	//main
}	//class
