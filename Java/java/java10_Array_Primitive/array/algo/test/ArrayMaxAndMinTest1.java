package com.edu.array.algo.test;

public class ArrayMaxAndMinTest1 {

	public static void main(String[] args) {
		int[] scores = {79,88,91,44,100,55,95};
		
		//scores �ȿ� ����ִ� ���� �߿��� ���� ���� ������ ���� ������ ������ ã�Ƽ� ���
		//���� ���� ���� -> MAX | ���� ���� ���� -> MIN
		
		int min = scores[0]; //�ʱ�ȭ�� ���� ù��°�� �������� ��� ���� ����. 
		int max = scores[0];
		
		//for���� if���� ����ؼ� ������ �ۼ�.
		for(int i=0; i< scores.length; i++) {
			if(scores[i] < min)min =scores[i];
			if(scores[i] > max)max =scores[i];
		}
		System.out.println("�ִ�: "+max);
		System.out.println("�ּڰ�: "+min);
	}
}