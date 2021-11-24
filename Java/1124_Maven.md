# 1124 Maven



## 1.

### 1) 

> sp03



#### web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

	<servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>classpath:beans/beanconf.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>

	<!-- 한글처리 -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>utf-8</param-value>
		</init-param>
	</filter>
	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
</web-app>
```



#### beanconf.xml

* /src/main/resources/beans/beanconf.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">

	<!-- API, 사용자 정의 Bean -->
	<!-- InternalResourceViewResolver는 여기서 생략...prefix, suffix 내용이 코드에 있다. -->
	<bean name="/form.do" class="com.edu.spring.controller.FormController"/>
	
	
	<!-- Annotation 에서는 반드시 이 부분을 추가해야한다. -->
<context:component-scan base-package="com.edu.spring.controller"/>
</beans>
```



#### form.html

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Spring MVC Form...</h2>
<form action="form.do" method="post">
	NAME <input type="text" name="name"><br><br>
	ADDR <input type="text" name="addr"><br><br>
	<input type="submit" value="SEND">
	<input type="reset" value="CLEAR">
</form>
<hr>
<a href="anno.do">Annotation Controller 연결하기</a>
</body>
</html>
```



#### AnnoController.java

```java
package com.edu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
 * Annotation을 사용하면 인터페이스 상속받을 필요가 없다.
 * 오버라이딩 method가 없어진다.
 * 
 * anno.do라는 요청이 들어왔을때...어떤 메소드에서 요청을 작성해야 하는지를 알 수 없게 된다.
 * 메소드명은 사용자가 알아서 정하면 된다.
 */
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AnnoController {	//인터페이스 상속 받을 필요가 없다.
	
	//anno.do라는 요청이 들어오면...annoExecute()를 호출해서 실행시켜라...
	//@RequestMapping("anno.do")
	@RequestMapping(value = "anno.do", method = RequestMethod.GET)
	public ModelAndView annoExecute() {
		return new ModelAndView("WEB-INF/views/anno_result.jsp","message","Annotation Controller");
	}

}
```



#### FormController.java

```java
package com.edu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 폼값 받아서
		 * vo 생성
		 * DAO 리턴받아서
		 * Biz로직 메소드 호출
		 * 리턴되는 값 바인딩
		 * 네비게이션
		 */
		String name  = request.getParameter("name");
		String addr = request.getParameter("addr");
		//InternalResuouceViewResolver
		/*
		 * 1. 
		 * info라는 이름으로
		 * ServletRequest Attribute에 이름과 주소를 바인딩함.
		 * 
		 * 2.
		 * /WEB_INF/views폴더 아래에
		 * form_result.jsp 결과 페이지로
		 * 기본 이동(forward)한다.
		 */
		return new ModelAndView("/WEB-INF/views/form_result.jsp", "info", name+"님의 주소는 "+addr);
	}

}
```





#### anno_result.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${message}</h3>
</body>
</html>
```



#### form_result.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${info}</h3>
</body>
</html>
```





![image-20211124115727818](md-images/1124/image-20211124115727818.png)



![image-20211124115744376](md-images/1124/image-20211124115744376.png)

![image-20211124115806248](md-images/1124/image-20211124115806248.png)

![image-20211124115813461](md-images/1124/image-20211124115813461.png)

### 2) sp02 수정해보기

> sp04에 작성



![image-20211124122223152](md-images/1124/image-20211124122223152.png)



#### web.xml

* 한글처리, 설정문서 경로 변경

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd" version="2.5">
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:config/beans.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>utf-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
</web-app>
```



#### beans.xml

* dispatcher-servlet.xml 내용 옮기고 context:component 부분 추가

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd">

	<!-- API, 사용자 정의 Bean -->
	
	<!-- 결과 페이지의 위치와 확장자 정보를 가지고 있는 API bean :: InternalResourceViewResolver -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/results/" /> <!-- 결과 페이지의 물리적인 저장 위치 -->
		<property name="suffix" value=".jsp" /> <!-- 결과 페이지의 확장자 -->
	</bean>
	
	<!-- 사용자 정의 Bean 등록 name 속성값으로는 어떤 요청이 들어왔을 때 ControllerFactory가 생성해주는 Component인지를 등록 -->
	<bean name="/main.do" class="com.edu.spring.controller.MainController"></bean>
	
	
	
	<!-- Annotation 에서는 반드시 이 부분을 추가해야한다. -->
	<context:component-scan base-package="com.edu.spring.controller"/>
		
</beans>
```



#### MainController

* annotation으로 overriding 삭제

```java
package com.edu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MainController{
	
	@RequestMapping("main.do")
	public ModelAndView main() {
		return new ModelAndView("result", "info", "MainController...execute !!");
	}
}
```



![image-20211124122559519](md-images/1124/image-20211124122559519.png)

* 결과 sp02랑 똑같이 나옴 !!





## 2. 

### 1) 프로젝트 진행 순서

1. 프로젝트 착수
   1. 아키텍처
   2. Software / Hardware
   3. 기술 Set
   4. 일정 (WBS)

2. 분석 및 설계
   1. 요구사항 시나리오
   2. 요구사항 명세서(SRS)
   3. Usecase Diagram
      1.  화면설계
      2. DB 모델링 : 
         1. 개념설계
            1. Entity 추출 -> table
         2. 논리설계
            1. Entity 속성 - 기본 key, 일반 key
            2. 정규화...
         3. 물리설계
            1. 실제 테이블 생성 -> 구현으로 연결
      3. Template : 기능 설정
3. 구현
   1. Table 구축
   2. vo 작성
   3. DAO

-------------------



### 2) 구현 단계



#### Command

* Table 생성

```
mysql> use scott;
Database changed
mysql> CREATE TABLE myproduct(
    -> id int(10) auto_increment primary key,
    -> name varchar(30),
    -> maker varchar(30),
    -> price int(10));
Query OK, 0 rows affected (0.05 sec)
```

* 데이터 생성

```
mysql> INSERT INTO myproduct (name, maker, price) VALUES('통돌이 세탁기','대우',450000);
Query OK, 1 row affected (0.01 sec)

mysql> INSERT INTO myproduct (name, maker, price) VALUES('드럼울세탁 세탁기', '대우',550000);
Query OK, 1 row affected (0.00 sec)

mysql> SELECT * FROM myproduct;
+----+-------------------+-------+--------+
| id | name              | maker | price  |
+----+-------------------+-------+--------+
|  1 | 통돌이 세탁기     | 대우  | 450000 |
|  2 | 드럼울세탁 세탁기 | 대우  | 550000 |
+----+-------------------+-------+--------+
2 rows in set (0.00 sec)
```



#### MyProduct.java

* Encapsulation
* 컬럼명과 필드명 똑같이 생성
* 기본 생성자/ 명시적 생성자 / setter 및 getter / toString

```java
package com.edu.spring.domain;

public class MyProduct {
	
	//Encapsulation으로 필드 생성 - 컬럼명과 동일하게
	private int id;
	private String name;
	private String maker;
	private int price;
	
	//기본 생성자
	public MyProduct() {
	}

	//명시적 생성자
	public MyProduct(int id, String name, String maker, int price) {
		super();
		this.id = id;
		this.name = name;
		this.maker = maker;
		this.price = price;
	}

	//setter / getter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//toString
	@Override
	public String toString() {
		return "MyProduct [id=" + id + ", name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}
}
```



