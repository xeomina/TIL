package com.edu.array.test;

/*
 * Array
 * ���� ����Ÿ Ÿ���� ������ ���� �ٸ� ������
 * �ϳ��� ������ ó���ϴ� ��
 * 
 * Array ����, ����, �ʱ�ȭ
 * 
 * 1. ����               
 * int[ ] arr;    
 * 2. ����(�ݵ�� ����� ���) 
 * arr = new int[3];
 * 3. �ʱ�ȭ
 * arr[0]=11; arr[1] = 22; arr[2] = 33;
 * 
 */

public class BasicArrayTest1 {
	public static void main(String[] args) {
		//1. �迭����
		int[] arr;
		
		//2. �迭����
		arr = new int[3];
		
		//3. �ʱ�ȭ
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		System.out.println("�迭 ������ ĭ�� ����ִ� ��: " );
        
//        for(int i=0; i<3; i++)
            
		for(int i=0; i< arr.length; i++) {		////length: �迭�� ������ ����
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n�迭 ��ü�� �����ϴ� �ּҰ�: " + arr);	
	}
}













