package com.edu.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSessionFactory 하나 받아오는 로직을 여기에 작성
 */


public class FactoryService {
	//생성자보다 먼저 가동되는 블락?...main보다 먼저 작동하는 블락?
	//static initialization block
	private static SqlSessionFactory factory;
	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);	
			
			
		}catch(Exception e) {
			
		}
	}//
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}

}
