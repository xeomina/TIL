package com.edu.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.edu.spring.domain.MyProduct;

public class MyBatisUnitTestApp {
	public static void main(String[] args) throws Exception{
		Reader r=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		SqlSession session = factory.openSession();
		
		System.out.println("============== 1. addProduct =====================");
		
		MyProduct vo = new MyProduct("초코파이","오리온",1000);
		
		/*
		 * int result = session.insert("ns.sql.MyProductMapper.addProduct", vo);	//namespace.id
		 * session.commit(); //단위테스트...commit 반드시!
		 * System.out.println(result+"개의 상품이 추가되었습니다.");
		 */
		
		System.out.println("============== 2. findProducts =====================");
		List<MyProduct> list = session.selectList("ns.sql.MyProductMapper.findProducts");
		for(MyProduct pro : list) System.out.println(pro);
      
		System.out.println("============== 3. findProductByName =====================");
		List<MyProduct> list2 = session.selectList("ns.sql.MyProductMapper.findProductByName","세탁기");
     	for(MyProduct pro : list2) System.out.println(pro);


		
	}
}
