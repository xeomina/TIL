package com.edu.collection.test;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest1 {
	public static void main(String[] args) {
		Properties p=System.getProperties();		//����Ÿ�� Properties
		
		Enumeration e=p.propertyNames();			//propertyNames : key �̾Ƴ�
		while(e.hasMoreElements()) {				//hasMoreElements : Element�ִ� ���� 
			String name = (String)e.nextElement();	//nextElement : ������ �̾ƶ� - String
			String value = p.getProperty(name);		//value ����
			System.out.println(name+"=========="+value);
		}//while
	}//main
}//class
