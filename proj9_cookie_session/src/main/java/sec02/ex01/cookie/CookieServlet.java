package sec02.ex01.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookie
 */
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Cookie cookie = new Cookie("cookie", "test"); response.addCookie(cookie);
		 * 
		 * RequestDispatcher dispatch = request.getRequestDispatcher("cookie.html");
		 * dispatch.forward(request, response);
		 */
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(int i = 0; i < cookies.length; i++) {
				
				if(cookies[i].getName() == "cookie2") {
					
					request.setAttribute(cookies[i].getName(), cookies[i].getValue());
					RequestDispatcher dispatch = request.getRequestDispatcher("cookie.html");
					dispatch.forward(request, response);
				}				
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
