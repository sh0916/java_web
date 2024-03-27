package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserId(userId);
		loginDTO.setUserPass(userPass);
		
		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginInfo = loginDAO.info(loginDTO);

		request.setAttribute("loginInfo", loginInfo);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

}
