package com.edu.capsul;

//오늘 날짜 정보를 가지고 있는 클래스
public class MyDate {
	
	// private: 같은 클래스에서만 접근 가능, 다른 클래스에서 접근 불가
	private int month;
	private int day;
	
	// public:  set() / get() method로 소통
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		//invalid한 값이 전달되더라도 필드 초기화 직전에 필터링 가능
		//month에 해당하는 값이 1~12일 경우에만 필드 초기화 되도록 한다
		if(1<=month & month<=12) {
		this.month = month;
		}else {
			System.out.println("1~12월 사이를 입력하세요");
		}
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {		
		
		switch(month) {			
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if(1<=day & day<=31) {
				this.day = day;
				}else {
					System.out.println("1~31일 사이를 입력하세요");
				}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(1<=day & day<=30) {
				this.day = day;
				}else {
					System.out.println("1~30일 사이를 입력하세요");
				}
			break;
		case 2:
			if(1<=day & day<=28) {
				this.day = day;
				}else {
					System.out.println("1~28일 사이를 입력하세요");
				}
			break;
			
			}	//switch
	}
}
