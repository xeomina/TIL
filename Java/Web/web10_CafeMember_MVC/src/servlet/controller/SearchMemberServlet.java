package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

/**
 * Servlet implementation class SearchMemberServlet
 */
@WebServlet("/SMS")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMemberServlet() {
        super();
    }
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기에 작성...
		//1. 폼값 받아서	
		//2. (vo 생성)
		//3. DAO 리턴받아서 Business Logic 호출
		//4. 반환값 바인딩
		//5. 네비게이션...result_view.jsp
		
		String path = "index.html";							//변수로 처리
		String id = request.getParameter("id");								//1.
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance(); 	//메소드 호출
		try {
			MemberVO vo = dao.findByIdMember(id);							//3.
			
			if(vo!=null) {		//id에 해당하는 Member가 있다면
				request.setAttribute("vo", vo);								//4.
				path = "result_view.jsp";
			}	//else는 할 필요 없음 -> 바인딩/path x
			
		}catch(Exception e) {
		}
		request.getRequestDispatcher(path).forward(request,response);		//5.
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
