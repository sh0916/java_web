package sec01.ex01;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String frmLogin = request.getParameter("frmLogin");
		System.out.println("frmLogin : " + frmLogin);
		
		String user_id = request.getParameter("user_id");
		System.out.println("user_id : " + user_id);
		String[] user_ids = request.getParameterValues("user_id");
		System.out.println("user_ids : " + user_ids);
		
		String subjet = request.getParameter("subject");
		System.out.println("subjet : " + subjet);
		String[] subjects = request.getParameterValues("subject");
		System.out.println("subjects : " + subjects.length);
		
		response.getWriter().println("{\"k\":\"v\"}");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost 실행");
		String user_id = request.getParameter("user_id");
		System.out.println("user_id : " + user_id);
		
		response.getWriter().println("{\"k\":\"v2\"}");
	}

}
 