package com.edu.collection.test;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest1 {
	public static void main(String[] args) {
		Properties p=System.getProperties();		//리턴타입 Properties
		
		Enumeration e=p.propertyNames();			//propertyNames : key 뽑아냄
		while(e.hasMoreElements()) {				//hasMoreElements : Element있니 없니 
			String name = (String)e.nextElement();	//nextElement : 있으면 뽑아라 - String
			String value = p.getProperty(name);		//value 리턴
			System.out.println(name+"=========="+value);
		}//while
	}//main
}//class
