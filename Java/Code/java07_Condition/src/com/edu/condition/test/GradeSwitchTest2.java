package com.edu.condition.test;

import java.util.Scanner;

public class GradeSwitchTest2 {

	public static void main(String[] args) {
		System.out.println("���� �Է� : ");
		Scanner	sc = new Scanner(System.in); 
		int grade = sc.nextInt();				
		
		//�پ��� ������ ���� ����� �ڵ带 �ۼ�
		switch(grade) {				// �Ǽ��� x
			case 95:
			case 90:
				System.out.println("A grade");		
				break;
			case 80:
			case 85:
				System.out.println("B grade");		
				break;
			case 70:
			case 75:
				System.out.println("C grade");		
				break;
			default:
				System.out.println("Try Again");
				
		} //switch

	} //main
} //class
