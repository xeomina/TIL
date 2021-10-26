package com.edu.child;

import com.edu.parent.Person;

//상속에서 자식의 생성은 부모의 생성을 먼저 전제 조건으로 한다
//부모가 생성되어 있지 않고서는 결코 자식을 만들 수 없다
//부모와 자식 클래스는 서로 다른 클래스이지만, 메모리에서는 한몸으로 올라간다
public class Student extends Person{
	private int stuId;
	
	public Student(String name, int age, String address, int stuId) {
		super(name, age, address);	//기본 생성자가 아닌 명시적 생성자로 부모! (super(); - x)
		this.stuId = stuId;
	}
	
	/*
	 * 1.부모가 가진 메소드를 물려받는다
	 * 2.그걸 자식한테 맞게 고쳐쓴다
	 * -> 부모의 기능과 자식의 기능이 달라진다
	 * -> 자식에게 맞는 기능으로 다시 고쳐썼다
	 */

	@Override
	public String getDetails() {
		return super.getDetails()+","+stuId;
	}
	
	@Override
	public String toString() {
		return super.toString()+","+stuId;
	}
}
