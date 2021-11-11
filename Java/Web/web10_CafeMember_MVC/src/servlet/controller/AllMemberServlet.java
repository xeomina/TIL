package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/AllMember")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String path = "index.html";	
		
		//1.(폼값 받아서)
		//2.(VO 생성)
		//3.DAO 리턴 받아서 Business Logic 호출
		MemberDAO dao = MemberDAOImpl.getInstance();
		
		//4.반환 값 바인딩
		try {
			ArrayList<MemberVO> list = dao.showAllMember();
			request.setAttribute("list", list);	
			path = "allView.jsp";
			
		}catch(Exception e) {
			System.out.println("Show All Member Fail...");
		}
				
		//5.네비게이션
		request.getRequestDispatcher(path).forward(request, response);;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doProcess(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
