package com.edu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edu.spring.domain.MyProduct;
import com.edu.spring.model.MyProductService;

@Controller
public class MyProductController {
	
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")	//myProduct.do 요청 들어오면 동작하는 메소드
	//폼에서 넘어온 값이 vo에 자동 바인딩되어 Passing Into 되어진다.
	public ModelAndView insert(MyProduct pvo) throws Exception {	
		/*
		String name=  request.getParameter("name");
		String maker=  request.getParameter("maker");
		int price=  request.getParameter("price");
		MyProduct vo = new MyProduct(name, maker, price); 	//자동 바인딩되기 때문에 필요 x
		*/
		
		System.out.println("DB 입력하기 전..."+pvo.getId());
		myProductService.addProduct(pvo); //dao.addProduct--> sqlSession--> 디비에 insert
		System.out.println("DB 입력한 후..."+pvo.getId());
		
		//ServletRequest에 바인딩 되어지고 insert_result.jsp에 forward되어진다.
		return new ModelAndView("insert_result", "info", pvo);	//확장자 x
		
		}
	@RequestMapping("myProductSearch.do")
	public ModelAndView search(String word, String command) throws Exception {
		ModelAndView mv = null;
		if(command.equals("findByProductName")) {
			List<MyProduct> list = myProductService.findProductByName(word);
			mv = new ModelAndView("find_result", "list", list);
		}
		
		return mv;

	}

}
