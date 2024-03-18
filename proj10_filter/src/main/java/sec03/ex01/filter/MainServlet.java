package sec03.ex01.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		// Boolean => null 이 들어갈수있다(형변환이 자유롭다)
//		Boolean login = (Boolean)request.getSession().getAttribute("login");
//		
//		if(login == null || login != true) {
//		
//			response.sendRedirect("login.html");
//		}
		response.getWriter().println("<h1>비밀공간</h1>");
	}
}
