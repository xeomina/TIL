package com.edu.cons;

//Programmer�� NoteBook�� ������ ���踦 ���� -> Has A Relation
/* 
 * 1. �ʵ� ������ �߰��ϰ��� �ϴ� Ŭ������ ����
 * 2. �߰��� �ʵ带 �����ϴ� ��θ� �ϳ� ����
 *    ������ Ȥ�� setter()
 */
public class Programmer {
	String name;
	String address;
	String mainSkill;
	int salary;
	
	NoteBook noteBook;	////1. �ʵ� ������ �߰��ϰ��� �ϴ� Ŭ������ ����
	
	public Programmer(){}
	public Programmer(String name,String address,String mainSkill, int salary ) {
		this.name = name;
		this.address = address;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}
	
	//2. �߰��� �ʵ带 �����ϴ� ��θ� �ϳ� ���� - setter()
	public void buyNoteBook(NoteBook noteBook) {
		this.noteBook = noteBook;
	}
	
	//������ ��Ʈ���� �ٽ� �޾ƿ��� ��Ʈ �߰�
	public NoteBook getNoteBook() {
		return noteBook;		
	}
	
	public String getProgrammerInfo() {
		return name+"\t"+address+"\t"+mainSkill+"\t"+salary;
	}
	
	public void setProgrammerInfo(String name,String address,String mainSkill, int salary ) {
		this.name = name;
		this.address = address;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}

	
	public int getAnnualSalary() {
		return salary*12;
	}
	
	public String getMainSkill() {
		return mainSkill;
	}
}
