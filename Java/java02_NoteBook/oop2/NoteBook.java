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
	
	// method 추가 -> 필드에 값을 할당받을 수 있는 기능을 하나 추가한다
	
/*	public void setNoteBookInfo(String bn, int p, int ser) {
		//~Test에서 기능 호출할 때 받은 인자값(SAMSUNG, LG)으로 다시 필드에 할당
		// -> 필드초기화(Field Initialization) !!!
		brandName=bn;
		price=p;
		serialNumber=ser;
		*/
	public void setNoteBookInfo(String brandName, int price, int serialNumber){
		// this: 필드와 로컬변수의 이름이 같을 때 구분하기 위해서 필드 앞에 붙여준다
		this.brandName=brandName;
		this.price=price;
		this.serialNumber=serialNumber;
	}
}

 
