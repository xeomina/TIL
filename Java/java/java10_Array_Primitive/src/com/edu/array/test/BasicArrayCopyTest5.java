package com.edu.array.test;
/*
 * System.arraycopy()
 */
public class BasicArrayCopyTest5 {
	public static void main(String[] args) {
		
		int[ ] target = {1,2,3,4,5,6}; //6
		int[ ] source = {10,9,8,7,6,5,4,3,2,1}; //10

		
		//System.arraycopy();
        //source�� 2�� ���� target�� 0�� ������  target.length��ŭ ����
		System.arraycopy(source, 2, target, 0, target.length); 
		for(int i : target) System.out.print(i+" ");
		
	}
}



















