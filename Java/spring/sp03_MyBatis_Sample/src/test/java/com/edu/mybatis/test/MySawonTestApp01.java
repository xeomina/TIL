package com.edu.mybatis.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.edu.mybatis.vo.MySawon;

/*
 * MyBatis 프레임워크의 가장 핵심이 되는 설정 문서를 생성함
 * SqlMapConfig.xml
 * 
 * 이제 MyBatis 프레임워크에서 제공하는 라이브러리 클래스를 이용해서
 * SqlMapConfig.xml을 읽어들이고 
 * 쿼리문을 동작시킬 것
 */

public class MySawonTestApp01 {

	public static void main(String[] args) throws Exception{
		//1.화면의 폼을 통해서 vo를 생성한다는 가정으로...
		MySawon vo = new MySawon();
//		vo.setId("hahash");
//		vo.setPwd("1234");
//		vo.setName("하야시");
//		vo.setAge(66);
		
		vo.setId("dorosh");	//unique 때문에 바꿔줘야 함 
		vo.setPwd("1234");
		vo.setName("도로시");
		vo.setAge(22);
		
		//2.핵심이 되는 설정 문서를 읽어들인다.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");	//ibatis: mybatis의 이전 버전
		
		//3.MyBatis 라이브러리...순서는 천천히 외우면 된다...
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);	//SqlSessionFactory 생성
		
		//Session 여기에 쿼리문 실행하는 기능이 다 들어있다...
		SqlSession session = factory.openSession();
		
		session.insert("sawonMapper.sawonAdd",vo); //vo: parameterType ??
		session.commit(); //mybatis만 돌릴때
		session.close();
		
		System.out.println(vo.getName()+"님 회원등록 성공 !!");

	}

}
