package com.edu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/*
 * Presentation Layer의 Component
 * 이후 Annotation 기법에서는 @Controller라고 마킹되어질 것
 * 일단 xml --> @Controller
 */

public class IndexController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// DAO 메소드 호출
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("result"); 	//결과 페이지의 이름(결과 페이지 저장 위치와 확장자는 생략)
		mv.addObject("message", "Hello SpringMVC !!");	//별도의 설정이 없으면 forward로 request 바인딩...message에 Hello SpringMVC !!
		
		return mv;
	}

}
