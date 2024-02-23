

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if("admin".equals(id)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("isLogon", "OK");
			
			response.sendRedirect("test.jsp");
		} else {
			
			response.sendRedirect("login.jsp");
		}
	}




}
