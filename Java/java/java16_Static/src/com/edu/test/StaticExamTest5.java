package com.edu.test;
/*
 * Sigletone Pattern �ڵ� �ۼ� ��� �ܰ�
 * �ϳ��� Ŭ�����κ��� ���� �ϳ��� ��ü���� �����ϴ� ����
 * 
 * 1. private static���� �ش� Ŭ�������� ��ü�� �ϴ� �ϳ� ����
 * 2. �ٸ� ������ ��ü ������ ���ϵ��� ������ �տ� private
 * 3. �ϳ� �������� ��ü�� �������⼭ ������ �� �� �ֵ��� public static���� �����ϴ� ����� �����
 */

class Factory{
	private static Factory factory = new Factory();			//1 step
	private Factory() {
		System.out.println("Factory Only One Creating");	//2 step
	}
	public static Factory getInstance() {							//3 step
		return factory;
	}
}

public class StaticExamTest5 {
	public static void main(String[] args) {
		System.out.println("Singletone Pattern");
		
//		Factory factory1 = new Factory();
		
		Factory factory1 = Factory.getInstance();
		Factory factory2 = Factory.getInstance();
		Factory factory3 = Factory.getInstance();
		
		//getInstance�� ������ ȣ���ؼ� Factory��ü ������ ����
		//�̶� factory1,2,3�� ���� �ٸ� ��ü�� �ƴ��� ��� Ȯ��?
		System.out.println(factory1);
		System.out.println(factory2);
		System.out.println(factory3);	//�ּҰ� �����ϹǷ� �� ���� ��ü!
		

	}//main

}//class
