package spring.service.test;

import spring.service.domain.MemberVO;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * FileName : MyBatisMemberTestApp.java
  * ㅇ SqlMapConfig.xml / mybatis-memberservice-mapping.xml
  * ㅇ My Framework 이용 QUERY ( SELECT ) TEST 
  */

public class MyBatisMemberTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		//==> SqlMapConfig.xml : MyBATIS Framework 의 핵심 환경설정화일 (MetaData)
		//==> mybatis-Memberservice-mapping.xml : SQL 를 갖는 설정화일 (MetaData) 
		
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>    SqlSession  객체 생성
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		//0.showAllMember
		System.out.println(":: 0. showAllMember(SELECT)  ? ");
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");						
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//==> Test용 MembermemberVO instance 생성
		//MembermemberVO(String id, String password, String name, String address)
		MemberVO memberVO = new MemberVO("555","555","Kate","LA");
		
		//1.registerMember
		Object obj = session.insert("MemberMapper.registerMember", memberVO);
		session.commit(); //이 부분 반드시 해줘야 한다....mvc에서는 생략가능.
		//iBatis와 다르게 insert문의 리턴타입은 insert된 row수를 반환한다.
		System.out.println(":: 1. registerMember(INSERT)  result ? "+obj); 						
		System.out.println("\n");
		
		
		//2.getMember
		String name = (String)session.selectOne("MemberMapper.getMember", memberVO);		
		System.out.println(":: 2. getMember(SELECT)  ? "+name); 						
		System.out.println("\n");
			
		
		//3.updateMember
		memberVO.setName("Sally");
		int updateResult = session.update("MemberMapper.updateMember", memberVO);
		session.commit(); //이부분 반드시 해줘야 한다.
		System.out.println(":: 3. updateMember(UPDATE) result ? "+updateResult);			
		System.out.println("\n");
		
			
		//4.getMember
		name = (String)session.selectOne("MemberMapper.getMember", memberVO);
		System.out.println(":: 4. getMember(SELECT)  ? "+name); 						
		System.out.println("\n");
		
			
		//5.deleteMember
		int deleteResult = session.delete("MemberMapper.deleteMember", memberVO.getId());
		session.commit(); //이 부분 반드시 해줘야 한다.
		System.out.println(":: 5. deleteMember(DELETE) result ? "+deleteResult);
		System.out.println("\n");
		
		
		//6.showAllMember 
		System.out.println(":: 6. showAllMember(SELECT)  ? ");
		list = session.selectList("MemberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		
	}//end of main
}//end of class
