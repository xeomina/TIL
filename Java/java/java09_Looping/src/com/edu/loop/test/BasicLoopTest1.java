package com.edu.loop.test;
/*
 * Loop�� - �ݺ���
 * 
 * for, while
 * 
 * ���� ������ �����ϴ� ���ȿ�
 * �ڵ����� �ݺ������� �����ϴ� ����
 * 
 * 1. for��
 * 
 * <Syntax>
 * for(�ʱ�ġ; ���ǹ�; ����ġ)
 * for(initialization;boolean expression;update){}
 */

public class BasicLoopTest1 {

	public static void main(String[] args) {
		System.out.println("=========for=========");
		
		for(int i=0; i<10; i++) {
			System.out.println("for 1 : "+i); // ++i: 0���� ������ �Ȱ���
		}

		for(int i=1, j=1; i<10 &j<10; i++) {
			System.out.println("for 2 : "+i);	
		}
		
/* 2. while ��
 * 
 * <Syntax>
 * �ʱ�ȭ
 * while (���ǹ�) {...}
 * 
 * initialization
 * while(boolean expression;){}
 */
		
		System.out.println("=========while=========");
		
		int i = 10;
		while (i>0) {
		    System.out.println("while 1 : "+i);
		    i--;
	    }
	}
}











