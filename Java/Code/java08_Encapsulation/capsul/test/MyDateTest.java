package com.edu.capsul.test;

import java.util.Scanner;

/* Encapsulation
 * 1.Field ����  private���� �����Ͽ� �ܺ�(�ٸ� Ŭ����)�� ���� ���� ������ ���´�
 * 2.set() / get() method�� public���� �����Ͽ� Field ���� ����
 * 3.��η� Ȱ��Ǵ� method������ ���� ��ȣ�� ���� �ʿ��� ����� ���� ������ �ִ´�
 * 
 */
import com.edu.capsul.MyDate;

public class MyDateTest {
	public static void main(String[] args) {
		
		MyDate md = new MyDate();

		Scanner	sc = new Scanner(System.in); 
		
		System.out.println("�� �Է� : ");
		md.setMonth(sc.nextInt());			
		System.out.println("�� �Է� : ");
		md.setDay(sc.nextInt());
		
		//��µ� �� 0�� ��µ��� �ʵ��� ����
		if(md.getMonth()==0 | md.getDay()==0) 
//			System.out.println("0�� ���ԵǹǷ� ��¥�� ��µ��� �ʽ��ϴ�");
			System.exit(0);
		else
			System.out.println("������ ��¥: "+md.getMonth()+"��" + md.getDay()+"��");
			
	}

}
