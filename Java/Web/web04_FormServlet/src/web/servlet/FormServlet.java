package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //Client가 요청을 하면 이 부분이 호출...was에 의해서
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. PrintWriter 객체 생성
		PrintWriter out = response.getWriter();	
		
		//2. 폼값 받아오기...name,addr 변수에 각각 할당
		String name = request.getParameter("name"); 
		String addr = request.getParameter("addr");
		
		//3. 클라이언트의 브라우저로 출력
		out.println("<html><body><h3>");
		out.println("Your Information...</h3><br>");
		out.println("<li> Name "+name+"<br>");
		out.println("<li> Address "+addr);
		out.println("</body></html>");
		out.close();

		
	}

}
