package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet2
 */
@WebServlet("/Redirect2")
public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choose = request.getParameter("choose");		//checkbox name="choose"
		if(choose == null)
			//error page...redirect
			response.sendRedirect("./error/error.html");	//정적인 문서 html 파일
		else	//이때는 서버상의 결과 페이지로 바로 이동...forward
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);	//이 페이지 모든 것을 가지고 이동 
			
	}

}
