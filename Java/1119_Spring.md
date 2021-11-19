# 1119 Spring

## 1. MyBatis Framework

### 1) 순서

1. DB 테이블 만들기
   * mysawon
2. vo 클래스 만들기
   * MySawon.java
3. MyBatis 설정 문서 만들기
   * SqlMapConfig.xml
   * 모든걸 다 연결 (와이어링)
     * dbconn.properties : 파편적인 메타정보
     * sawib_mapping.xml : sql을 외부자원으로 모듈화
     * mysawon
     * MySawon.java
   * 정보가 어떤 정보냐에 따라 패키지 구분
     * resources<config
     * resources<sql
4. MyBatis 라이브러리
   * SqlSessionFactory -> SqlSession 리턴
   * 쿼리문을 실행하는 Function 가짐
     * insert("ns.id",vo);
     * delete("ns.id",num);
     * update("ns.id",vo);
     * selectOne("ns.id",num);
     * selectList("ns.id");



![image-20211119102225702](md-images/1119/image-20211119102225702.png)



### 2) 개념



* MyBATISTestApp / JDBCTestApp 를 통한 MyBATIS Framework 의 이해

  * SQL,커넥션,트랜잭선 를 메타데이타 캡술화였으며, 

    :: 참조 => SqlMapConfig.xml / mybatis-userservice-mapping.xml

  * JDBC철차 :  Connection => Statement => ResultSet

  * resource 관리 : close

  * query 수행 결과 비지니스객체(VO) 바인딩 JDBC API 를 사용하여 수행시 반복적으로 반드시 수행하는 일련의 과정을 수행함.

    :: 참조 =>List<User> list = session.selectList("User.getUserList");



* MyBATIS Framework 의 장점
  * 작고 간단하다 ( mybatis-3.2.8.jar / 약 400kb / 다른 라이브러리와 의존관계 없다. )
  * 기존 애플리케이션/테이터베이스 변경 불필요 (SQL Mapper(Data Mapper) =>SQL 과 비지니스 객체와의 바인딩)
  * 생산성 / 성능 / 작업의 분배 (소스코드와 SQL 의 분리)
  * 관심사의 분리 ( DBMS 에 독립적인 API제공 및 JDBC API가 아닌 비지니스 객체만 가지고 작업가능)



*  MyBATIS Framework은 JDBC 절차를 간결화한 lib이다 
  * JDBC를 절차 은익한 lib





## 2. MyBatis_Sample

> sp03_MyBatis ...이어서



### SqlSessionFactory / SqlSession

|       sql query       |               execute method               |
| :-------------------: | :----------------------------------------: |
|     INSERT INTO ~     |        insert("namespace.id", vo);         |
|     DELETE FROM ~     |        delete("namespace.id", pk);         |
|    UPDATE table ~     |        update("namespace.id", vo);         |
|     SELECT * FROM     |    List<T> selectlist("namespace.id");     |
|                       | List<T> selectlist("namespace.id","서울"); |
| SELECT * FROM WHERE ~ |    Object selectone("namespace.id",pk);    |



#### Command

* `mysawon` 테이블 확인

```
mysql> SELECT * FROM mysawon;
+-----+--------+------+--------+------+------------+
| num | id     | pwd  | name   | age  | hiredate   |
+-----+--------+------+--------+------+------------+
|   1 | hahash | 1234 | 하야시 |   66 | 2021-11-18 |
|   2 | dorosh | 1234 | 도로시 |   22 | 2021-11-18 |
+-----+--------+------+--------+------+------------+
2 rows in set (0.00 sec)
```



#### mysawon_mapping.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="sawonMapper">
	<insert id="sawonAdd" parameterType="mySawon"> <!-- mySawon: vo alias -->
		INSERT
		INTO mysawon (id,pwd,name,age,hiredate) <!-- num은 알아서 생성 - 절대 넣지 x -->
<!-- 폼으로부터 받은 값 -> VO 생성 - 비즈니스 로직에 인자값 -> 뽑아서 집어넣기
	-> VO에서 뽑을때 get -> MyBatis에서 getter는 #{} :: VALUE(#{id}) = mysawon.getId !! -->
		VALUE(#{id},#{pwd},#{name},#{age},curDate()) <!-- curDate() 자동으로 현재날짜 불러오는 함수 -->
		
	</insert>
	
	<select id="sawonList" resultType="mySawon"> <!-- param 필요없음, resultType : ArrayList -->
		SELECT
		num, id, name, age, hiredate
		FROM mysawon
		ORDER BY num DESC
	</select>

</mapper>
```



#### MySawonTestApp02.java

```java
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
}
```

```
MySawon [num=2, age=22, id=dorosh, pwd=null, name=도로시, hiredate=2021-11-18]
MySawon [num=1, age=66, id=hahash, pwd=null, name=하야시, hiredate=2021-11-18]
```



#### FactoryService.java

```java
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
}//
```



#### MySawonTestApp03.java

```java
package com.edu.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.edu.mybatis.vo.MySawon;

/*
 * SqlSessionFactory 생성 부분과
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
```

```
MySawon [num=2, age=22, id=dorosh, pwd=null, name=도로시, hiredate=2021-11-18]
MySawon [num=1, age=66, id=hahash, pwd=null, name=하야시, hiredate=2021-11-18]
```



## 3. MyBatis_User

#### Command

* source 불러오기

```
mysql> source C:\miracom_edu\util\spring\MyBatis_Template\1\users_mybatis.sql
ERROR 1051 (42S02): Unknown table 'scott.users'
Query OK, 0 rows affected (0.06 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 1 row affected (0.00 sec)

Query OK, 0 rows affected (0.00 sec)
```

```
mysql> desc users;
+-----------+-------------+------+-----+---------+-------+
| Field     | Type        | Null | Key | Default | Extra |
+-----------+-------------+------+-----+---------+-------+
| user_id   | varchar(10) | NO   | PRI | NULL    |       |
| user_name | varchar(10) | NO   |     | NULL    |       |
| password  | varchar(10) | NO   |     | NULL    |       |
| age       | int(3)      | YES  |     | NULL    |       |
| grade     | int(3)      | YES  |     | NULL    |       |
| reg_date  | date        | YES  |     | NULL    |       |
+-----------+-------------+------+-----+---------+-------+
6 rows in set (0.01 sec)
```



### 1) 

#### SqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
   <!-- 1. db정보를 가지고 온다. -->
   <properties resource="config/dbconn.properties"/>
   
   
   <!-- 2. vo를 alias.... -->
   <typeAliases>
      <typeAlias type="ibatis.services.domain.User" alias="user"/>
   </typeAliases>
   
   
   <!-- 3. jdbc 환경 구축 -->
   <environments default="mulcam">
      <environment id="mulcam" >
         <transactionManager type="JDBC"/>
         <dataSource type="UNPOOLED">
            <property name="driver" value="${jdbc.mysql.driver}"/>
            <property name="url" value="${jdbc.mysql.url}"/>
            <property name="username" value="${jdbc.mysql.username}"/>
            <property name="password" value="${jdbc.mysql.password}"/>
         
         </dataSource>
      </environment>
   </environments>
    
   <!--4. sql mapper -->
   <mappers>
      <mapper resource="sql/mybatis-userservice-mapping.xml"/>
   </mappers>
</configuration>
```



#### mybatis-userservice-mapping.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--	
	mybatis-userservice-mapping.xml : SQL 를 갖는 설정화일 (MetaData) 
	- MyBatis Framework 은 XML MetaData를 사용 SQL구문을 관리하며,
	  (SQL은 xml 을 통해 적절히 캡슐화 되어 애플리케이선 의 외부로 분리함)
	- SQL문의 입력(?) / 출력(?)을 매핑한다.  <== 아래의 select element 참조
 -->
 
<!-- SQL definition -->
<mapper namespace="UserMapper">
	<!-- Application에서 User.getUserList id로 아래의 SQL을 참조 할 수 있다. -->
	<!-- 입력(?) / 출력(?) 관리의 이해
	 	- 아래의 query 수행 후 결과 resultType attribute에 선언된 UserVO 객체 Field(property)에 자동연결(?,자동 바인딩)
	 	- SQL/Query 의 별칭(Alias)와 UserVO객체의 Field 의 변수이름이 동일한 것 확인. -->
 	
	<!-- id=getUserList -->
	<!-- SELECT에서 컬럼명과 필드명이 다르면 값을 못받아온다...Alias 사용해서 문제 해결 
	select 절에서의 컬럼이름은 vo alias 이름과 상호 호환된다.
	user_id ====   setUserId() | getUserId()     X
	userId  ====   setUserId() | getUserId()     O
	
	바디테이블의 컬럼명과 vo클래스의 필드명을 일치시키는 것이 좋다
	만약에 컬럼명과 필드명이 일치하지 않는 경우에는
	컬럼의 alias를 필드명으로 해주어야 값이 null로 나오는 것을 방지할 수 있다. -->
	
	<select id="getUserList" resultType="user"> <!-- resultType: 제네릭 -->
		SELECT
		user_id AS userId, 
		user_name AS userName, 
		password, 
		age, 
		grade, 
		reg_date AS regDate
		FROM users
	
	</select>	
</mapper>
```

* 해당 클래스를 resultType로 지정해주시면 그 클래스를 제네릭으로 지니는 리스트가 리턴
* Arraylist가 아닌 그안에 들어있는 객체 - 제네릭 ???
* parameterType부분은 인자값이랑 관련있는거여서 스트링아니면 객체일떈 user로 썼고
* resultType부분에는 제네릭을 쓴다 이렇게 이해했는데...



#### MyBatisTestApp.java

```java
package ibatis.services.user.test;


import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * FileName : MyBATISTestApp.java
  * ㅇ JBDCTestApp.java 와 비교 이해.
  * ㅇ mybatis Framework 에서 제공하는 API을 사용 users table 의 정보 SELECT   
 */
public class MyBatisTestApp {
	///Main method
	public static void main(String[] args) throws Exception{
		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");		
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>    읽어들인 reader를 바탕으로 SqlSessionFactory를 리턴받는다.
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		//==> 3.factory의 openSession()을 통해서 SqlSession을 리턴 받는다.
		SqlSession session=factory.openSession();
		
		List<User> list=session.selectList("UserMapper.getUserList");
		System.out.println("#####################################");
		System.out.println(":: 회원정보 출력");
		
		for (User user : list) {
			System.out.println( user ) ;
		}
		System.out.println("#####################################");
	}// end of main
}//end of class
```

```
#####################################
:: 회원정보 출력
User [userid=mybatis01, userName=홍길동iba, password=mybatis01, age=10, grade=1, active=false, regDate=2019-10-08 09:00:00.0]
User [userid=mybatis02, userName=이순신iba, password=mybatis02, age=20, grade=2, active=false, regDate=2019-10-07 09:00:00.0]
User [userid=mybatis03, userName=김유신iba, password=mybatis03, age=30, grade=3, active=false, regDate=2019-10-02 09:00:00.0]
User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
User [userid=user02, userName=이순신, password=user02, age=20, grade=2, active=false, regDate=2019-10-12 09:00:00.0]
User [userid=user03, userName=김유신, password=user03, age=30, grade=3, active=false, regDate=2019-10-09 09:00:00.0]
#####################################

```



### 2)

#### SqlMapConfig.xml

* `mapping01.xml` 추가

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
   <!-- 1. db정보를 가지고 온다. -->
   <properties resource="config/dbconn.properties"/>
   
   
   <!-- 2. vo를 alias.... -->
   <typeAliases>
      <typeAlias type="ibatis.services.domain.User" alias="user"/>
   </typeAliases>
   
   
   <!-- 3. jdbc 환경 구축 -->
   <environments default="mulcam">
      <environment id="mulcam" >
         <transactionManager type="JDBC"/>
         <dataSource type="UNPOOLED">
            <property name="driver" value="${jdbc.mysql.driver}"/>
            <property name="url" value="${jdbc.mysql.url}"/>
            <property name="username" value="${jdbc.mysql.username}"/>
            <property name="password" value="${jdbc.mysql.password}"/>
         
         </dataSource>
      </environment>
   </environments>
    
   <!--4. sql mapper -->
   <mappers>
      <mapper resource="sql/mybatis-userservice-mapping.xml"/>
      <mapper resource="sql/mybatis-userservice-mapping01.xml"/>
   </mappers>
</configuration>
```



#### mybatis-userservice-mapping01.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 
   id = getUser, findUserId에 해당하는 SELECT문을 작성하는 쿼리문
   1. #{VALUE}
   parameterType에 연결된 단순 파라미터 값을 받을 때 사용하는 문법
   #{} 안에 들어가는 VALUE는 상징적인 값으로 아무 변수 이름을 넣어도 상관없다.
   
   2. parameterType이 vo의 alias인 경우,
      #{userId} #{password}
      vo의 getUserId() getPassword와 연결되는 getter문법이다.
   3. parameterType, resultType의 사용법...
   4. MyBatis에서는 Collection API, 자바 API 라이브러리 클래스를 Alias로 사용하고 있다
   java.lang.String :: string, arraylist, list  -->
 
<!-- SQL definition -->
<mapper namespace="UserMapper01">

<!-- User user = (User)session.selectOne("UserMapper01.getUser", "user01"); -->
   <select id="getUser" parameterType="string" resultType="user">
       SELECT
       user_id AS userId,
       user_name AS userName, 
       password, 
       age, 
       grade, 
       reg_date AS regDate
       FROM users
<!--   WHERE user_id LIKE #{VALUE} -->
       WHERE user_id = #{VALUE}
   </select>
   
<!-- String name = (String)session.selectOne("UserMapper01.findUserId", user); -->
   <select id="findUserId" parameterType="user" resultType="string">
      SELECT
      user_name
      FROM
      users
      WHERE user_id = #{userId} <!-- user.getUserId() -->
      AND password = #{password}
   </select>
</mapper>
```



#### MyBatisTestApp01.java

* UserMapper01은 namespace, getuser는 id, "user"는 String
* getUserList는 UserMapper
* getUser / findUserId는 UserMapper01

```java
package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * FileName : MyBatisTestApp01.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping01.xml
  * ㅇ MyBATIS Framework 이용 QUERY ( SELECT ) TEST 
  */

public class MyBatisTestApp01 {
   public static void main(String[] args) throws Exception{
      
      //==> SqlMapConfig01.xml : MyBATIS Framework 의 핵심 환경설정화일 (MetaData)
      //==> mybatis-userservice-mapping.xml : SQL 를 갖는 설정화일 (MetaData) 
      
      //==> 1. xml metadata 읽는 Stream 생성
      Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
     
      //==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
      //==>    SqlMapClient  객체 생성
      
      SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
      SqlSession session=factory.openSession();
      List<User> list=session.selectList("UserMapper.getUserList");
      
      //0. getUserList :: 모든 user 정보
      System.out.println(":: 0. all User(SELECT)  ? ");
      
      for (int i =0 ;  i < list.size() ; i++) {
         System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
      }
      System.out.println("\n");

      //1. getUser :: 특정 userid 정보
      User user = (User)session.selectOne("UserMapper01.getUser", "user01");
      //id가 user01인 user를 찾음. return name
      System.out.println(":: 1. get(SELECT)  ? "+user.toString());
      System.out.println("\n");
      
      //2. findUserId :: 특정 userid / password 정보
      user.setUserId("user03");
      user.setPassword("user03");
      String name = (String)session.selectOne("UserMapper01.findUserId", user);
      //id가 user03이면서 pass가 user03인 사람을 찾는 것. return name
      System.out.println(":: 2. get(SELECT)  ? "+name);
      
   }//end of main
}//end of class
```

```
:: 0. all User(SELECT)  ? 
<1> 번째 회원..User [userid=mybatis01, userName=홍길동iba, password=mybatis01, age=10, grade=1, active=false, regDate=2019-10-08 09:00:00.0]
<2> 번째 회원..User [userid=mybatis02, userName=이순신iba, password=mybatis02, age=20, grade=2, active=false, regDate=2019-10-07 09:00:00.0]
<3> 번째 회원..User [userid=mybatis03, userName=김유신iba, password=mybatis03, age=30, grade=3, active=false, regDate=2019-10-02 09:00:00.0]
<4> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
<5> 번째 회원..User [userid=user02, userName=이순신, password=user02, age=20, grade=2, active=false, regDate=2019-10-12 09:00:00.0]
<6> 번째 회원..User [userid=user03, userName=김유신, password=user03, age=30, grade=3, active=false, regDate=2019-10-09 09:00:00.0]


:: 1. get(SELECT)  ? User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]


:: 2. get(SELECT)  ? 김유신
```



### 3)

#### SqlMapConfig.xml

* `mapping02.xml` 추가

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
   <!-- 1. db정보를 가지고 온다. -->
   <properties resource="config/dbconn.properties"/>
      
   <!-- 2. vo를 alias.... -->
   <typeAliases>
      <typeAlias type="ibatis.services.domain.User" alias="user"/>
   </typeAliases> 
   
   <!-- 3. jdbc 환경 구축 -->
   <environments default="mulcam">
      <environment id="mulcam" >
         <transactionManager type="JDBC"/>
         <dataSource type="UNPOOLED">
            <property name="driver" value="${jdbc.mysql.driver}"/>
            <property name="url" value="${jdbc.mysql.url}"/>
            <property name="username" value="${jdbc.mysql.username}"/>
            <property name="password" value="${jdbc.mysql.password}"/>
         
         </dataSource>
      </environment>
   </environments>
    
   <!--4. sql mapper -->
   <mappers>
      <mapper resource="sql/mybatis-userservice-mapping.xml"/>
      <mapper resource="sql/mybatis-userservice-mapping01.xml"/>
      <mapper resource="sql/mybatis-userservice-mapping02.xml"/>
   </mappers>
</configuration>
```



#### mybatis-userservice-mapping02.xml

```
<!-- List<User> list = session.selectList("UserMapper02.getUser01","user");
	 여기서 "user"는 string -> parameterType / resultType은 list의 제너릭인 user 
	 list = session.selectList("UserMapper02.getUser01","user%");
	  "user"로 시작하는 사람 -> % like연산자 -->
```



```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 
	 #{VALUE} : parameterType이 단순값으로 들어올 때  사용함...string
	 #{userId} : parameterType이 user라면...
	 ::
	 와일드 카드와  LIKE 연산자 쿼리문 사용하는 방법
	 1) user_id가 특정한 값으로 시작하는 user를 검색하는 방법
	 user_id LIKE     #{VALUE} '%'
	 user_id LIKE     #{userId} '%'
	 
	 2) user_id가 특정한 값으로 끝나는 user를 검색하는 방법
	 user_id LIKE '%' #{VALUE}
	 user_id LIKE '%' #{userId}
	 
	 3) user_id가 특정한 값을 포함하는 user를 검색하는 방법
	 user_id LIKE '%' #{VALUE} '%'
	 user_id LIKE '%' #{userId} '%' 			-->
 
 
<!-- SQL definition -->
<mapper namespace="UserMapper02">

<!-- List<User> list = session.selectList("UserMapper02.getUser01","user"); 
	 list = session.selectList("UserMapper02.getUser01","user%"); -->
   <select id="getUser01" parameterType="string" resultType="user">
       SELECT
       user_id AS userId,
       user_name AS userName, 
       password, 
       age, 
       grade, 
       reg_date AS regDate
       FROM users
       WHERE user_id LIKE #{VALUE} 
<!--   WHERE user_id = #{VALUE} :: 여기서는 = 사용 불가, LIKE! -->
   </select>
   
<!-- list = session.selectList("UserMapper02.getUser02",user); -->   
   <select id="getUser02" parameterType="user" resultType="user">
       SELECT
       user_id AS userId,
       user_name AS userName, 
       password, 
       age, 
       grade, 
       reg_date AS regDate
       FROM users
       WHERE user_id LIKE #{userId} <!-- user.getUserId() -->
   </select>
   
<!-- list = session.selectList("UserMapper02.getUser03","user"); -->
   <select id="getUser03" parameterType="string" resultType="user">
       SELECT
       user_id AS userId,
       user_name AS userName, 
       password, 
       age, 
       grade, 
       reg_date AS regDate
       FROM users
       WHERE user_id LIKE #{VALUE} '%' <!-- 단순 파라미터 값 / 와일드카드 뒤에 ! user% -->
   </select>
   
<!-- list = session.selectList("UserMapper02.getUser04",user); -->
   <select id="getUser04" parameterType="user" resultType="user">
       SELECT
       user_id AS userId,
       user_name AS userName, 
       password, 
       age, 
       grade, 
       reg_date AS regDate
       FROM users
       WHERE user_id LIKE '%' #{userId} '%' <!-- 단순 파라미터 값 / 와일드카드 앞에 ! %01 -->
   </select>

</mapper>
```





#### MyBatisTestApp02.java

```java
package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * FileName : MyBatisTestApp02.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping02.xml
  * ㅇ My Framework 이용 QUERY ( SELECT ) TEST 
  */

public class MyBatisTestApp02 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		//==> SqlMapConfig01.xml : MyBATIS Framework 의 핵심 환경설정화일 (MetaData)
		//==> mybatis-userservice-mapping02.xml : SQL 를 갖는 설정화일 (MetaData) 
				
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>    SqlMapClient  객체 생성
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		//0. getUser :: # 대입자를 이용한 like 연산자 검색 
		//				==> 검색결과 없는것 확인
		System.out.println(":: 0. user로시작하는 userId User(SELECT)  ? ");
		List<User> list = session.selectList("UserMapper02.getUser01","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//1. getUser :: # 대입자를 이용한 like 연산자 검색 
		// 				==> 검색결과 존재 확인 :: %와일드카드 쿼리문이 아닌 값에 직접 입력하는 경우
		System.out.println(":: 1. user로시작하는 userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser01","user%");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
	
		//2. getUser :: # 대입자를 이용한 like 연산자 검색 
		//				==> 검색결과 없는것 확인
		User user = new User();
		user.setUserId("01");
		
		System.out.println(":: 2. 01로 끝나는 userId User(SELECT)  ? ");
		 list = session.selectList("UserMapper02.getUser02",user);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//3. getUser :: # 대입자를 이용한  like 연산자 검색 
		//				==> 검색결과 존재 확인 :: %와일드카드 직접 입력하는 경우 
		user.setUserId("%01");	
		System.out.println(":: 3. 01로 끝나는 userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser02",user);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//4. getUser :: $ 대입자를 이용한 like 연산자 검색
		//				==> 검색결과 존재 확인 :: %와일드카드 쿼리문에 입력하는 경우  
		System.out.println(":: 4. user로시작하는 userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser03","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
	
		//5. getUser :: $ 대입자를 이용한 like 연산자 검색
		//		==> 검색결과 존재 확인 :: %와일드카드 쿼리문에 입력하는 경우  
		user.setUserId("01");
		System.out.println(":: 5. 01로 끝나는 userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser04",user);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
	
	}//end of main
}//end of class
```

```
:: 0. user로시작하는 userId User(SELECT)  ? 


:: 1. user로시작하는 userId User(SELECT)  ? 
<1> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
<2> 번째 회원..User [userid=user02, userName=이순신, password=user02, age=20, grade=2, active=false, regDate=2019-10-12 09:00:00.0]
<3> 번째 회원..User [userid=user03, userName=김유신, password=user03, age=30, grade=3, active=false, regDate=2019-10-09 09:00:00.0]


:: 2. 01로 끝나는 userId User(SELECT)  ? 


:: 3. 01로 끝나는 userId User(SELECT)  ? 
<1> 번째 회원..User [userid=mybatis01, userName=홍길동iba, password=mybatis01, age=10, grade=1, active=false, regDate=2019-10-08 09:00:00.0]
<2> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]


:: 4. user로시작하는 userId User(SELECT)  ? 
<1> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
<2> 번째 회원..User [userid=user02, userName=이순신, password=user02, age=20, grade=2, active=false, regDate=2019-10-12 09:00:00.0]
<3> 번째 회원..User [userid=user03, userName=김유신, password=user03, age=30, grade=3, active=false, regDate=2019-10-09 09:00:00.0]


:: 5. 01로 끝나는 userId User(SELECT)  ? 
<1> 번째 회원..User [userid=mybatis01, userName=홍길동iba, password=mybatis01, age=10, grade=1, active=false, regDate=2019-10-08 09:00:00.0]
<2> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
```





### 4)

#### SqlMapConfig.xml

* `mapping03.xml` 추가

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
   <!-- 1. db정보를 가지고 온다. -->
   <properties resource="config/dbconn.properties"/>
   
   <!-- 2. vo를 alias.... -->
   <typeAliases>
      <typeAlias type="ibatis.services.domain.User" alias="user"/>
   </typeAliases>
   
   <!-- 3. jdbc 환경 구축 -->
   <environments default="mulcam">
      <environment id="mulcam" >
         <transactionManager type="JDBC"/>
         <dataSource type="UNPOOLED">
            <property name="driver" value="${jdbc.mysql.driver}"/>
            <property name="url" value="${jdbc.mysql.url}"/>
            <property name="username" value="${jdbc.mysql.username}"/>
            <property name="password" value="${jdbc.mysql.password}"/>
         
         </dataSource>
      </environment>
   </environments>
    
   <!--4. sql mapper -->
   <mappers>
      <mapper resource="sql/mybatis-userservice-mapping.xml"/>
      <mapper resource="sql/mybatis-userservice-mapping01.xml"/>
      <mapper resource="sql/mybatis-userservice-mapping02.xml"/>
      <mapper resource="sql/mybatis-userservice-mapping03.xml"/>
   </mappers>
</configuration>
```



#### mybatis-userservice-mapping03.xml

```xml


```



#### MyBatisTestApp03.java

```java
package ibatis.services.user.test;

import ibatis.services.domain.User;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * FileName : MyBatisTestApp03.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping03.xml
  * ㅇ My Framework 이용 QUERY ( SELECT ) TEST 
  */

public class MyBatisTestApp03 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		//==> SqlMapConfig.xml : MyBATIS Framework 의 핵심 환경설정화일 (MetaData)
		//==> mybatis-userservice-mapping.xml : SQL 를 갖는 설정화일 (MetaData) 
		
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각정 정보를 접근, 사용가능한 
		//==>    SqlSession  객체 생성
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		//0. User01.getUserList 
		System.out.println(":: 0. getUserList(SELECT)  ? ");
		List<User> list = session.selectList("UserMapper.getUserList");						//mapping.xml
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//==> Test용 UserVO instance 생성
		User user = new User("user04","주몽","user04",40,4);
		
		//1.User03.addUser Test
		Object obj = session.insert("UserMapper03.addUser", user);
		session.commit(); //이 부분 반드시 해줘야 한다....mvc에서는 생략가능.
		//iBatis와 다르게 insert문의 리턴타입은 insert된 row수를 반환한다.
		System.out.println(":: 1. addUser(INSERT)  result ? "+obj); 						//1: db에 추가된 rows
		System.out.println("\n");
		
		
		
		//2.User01.findUserId Test
		String userName = (String)session.selectOne("UserMapper01.findUserId", user);		//mapping01.xml
		System.out.println(":: 2. findUserId(SELECT)  ? "+userName); 						//주몽 
		System.out.println("\n");
			
		
		//3.User03.updateUser Test
		user.setUserName("장보고");
		int updateResult = session.update("UserMapper03.updateUser", user);
		session.commit(); //이부분 반드시 해줘야 한다.
		System.out.println(":: 3. updateUser(UPDATE) result ? "+updateResult);				//1: db에 추가된 rows
		System.out.println("\n");
		
			
		//4.User01.findUserId Test
		userName = (String)session.selectOne("UserMapper01.findUserId", user);
		System.out.println(":: 4. findUserId(SELECT)  ? "+userName); 						//장보고
		System.out.println("\n");
		
		
		//5.User03.removeUser Test
		int deleteResult = session.delete("UserMapper03.removeUser", user.getUserId());
		session.commit(); //이 부분 반드시 해줘야 한다.
		System.out.println(":: 5. removeUser(DELETE) result ? "+deleteResult);
		System.out.println("\n");
		
		
		//6. User01.getUserList 
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		 list = session.selectList("UserMapper.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> 번째 회원.."+ list.get(i).toString() );
		}
		
	}//end of main
}//end of class
```



```
:: 0. getUserList(SELECT)  ? 
<1> 번째 회원..User [userid=mybatis01, userName=홍길동iba, password=mybatis01, age=10, grade=1, active=false, regDate=2019-10-08 09:00:00.0]
<2> 번째 회원..User [userid=mybatis02, userName=이순신iba, password=mybatis02, age=20, grade=2, active=false, regDate=2019-10-07 09:00:00.0]
<3> 번째 회원..User [userid=mybatis03, userName=김유신iba, password=mybatis03, age=30, grade=3, active=false, regDate=2019-10-02 09:00:00.0]
<4> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
<5> 번째 회원..User [userid=user02, userName=이순신, password=user02, age=20, grade=2, active=false, regDate=2019-10-12 09:00:00.0]
<6> 번째 회원..User [userid=user03, userName=김유신, password=user03, age=30, grade=3, active=false, regDate=2019-10-09 09:00:00.0]


:: 1. addUser(INSERT)  result ? 1


:: 2. findUserId(SELECT)  ? 주몽


:: 3. updateUser(UPDATE) result ? 1


:: 4. findUserId(SELECT)  ? 장보고


:: 5. removeUser(DELETE) result ? 1


:: 6. getUserList(SELECT)  ? 
<1> 번째 회원..User [userid=mybatis01, userName=홍길동iba, password=mybatis01, age=10, grade=1, active=false, regDate=2019-10-08 09:00:00.0]
<2> 번째 회원..User [userid=mybatis02, userName=이순신iba, password=mybatis02, age=20, grade=2, active=false, regDate=2019-10-07 09:00:00.0]
<3> 번째 회원..User [userid=mybatis03, userName=김유신iba, password=mybatis03, age=30, grade=3, active=false, regDate=2019-10-02 09:00:00.0]
<4> 번째 회원..User [userid=user01, userName=홍길동, password=user01, age=10, grade=1, active=false, regDate=2019-10-11 09:00:00.0]
<5> 번째 회원..User [userid=user02, userName=이순신, password=user02, age=20, grade=2, active=false, regDate=2019-10-12 09:00:00.0]
<6> 번째 회원..User [userid=user03, userName=김유신, password=user03, age=30, grade=3, active=false, regDate=2019-10-09 09:00:00.0]

```



> INSERT

```
mysql> SELECT * FROM users;
+-----------+-----------+-----------+------+-------+------------+
| user_id   | user_name | password  | age  | grade | reg_date   |
+-----------+-----------+-----------+------+-------+------------+
| mybatis01 | 홍길동iba | mybatis01 |   10 |     1 | 2019-10-08 |
| mybatis02 | 이순신iba | mybatis02 |   20 |     2 | 2019-10-07 |
| mybatis03 | 김유신iba | mybatis03 |   30 |     3 | 2019-10-02 |
| user01    | 홍길동    | user01    |   10 |     1 | 2019-10-11 |
| user02    | 이순신    | user02    |   20 |     2 | 2019-10-12 |
| user03    | 김유신    | user03    |   30 |     3 | 2019-10-09 |
| user04    | 주몽      | user04    |   40 |     4 | NULL       |
+-----------+-----------+-----------+------+-------+------------+
7 rows in set (0.00 sec)
```



> UPDATE

```
mysql> SELECT * FROM users;
+-----------+-----------+-----------+------+-------+------------+
| user_id   | user_name | password  | age  | grade | reg_date   |
+-----------+-----------+-----------+------+-------+------------+
| mybatis01 | 홍길동iba | mybatis01 |   10 |     1 | 2019-10-08 |
| mybatis02 | 이순신iba | mybatis02 |   20 |     2 | 2019-10-07 |
| mybatis03 | 김유신iba | mybatis03 |   30 |     3 | 2019-10-02 |
| user01    | 홍길동    | user01    |   10 |     1 | 2019-10-11 |
| user02    | 이순신    | user02    |   20 |     2 | 2019-10-12 |
| user03    | 김유신    | user03    |   30 |     3 | 2019-10-09 |
| user04    | 장보고    | user04    |   40 |     4 | NULL       |
+-----------+-----------+-----------+------+-------+------------+
7 rows in set (0.00 sec)
```



> DELETE

```
mysql> SELECT * FROM users;
+-----------+-----------+-----------+------+-------+------------+
| user_id   | user_name | password  | age  | grade | reg_date   |
+-----------+-----------+-----------+------+-------+------------+
| mybatis01 | 홍길동iba | mybatis01 |   10 |     1 | 2019-10-08 |
| mybatis02 | 이순신iba | mybatis02 |   20 |     2 | 2019-10-07 |
| mybatis03 | 김유신iba | mybatis03 |   30 |     3 | 2019-10-02 |
| user01    | 홍길동    | user01    |   10 |     1 | 2019-10-11 |
| user02    | 이순신    | user02    |   20 |     2 | 2019-10-12 |
| user03    | 김유신    | user03    |   30 |     3 | 2019-10-09 |
+-----------+-----------+-----------+------+-------+------------+
6 rows in set (0.00 sec)
```



## 4. MyBatis_Member

* src/main/java
  * spring/service/domain
    * MemberVO.java
* src/main/resources
  * config
    * dbconn.properties
    * SqlMapConfig.xml
  * mapper
    * mybatis-memberservice-mapping.xml
* src/test/java
  * spring/service/test
    * MyBatisMemberTestApp.java

```
mysql> SELECT * FROM member;
+-----+----------+-------+---------+
| id  | password | name  | address |
+-----+----------+-------+---------+
| 111 | 111      | James | NY      |
| 222 | 222      | Jane  | Boston  |
| 333 | 333      | Tom   | Texas   |
| 444 | 444      | John  | Seoul   |
+-----+----------+-------+---------+
4 rows in set (0.00 sec)
```



#### MemberVO.java

```java
package spring.service.domain;

public class MemberVO {
	private String id;
	private String password;
	private String name;	
	private String address;
	
	public MemberVO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}
	
	public MemberVO() {	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}	
}

```



#### SqlMapConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-config.dtd">
   
<configuration>

   <!-- 1. db정보를 가지고 온다. -->
   <properties resource="config/dbconn.properties"/>
   
   <!-- 2. vo를 alias.... -->
   <typeAliases>
      <typeAlias type="spring.service.domain.MemberVO" alias="memberVO"/>
   </typeAliases>
   
   <!-- 3. jdbc 환경 구축 -->
   <environments default="mulcam">
      <environment id="mulcam" >
         <transactionManager type="JDBC"/>
         <dataSource type="UNPOOLED">
            <property name="driver" value="${jdbc.mysql.driver}"/>
            <property name="url" value="${jdbc.mysql.url}"/>
            <property name="username" value="${jdbc.mysql.username}"/>
            <property name="password" value="${jdbc.mysql.password}"/>
         
         </dataSource>
      </environment>
   </environments>
   
   <!--4. sql mapper -->
   <mappers>
      <mapper resource="mapper/mybatis-memberservice-mapping.xml"/>
   </mappers>
   
</configuration>
```



####  mybatis-memberservice-mapping.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
   "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
 
<mapper namespace="MemberMapper">

<!-- Object obj = session.insert("MemberMapper.registerMember", memberVO); -->
	<insert id="registerMember" parameterType="memberVO">
		INSERT INTO
		member (id, password, name, address)
		VALUES (#{id},#{password},#{name},#{address})
	</insert>
	
<!-- int deleteResult = session.delete("MemberMapper.deleteMember", memberVO.getId()); -->
	<delete id="deleteMember" parameterType="memberVO">
		DELETE FROM
		member
		WHERE id = #{id}
	</delete>
	
<!-- int updateResult = session.update("MemberMapper.updateMember", memberVO); -->	
	<update id="updateMember" parameterType="memberVO">
		UPDATE
		member
		SET name = #{name}, address = #{address}
		WHERE id = #{id}
	</update>

<!-- String name = (String)session.selectOne("MemberMapper.getMember", memberVO); -->	
	<select id="getMember" parameterType="memberVO" resultType="string">
		SELECT 
		name
		FROM member
		WHERE id = #{id}
<!-- 	WHERE id LIKE #{id} -->
	
	</select>

<!-- list = session.selectList("MemberMapper.showAllMember"); -->	
	<select id="showAllMember" parameterType="memberVO" resultType="memberVO">
		SELECT 
		id, password, name, address
		FROM member
	</select>
</mapper>
```





#### MyBatisMemberTestApp

````java
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
````

```
:: 0. showAllMember(SELECT)  ? 
<1> 번째 회원..MemberVO [id=111, password=111, name=James, address=NY]
<2> 번째 회원..MemberVO [id=222, password=222, name=Jane, address=Boston]
<3> 번째 회원..MemberVO [id=333, password=333, name=Tom, address=Texas]
<4> 번째 회원..MemberVO [id=444, password=444, name=John, address=Seoul]


:: 1. registerMember(INSERT)  result ? 1


:: 2. getMember(SELECT)  ? Kate


:: 3. updateMember(UPDATE) result ? 1


:: 4. getMember(SELECT)  ? Sally


:: 5. deleteMember(DELETE) result ? 1


:: 6. showAllMember(SELECT)  ? 
<1> 번째 회원..MemberVO [id=111, password=111, name=James, address=NY]
<2> 번째 회원..MemberVO [id=222, password=222, name=Jane, address=Boston]
<3> 번째 회원..MemberVO [id=333, password=333, name=Tom, address=Texas]
<4> 번째 회원..MemberVO [id=444, password=444, name=John, address=Seoul]
```

```
mysql> SELECT * FROM member;
+-----+----------+-------+---------+
| id  | password | name  | address |
+-----+----------+-------+---------+
| 111 | 111      | James | NY      |
| 222 | 222      | Jane  | Boston  |
| 333 | 333      | Tom   | Texas   |
| 444 | 444      | John  | Seoul   |
| 555 | 555      | Kate  | LA      |
+-----+----------+-------+---------+
5 rows in set (0.00 sec)
```

```
mysql> SELECT * FROM member;
+-----+----------+-------+---------+
| id  | password | name  | address |
+-----+----------+-------+---------+
| 111 | 111      | James | NY      |
| 222 | 222      | Jane  | Boston  |
| 333 | 333      | Tom   | Texas   |
| 444 | 444      | John  | Seoul   |
| 555 | 555      | Sally | LA      |
+-----+----------+-------+---------+
5 rows in set (0.00 sec)
```

```
mysql> SELECT * FROM member;
+-----+----------+-------+---------+
| id  | password | name  | address |
+-----+----------+-------+---------+
| 111 | 111      | James | NY      |
| 222 | 222      | Jane  | Boston  |
| 333 | 333      | Tom   | Texas   |
| 444 | 444      | John  | Seoul   |
+-----+----------+-------+---------+
4 rows in set (0.00 sec)
```

