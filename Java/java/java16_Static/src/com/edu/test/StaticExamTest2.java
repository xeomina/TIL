package com.edu.test;

/* 
 * 4. static한 멤버는 생성된 객체들이 다 공유한다
 */

class Car{
	int serialNumber;		//field
	static int counter;		//static V - local이 아니기 때문에 기본값 0
	
	Car(){
		counter++;	//1,2,3,4,...
		serialNumber = counter;
	}
	
}

public class StaticExamTest2 {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("===========Field Serial Number===========");
		System.out.println(car1.serialNumber);	//1
		System.out.println(car2.serialNumber);	//2
		System.out.println(car3.serialNumber);	//3
		
		System.out.println("===========Static Counter===========");
		System.out.println(Car.counter);		//3
		System.out.println(car1.counter);		//3
		System.out.println(car2.counter);		//3
		System.out.println(car3.counter);		//3

	}

}
