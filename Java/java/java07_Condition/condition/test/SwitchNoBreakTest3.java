package com.edu.condition.test;
/*
 * �տ��� ��� switch���� 
 * break Ű���带 ��� Ȱ���ϴ��Ŀ� ����
 * �پ��� ����� ������ �� �ִ�
 * 
 * 1) static�� ����� �����ϴ� ���
 * 2) break Ű���� ����
 */

/*
 * Math m = new Math();
 * m.random();
 * 
 * random()�� static�� ������ ������� �ֱ� ������
 * ��ü������ �ʿ䰡 ���� - �̸� �޸� �ö� �ִ�
 * 
 * Math.random(); ����!
 * 
 */

public class SwitchNoBreakTest3 {

	public static void main(String[] args) {
//		double time = Math.random();	//0~1������ �Ǽ��� �����ϰ� ����
		int time = (int)(Math.random()*4) +8;	//8~11 ������ ������ �����ϰ� ����
		System.out.println("����ð�: " +time+"��");
		
		switch(time) {
		case 8:
			System.out.println("��� �غ�");
//			break;
		case 9:
			System.out.println("ȸ�� ����");
//			break;
		case 10:
			System.out.println("���� ����");
//			break;
		case 11:
			System.out.println("�ܱ� �غ�");
//			break;
			
		}
	}
}
