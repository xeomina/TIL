package com.edu.oop;
/*
 * �ʵ弱�� ��ġ :
 * Ŭ���� ���� �ٷ� �Ʒ� + method ���� �ٱ�
 * 
 * method ����(worker method) :
 * ����Ÿ�� + method �̸�(���ڰ� 0 ~) {		// method �����
 * 		method�� � ���� �ϴ��� ���		// method ������
 * }
 */

public class NoteBook {
	public String brandName;
	public int price;
	// filed �߰�
	public int serialNumber;
	
	public void printInfo() {
		System.out.println("Brand = " + brandName + ", Price = " + price +", Number = " + serialNumber);
	}
	// method �߰� -> return type�� void�� �ƴ� ��� �߰�
	public String getBrandName() {
		// ���ϵǴ� ��ġ�� calling / worker �Դٰ���
		return "NoteBook brandName = " + brandName;
		// ȣ���� ������ brandName�� ���� test Ŭ������ 26��° ����
	}
}

 
