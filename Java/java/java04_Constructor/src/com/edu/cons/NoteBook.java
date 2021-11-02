package com.edu.cons;

public class NoteBook {
	public String brandName;
	public int price;
	public int serialNumber;
	
	//»ý¼ºÀÚ
	public NoteBook(){}
	public NoteBook(String brandName, int price, int serialNumber){
		this.brandName=brandName;
		this.price=price;
		this.serialNumber=serialNumber;
	}
	
	
	public void printInfo() {
		System.out.println("Brand = " + brandName + ", Price = " + price +", Number = " + serialNumber);
	}
	
	public String getBrandName() {
		return "NoteBook brandName = " + brandName;
	}
	
	public void setNoteBookInfo(String brandName, int price, int serialNumber){
		this.brandName=brandName;
		this.price=price;
		this.serialNumber=serialNumber;
	}
}

 
