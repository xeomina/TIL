package com.edu.datatype;
/*
 * Ŭ������ ������ �Ѳ����� �ۼ��Ҷ���
 * - main method�� ������ Ŭ���� �տ� public�� ���δ�. (�ٸ� Ŭ���� �տ��� ���̸� �ȵ�)
 * - public�� ���� Ŭ���� �̸����� ���ϸ��� �����Ѵ�.
 */

class Date{
	int year;
	int month;
	int day;
	
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//String + NonString �ٿ����� String���� Converting !!!
	public String getDate() {
		return year+"-"+month+"-"+day;
	}
}


class WhiteBoard{
	// company, color, material, price, scratch, madeDate
	String company;
	char color;
	String material;
//	float price;
	double price;
	boolean scratch;
	Date madeDate;
	
	//2. �ʵ忡 �� �Ҵ�(setWhiteBoard) / �Ҵ�� �� �޾ƿ��� (get)
	public void setWhiteBoard(char color, double price, boolean scratch, Date madeDate) {
		this.color = color;
		this.price = price;
		this.scratch = scratch;
		this.madeDate = madeDate;
	}
	
	public String getWhiteBoard() {
		return color + "," + price + "," + scratch +"," + madeDate.getDate();		
	}
}

public class WhiteBoardTest {

	public static void main(String[] args) {
		//1. wb��� �̸����� WhiteBoard ��ü ����
		WhiteBoard wb = new WhiteBoard();
		
		//2. �ʵ� �ʱ�ȭ
		Date madeDate = new Date();
		madeDate.setDate(2021, 10, 20);	
		
		wb.setWhiteBoard('W', 100, false, madeDate);
		
		//3. �ʵ尪�� �ַܼ� ���
	
		System.out.println(wb.getWhiteBoard());

	}

}
