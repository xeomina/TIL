package com.edu.oop2;

public class NoteBook {
	public String brandName;
	public int price;
	public int serialNumber;
	
	public void printInfo() {
		System.out.println("Brand = " + brandName + ", Price = " + price +", Number = " + serialNumber);
	}
	
	public String getBrandName() {
		return "NoteBook brandName = " + brandName;
	}
	
	// method �߰� -> �ʵ忡 ���� �Ҵ���� �� �ִ� ����� �ϳ� �߰��Ѵ�
	
/*	public void setNoteBookInfo(String bn, int p, int ser) {
		//~Test���� ��� ȣ���� �� ���� ���ڰ�(SAMSUNG, LG)���� �ٽ� �ʵ忡 �Ҵ�
		// -> �ʵ��ʱ�ȭ(Field Initialization) !!!
		brandName=bn;
		price=p;
		serialNumber=ser;
		*/
	public void setNoteBookInfo(String brandName, int price, int serialNumber){
		// this: �ʵ�� ���ú����� �̸��� ���� �� �����ϱ� ���ؼ� �ʵ� �տ� �ٿ��ش�
		this.brandName=brandName;
		this.price=price;
		this.serialNumber=serialNumber;
	}
}

 
