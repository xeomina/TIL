package com.edu.loop.test;
/*
 * Loop�� - �ݺ���
 *  
 * break:
 * 
 * continue:
 * �Ʒ����� �������� ���� ��� �ݺ��ض�
 * 
 */
public class ContinueTest2 {

	public static void main(String[] args) {
		int total = 0;
		
		for(int num =1; num<=100; num++) {
			if(num % 2 != 0) continue;
			total += num;
		}	//for
		
		System.out.println("1���� 10���� Ȧ���� �� : "+total);	//2550

	}

}
