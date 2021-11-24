package com.edu.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class MainController{

/*	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");	//결과 페이지의 이름
		mv.addObject("info","MainController...execute !!");
		
		//자동적으로 forward 방식으로 이동, ServletRequest에 바인딩이 이뤄진다
		return mv;
	}*/
	
	@RequestMapping("main.do")
	public ModelAndView main() {
		return new ModelAndView("result", "info", "MainController...execute !!");
	}

}
