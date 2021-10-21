package com.edu.test;

class Operator{
	public boolean test1() {
		System.out.println("test1()...calling");
		return true;
	}
	
	public boolean test2() {
		System.out.println("test2()...calling");
		return false;
	}
}

public class OperatorTest1 {

	public static void main(String[] args) {
		//Local Variable : method ���� �ȿ����� ��� ����
		int i = 10;
		int j = 8;
		
		System.out.println(i == j);		//false
		System.out.println(i != j);		//true
		
		//%: Ư�� ���� � ������ ������ ������
		System.out.println(i % j);		//2
		
		//++: 1�� ���� ������Ű�� ������
		int x = 10; 					//local V �ʱ�ȭ (����+�Ҵ�)
		System.out.println(x++);		//10
		System.out.println(x);			//11 -> 1�� ���߿� ����
		
		int y = 10; 					
		System.out.println(++y);		//11 -> 1�� ���� ����
		System.out.println(y);			//11 
		
		//--: 1�� ���� ���ҽ�Ű�� ������
		int z = 10; 					
		System.out.println(z--);		//10
		System.out.println(z);			//9 -> 1�� ���߿� ����
		
	}
//i = 100; -> error. local V�̱� ������ �ݵ�� main(){} �ȿ����� ���
}