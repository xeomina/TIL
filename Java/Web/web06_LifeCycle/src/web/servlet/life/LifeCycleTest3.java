package web.servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
 * LIFE2의 문제점
 * 1. 서버가 꺼지게 되면 필드값을 영구적으로 잃어버리게 된다.
 *    서블릿 인스턴스가 Death되기 때문에 그 안에 저장된 필드 값도 함께 사라진다.
 *    --> 해결책 ?
 *    데이터를 어딘가에 저장하는 메카니즘...라이프 사이클 메소드를 연계
 *    DB, 파일 ...
 *    
 *    destroy() : 서블릿 죽기 직전...저장 -> Setter(Writer)
 *    init() : 새롭게 Ready On할 때 어딘가에 저장된 이전의 값을 다시 찾아옴 ...-> Getter(Reader)
 *    
 */

/**
 * Servlet implementation class LifeCycleTest3
 */
@WebServlet("/LIFE3")
public class LifeCycleTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count =0;
	private String path = "C:\\miracom_edu\\util\\count.txt";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleTest3() {
        super();
        System.out.println("1.Servlet Create...by container");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2.init call...by container");
		//파일에 저장된 내용을 불러온다
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			 
			 count = Integer.parseInt(str);
			 System.out.println("count.txt값을 읽어서 필드에 다시 할당함 !");

		}catch(Exception e) {
			System.out.println("파일 읽기 실패...");
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("4.destroy call...by container");
		//서블릿 인스턴스가 메모리에서 영구적으로 삭제되기 직전에 값을 파일에 저장
		File f = new File(path);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println(count); //이때 파일에 저장됨..출력
			pw.close();
			
			System.out.println(path+", Count값 : "+count+", 파일 저장 성공 !");
		}catch(Exception e) {
			System.out.println("파일 출력 실패...");
			
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3.service...doGet call...by container");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor='yellow'>");
		out.println("<h3>Life Cycle CallBack Method...</h3>");
		out.println("<b>COUNT :: "+ ++count +"</b>");	//요청 끝나도 증가
		out.println("</body></html>");
		
		out.close();
	}


}
