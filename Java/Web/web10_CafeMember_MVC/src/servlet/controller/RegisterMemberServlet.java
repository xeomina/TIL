package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/RMS")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "index.html";	
		
		//1. 폼값 받아서
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//2. VO 생성
		MemberVO vo = new MemberVO(id,password,name,address);
		
		//3. DAO 리턴받아서 Business Logic 호출
		MemberDAO dao = MemberDAOImpl.getInstance();
				
		//4. 반환값 바인딩
		try {
			dao.registerMember(vo);	
			request.setAttribute("vo", vo);								
			path = "result_view.jsp";
		}catch(Exception e) {
			System.out.println("Register Member Fail...");
		}
		
		//5. 네비게이션
		request.getRequestDispatcher(path).forward(request,response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
