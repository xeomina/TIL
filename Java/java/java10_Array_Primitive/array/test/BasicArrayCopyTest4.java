package com.edu.array.test;
/*
 * �迭�� Resizing �ȵ�
 * �̹� ���� �迭 ��ü ����� �����ϰ� �Ǹ� ���ο� ��ü�� ������
 * �ѹ� �迭�� ���鶧 ����� �˳��� !
 *  
 * ��� �ٸ� ����� ���� �迭�� ������ �����ϴ� ���� ����
 * System.arraycopy()
 */
public class BasicArrayCopyTest4 {
	public static void main(String[] args) {
		int[] target = {1,2,3,4,5,6};
        
		//1.�⺻ for
		for(int i=0; i<target.length;i++) System.out.println(target[i]+ " ");
        
		//2.for in(for each)
		for(int i : target) System.out.println(i+" ");
		
		target = new int[10];	//3.�迭 ������ �ø���
		target[6]=11;
		target[7]=22;
		target[8]=33;
		target[9]=44;
		
		System.out.println("=======================");
		
		for(int i : target) System.out.print(i+" ");
	}
}












