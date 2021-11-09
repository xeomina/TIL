package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletTest
 */

//annotation ...was xml 변경 - HttpServletTest -> 서버 내부에 HttpServletTest 인스턴스 -> web.servlet.HttpServletTest
@WebServlet("/HttpServletTest")

//public class HttpServletTest extends HttpServlet {
class HttpServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//servlet 객체가 생성될 때 호출...언제?...누가? -> was가 알아서 생성
    public HttpServletTest() {					//생성자
        super();
        System.out.println("HttpServletTest Servlet Creating...");
    }

    //언제? -> 클라이언트가 요청을 하면 호출 / 누가? -> was가 알아서 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()....call...");
		
		//클라이언트의 요청을 처리하는 코드를 작성
		//클라이언트의 요청을 처리하려면...요청정보(request), 처리된 결과(response)를 전달..
		//요청정보는 request에 담겨짐(id값)
		
		//브라우저로 받은 id 출력
		PrintWriter out = response.getWriter();		//브라우저로 출력하는 기능
		
		//폼값 받아서 처리한다
		String id = request.getParameter("userId"); //폼이름
		
		out.println("<html><body><h2>");
		out.println("User ID : "+id);
		out.println("</h2></body></html>");
		

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
