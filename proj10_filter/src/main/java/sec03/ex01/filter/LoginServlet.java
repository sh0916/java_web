package sec03.ex01.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("user_name : " + user_name);
		System.out.println("user_pw : " + user_pw);
		
		response.getWriter().println("이름 : " + user_name + "<br>");
		response.getWriter().println("비번 : " + user_pw);
		
		if( "admin".equals(user_name) && "1234".equals(user_pw) ) {
			
			request.getSession().setAttribute("login", true);
			response.sendRedirect("main");
		}
	}

}
