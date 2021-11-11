package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Servlet의 일생을 관장하는 Lifecycle 메소드
 * 1.생성자 호출
 * 2.init()...서블릿 객체가 생성된 직후 호출
 * 3.doGet() 혹은 doPost()...클라이언트가 요청을 하면
 * 4.destroy()...서버를 stop 시키면 반드시 호출...이게 호출되면 서블릿이 사라진다
 * 
 * 
 */

/**
 * Servlet implementation class LifecycleTest1
 */
@WebServlet("/LIFE1")
public class LifecycleTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	//추가
	private int count=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifecycleTest1() {
        super();
        System.out.println("1.Servlet Create...by container");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.init call...by container");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("4.destroy call...by container");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3.service...doGet call...by container");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//클라이언트가 요청을 할때마다 몇번 요청을 했는지...알 수 있도록 count를 증가 -> 필드 
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>Life Cycle CallBack Method...</h3>");
		out.println("<b>COUNT :: "+ ++count +"</b>");
		out.println("</body></html>");
		
		out.close();


	}

}
