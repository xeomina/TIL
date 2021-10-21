package com.edu.oop;
/*
 * 필드선언 위치 :
 * 클래스 선언 바로 아래 + method 영역 바깥
 * 
 * method 정의(worker method) :
 * 리턴타입 + method 이름(인자값 0 ~) {		// method 선언부
 * 		method가 어떤 일을 하는지 기술		// method 구현부
 * }
 */

public class NoteBook {
	public String brandName;
	public int price;
	// filed 추가
	public int serialNumber;
	
	public void printInfo() {
		System.out.println("Brand = " + brandName + ", Price = " + price +", Number = " + serialNumber);
	}
	// method 추가 -> return type이 void가 아닌 기능 추가
	public String getBrandName() {
		// 리턴되는 위치는 calling / worker 왔다갔다
		return "NoteBook brandName = " + brandName;
		// 호출한 곳으로 brandName이 리턴 test 클래스의 26번째 라인
	}
}

 
