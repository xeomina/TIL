package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MultiFormServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//여기다 로직을 작성...
		/*
		 * 1. 한글처리..양방향
		 * 2. PrintWriter 객체 리턴받는다.
		 * 3. 폼에 입력된 모든 값들을 받아온다...이떄 checkbox에 입력된 값은...getParameterValues()사용!!!!
		 * 4. 클라이언트가 전달한 모든 값들을 다시 브라우저로 출력
		 * 5. PrintWriter를 닫아준다..close()
		 */	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id=  request.getParameter("id");
		String password=  request.getParameter("password");
		
		String[ ] menus = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		
		String intro = request.getParameter("intro");
		
		
		out.println("<html><body>");
		out.println("<h2>폼에 입력된 값들을 출력합니다...</h2>");
		out.println("<li>당신의 아이디 "+id+"</li>");
		out.println("<li>당신의 패스워드 "+password+"</li>");
		
		out.println("<strong>선택하신 메뉴들 입니다.</strong><br>");
		String menu = "";
		for(int i=0; i<menus.length; i++) {
			menu += menus[i] +" ";
		}
		out.println(menu);
		
		out.println("<br><strong>당신의 성별은 "+gender+" 입니다.</strong><br>");
		
		out.println("<br><strong>방명록 내용입니다.</strong><br>");
		out.println(intro);
		
		out.close();		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
