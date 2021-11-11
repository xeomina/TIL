package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MS")
public class MultiFormServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       

    public MultiFormServlet() {
        
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //실질적인 로직은 여기서 작성, get,post 방식 요청이건 다 수행 가능하다.
       //한글처리 :: 양방향(req/res)을 다 해줘야 한다.
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");

       //
       PrintWriter out=response.getWriter();
      
      String name=request.getParameter("name");
      String addr=request.getParameter("addr");
      
      out.println("<html><body><h3>");
      out.println("Your Information...</h3><br>");
      out.println("<li> Name "+name+"<br>");
      out.println("<li> Address "+addr);
      out.println("</body></html>");
      
      out.close();

   }

    //client에서 get 요청이 들어올 때 이 부분이 호출
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request,response);
   }
   
   //client에서 post 요청이 들어올 때 이 부분이 호출
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doProcess(request,response);
   }

}