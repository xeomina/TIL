package ibatis.services.user.impl;
/*
 * MyBatisFramework 단위에서의 최고 결정체인
 * SqlSession을 DI(Dependent Injection) 한다.
 * 
 * Annotation
 * Persistence Layer Bean :: Component - Interface 기반
 * 
 * @Component
 * 		|
 * Persistence Layer
 * @Repository
 * 
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ibatis.services.domain.User;
import ibatis.services.user.UserDAO;

//@Component
@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{
	
	@Autowired //sqlSession이 MyBatisUserDAOImpl13에 자동적으로 주입됨
	private SqlSession sqlSession;
	
	//Annotation해서 불필요
/*	public void setSqlSession(SqlSession sqlSession) {
		System.out.println(getClass().getName()+".setSqlSession() Calling..");
		this.sqlSession = sqlSession;
	}*/

	
	@Override
	public int addUser(User user) throws Exception {
		/*
		 * 1. Connection 얻어내고,,,
		 * 2. ps 리턴 받고...
		 * 3. 바인딩 
		 * 4. 쿼리문실행
		 * 5. close() :: commit() - DI연결할 떄는 오히려 빼줘야 한다...이미 되어져있음!
		 * --> 지금은 이런 코드가 모두 MyBatisFramework에서 이미 진행되었다.
		 */
		int result = sqlSession.insert("UserMapper10.addUser", user);
//		sqlSession.commit();	
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update("UserMapper10.updateUser", user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete("UserMapper10.removeUser", userId);
//		sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		
		return sqlSession.selectOne("UserMapper10.getUser",userId);
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		
		return sqlSession.selectList("UserMapper10.getUserList",user);
	}


}
