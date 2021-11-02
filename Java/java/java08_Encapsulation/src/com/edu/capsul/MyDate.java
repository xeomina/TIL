package com.edu.capsul;

//���� ��¥ ������ ������ �ִ� Ŭ����
public class MyDate {
	
	// private: ���� Ŭ���������� ���� ����, �ٸ� Ŭ�������� ���� �Ұ�
	private int month;
	private int day;
	
	// public:  set() / get() method�� ����
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		//invalid�� ���� ���޵Ǵ��� �ʵ� �ʱ�ȭ ������ ���͸� ����
		//month�� �ش��ϴ� ���� 1~12�� ��쿡�� �ʵ� �ʱ�ȭ �ǵ��� �Ѵ�
		if(1<=month & month<=12) {
		this.month = month;
		}else {
			System.out.println("1~12�� ���̸� �Է��ϼ���");
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
					System.out.println("1~31�� ���̸� �Է��ϼ���");
				}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if(1<=day & day<=30) {
				this.day = day;
				}else {
					System.out.println("1~30�� ���̸� �Է��ϼ���");
				}
			break;
		case 2:
			if(1<=day & day<=28) {
				this.day = day;
				}else {
					System.out.println("1~28�� ���̸� �Է��ϼ���");
				}
			break;
			
			}	//switch
	}
}
