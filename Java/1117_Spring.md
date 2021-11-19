# 1117 Spring

## 1. 복습

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-01.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-01.png)

- 네비게이션의 문제

```
request.getRequestDispatcher(path).forward(request, response);
```

- 페이지 이동방법은 한가지로만 한다.
- 서블릿이 하나돌아가기때문에, hidden을 command 값을 하나하나 다 붙여줘야함.



web18_FactoryMethodPattern_final

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-02.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-02.png)

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-03.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-03.png)

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-04.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-04.png)



## spring

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-05.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-05.png)



## DI (Dependency Injection)

* src 다각화

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-06.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-06.png)



## Coupling

- 타이트한 커플링

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-07.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-07.png)

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-08.png)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-08.png)



## Spring Framework Module

## 1. ModelAndView

우리의 현재 코드는 hidden의 번거로움이 있다.
ModelAndView = hidden의 번거로움을 없앰 + 네비게이션은 forward/redirect 방식 두가지 있음
ModelAndView = 결과페이지 이름(String) + 이동방식에 대한 정보를 담는 클래스

## 2. DI framework

POJO: package/ private field(property) / Constructor / getter, setter / 필요한 Method
를 갖는 (빈 규약을 준한) 일반적인 **Bean**. 아무런 클래스나 인터페이스를 상속받지 않음.

프레임워크는 커플링을 낮추는데 목숨을 건다

프레임워크는 모듈화 되어있다

[![img](https://github.com/msio900/miracom_javaEduSummary/raw/master/image/1117-08.jpg)](https://github.com/msio900/miracom_javaEduSummary/blob/master/image/1117-08.jpg)

DI프레임워크 = Core Container

- Beans, Core, Context, Expression Language 라이브러리(jar)가 필요하다!!!!!!!!!!!!

DI의 핵심
결합도를 낮추는것

1. 직접 객체 생성 X
2. Factory 같은 다른 곳에서 생성 -> 이걸 갖다 쓴다

객체를 생성하는 팩토리 역할을 하는게 그게 DI이다. 그게 DI Container = Core Container 이다.
주문서를 보고 객체를 만든다

BeanFactory: Core Container 중에 하나

> 톰캣같은 컨테이너다
> 그치만 코어 컨테이너는 **클래스**다! 톰캣같은 컨테이너처럼 너무 거창하게 생각하지 않아도 된다
> 컨테이너의 라이브러리 클래스를 제공하는게 DI 컨테이너다?

```
BeanFactory factory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/heelo.xml"));

Hello hello = (Hello) factory.getBean("hello");
hello.printMessage();
```

컨테이너를 직접 만들어보자
주문서를 받아서 만드는 팩토리다
팩토리는 단순히 인스턴스 생성 코드를 캡슐화한거다