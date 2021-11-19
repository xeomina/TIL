package web.servlet;
/*
 
  Cookie API
  
  1.  
  	 서버상에서 먼저 쿠키가 생성된다.
         이때 MAP방식으로 정보가 저장됨
     NAME(String)- VALUE(String)
     "Small amount of Information"
     -->
     Cookoie c = new Cookie("id","jaen");
     
  2. 
        응답시 클라이언트측으로 다시 보내진다.
     "정보를 저장하고 있는 쿠키가 클라이언트 측에 저장된다"
      -->
      response.addCookie(c);
      
  3. 
     두번쨰 요청시 다시 서버로 보내진다.
    이런식으로 서버와 클라이언트 사이드를 왔다갔다 하면서
    서버와 클라이언트를 계속 유지시켜주는 역할을 쿠키가 한다.
    쿠키안에 서버상의 정보를 저장하는 것이 아니라
    클라이언트를 구분하는 jsessionid값믄 쿠키에 담도록 자동화 되어져 있다.
    --> cookie[ ] cs = request.getCookies();
      
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreatingCookie")
public class CreatingCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. Cookie 생성
		Cookie c1 = new Cookie("id", "jaen");
		Cookie c2 = new Cookie("today", "11-15-1052");
		
		//Cookie의 유효시간을 지정할수 있다.
		c1.setMaxAge(24*60*60*2);//하루동안 저장...
		c2.setMaxAge(0); //저장안됨.
		
		//2. 응답시 클라이언트로 다시 보낸다.
		response.addCookie(c1);
		response.addCookie(c2);
		
		//3.getCookie.jsp로 바로 이동
		//request.getRequestDispatcher("getCookie.jsp").forward(request, response);
		response.sendRedirect("getCookie.jsp");
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
