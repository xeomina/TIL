package com.edu.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.edu.mybatis.vo.MySawon;

/*
 * SELECT문을 실행시키는 Test
 */

public class MySawonTestApp02 {

	public static void main(String[] args) throws Exception{
		//1.핵심이 되는 설정 문서를 읽어들인다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");	//ibatis: mybatis의 이전 버전
		
		//2.MyBatis 라이브러리...순서는 천천히 외우면 된다...
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);	//SqlSessionFactory 생성
		
		//3.Session 여기에 쿼리문 실행하는 기능이 다 들어있다...
		SqlSession session = factory.openSession();
		
		List<MySawon> list = session.selectList("sawonMapper.sawonList");	 //"namespace.id"
		for(MySawon vo : list) {
			System.out.println(vo);
		}	//CLOSE는 DML일때 -> SELECT는 변경사항이 없다
	}



/*
 * 
 *					 SqlSessionFactory -> SqlSession
 * 							  SqlSession
 * 
 * 	sql query												execute method
 * INSERT INTO ~			------------------>			insert("namespace.id", vo);	
 * DELETE FROM ~			------------------>			delete("namespace.id", pk);					
 * UPDATE tanble ~			------------------>			update("namespace.id", vo);	
 * ----------------------------------------------------------------------------------------------
 * SELECT * FROM			------------------>			List<T> selectlist("namespace.id");
 * 							------------------>			List<T> selectlist("namespace.id","서울");
 * SELECT * FROM WHERE ~	------------------>			Object selectone("namespace.id",pk);
 * 
 * 
 */









}


