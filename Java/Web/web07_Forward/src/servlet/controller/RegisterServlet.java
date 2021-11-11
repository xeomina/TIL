package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서
		 * 2. (받은 값으로 VO생성)
		 * 3. DAO 리턴받아서
		 * 4. 결과값 바인딩
		 * 5. 네비게이션
		 */
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		Member vo = new Member(name, age, address);
		
		//DAO는 여기서는 생략...바로 바인딩
		request.setAttribute("vo", vo);		//같은 이름으로 해야 헷갈리지 않는다 -> "vo"를 vo로 바인딩
		
		//네비게이션...서버상에서 바로 jsp 파일로 이동
		request.getRequestDispatcher("result.jsp").forward(request,response);
		
	}

}











