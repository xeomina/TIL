package com.edu.datatype;
/*
 * 클래스를 여러개 한꺼번에 작성할때는
 * - main method를 가지는 클래스 앞에 public을 붙인다. (다른 클래스 앞에는 붙이면 안됨)
 * - public이 붙은 클래스 이름으로 파일명을 지정한다.
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
	//String + NonString 붙여지면 String으로 Converting !!!
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
	
	//2. 필드에 값 할당(setWhiteBoard) / 할당된 값 받아오는 (get)
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
		//1. wb라는 이름으로 WhiteBoard 객체 생성
		WhiteBoard wb = new WhiteBoard();
		
		//2. 필드 초기화
		Date madeDate = new Date();
		madeDate.setDate(2021, 10, 20);	
		
		wb.setWhiteBoard('W', 100, false, madeDate);
		
		//3. 필드값을 콘솔로 출력
	
		System.out.println(wb.getWhiteBoard());

	}

}
