//MVC pattern의 RegisterServlet -> Front Controller Pattern의 register()
package web.controller;

/* 
 * Component
 * ::
 * 인터페이스 기반의 재사용성이 강한 자바 클래스
 * ::
 * CBD 기반의 프로젝트
 * 
 */
public class AddController implements Controller {

	public String handle() {
		/*
		 * 1.폼값 받아서
		 * 2.vo 생성
		 * 3.DAO 비즈니스 로직 호출...인자값 VO넣고
		 * 4.리턴값 받아서 바인딩
		 * 5.네비게이션
		 */
		System.out.println("AddController...register logic...");
		return "add_result.jsp";
	}
	

}
