package com.edu.test;

import java.util.Scanner;

/*
 * Scanner Ŭ����
 * ����� �ڵ忡 ���� ���� �Է¹޴� ���� �ƴ϶�
 * new Account(10000);
 * 
 * ����������� ���� �Է¹��� �� �ֵ��� �� �� �ʿ��� Ŭ������ Scanner
 */

public class ScannerTest2 {

	public static void main(String[] args) {
		
		System.out.println("�Է� : ");
		
		//1. Scanner ��ü�� ���� -> �޸𸮿� �ø���
		Scanner	sc = new Scanner(System.in); //System.in: Ű����κ��� �Է� ����
		
		//2. Scanner�� ����� �̿��ؼ� ���� �޾ƿ�
		int i = sc.nextInt();		//����				
		int j = sc.nextInt();
		String name = sc.next();	//����
		
		System.out.println("���ڰ� : " + i + "," + j);
		System.out.println("�̸� : " + name);
		

	}

}
