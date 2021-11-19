package com.edu.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.edu.mybatis.vo.MySawon;

/*
 * SqlSessionFactory 생성부분과
 * SqlSession 반환받아서 로직 호출하는 부분을 나눠서 작성...
 */

public class MySawonTestApp03 {

	public static void main(String[] args) throws Exception{
		//설정 문서를 읽어들여서 SqlSessionFactory를 생성하는 로직을...FactoryService에서 받아온다
		SqlSessionFactory factory = FactoryService.getFactory();

		//Session 여기에 쿼리문 실행하는 기능이 다 들어있다...
		SqlSession session = factory.openSession();
		
		List<MySawon> list = session.selectList("sawonMapper.sawonList");	 
		for(MySawon vo : list) {
			System.out.println(vo);
		}	//CLOSE는 DML일때 -> SELECT는 변경사항이 없다
	}
}


