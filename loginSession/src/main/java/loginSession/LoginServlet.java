package loginSession;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(session.getId() == null) {
			
			response.sendRedirect("login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		System.out.println(userId);
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserId(userId);
		loginDTO.setUserPass(userPass);
		
		LoginDAO loginDAO = new LoginDAO();
		boolean loginChk = loginDAO.userInfo(loginDTO);
		
		if(loginChk) {
			System.out.println("로그인 성공");
			session = request.getSession();
			System.out.println(session.getId());
			
			session.setAttribute("session", session.getId());
			RequestDispatcher dispatch = request.getRequestDispatcher("main.jsp");
			dispatch.forward(request, response);
		} else {
			System.out.println("로그인 실패");
			response.sendRedirect("login.html");
		}
	}

}
