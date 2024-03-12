package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login2Servlet
 */
@WebServlet("/login2")
public class Login2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id);
		// valid
		// valideate
		if(id == null || "".equals(id.trim())) {
			response.getWriter().println("아이디는 필수입니다");
			return;
		}
		
		PrintWriter out = response.getWriter();
		out.println("아이디 => " + id + "<br>");
		out.println("비밀번호 => " + pw);
	}

}
