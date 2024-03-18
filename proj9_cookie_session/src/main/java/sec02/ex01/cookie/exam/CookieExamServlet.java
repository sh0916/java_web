package sec02.ex01.cookie.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieExamServlet
 */
@WebServlet("/cookieExam")
public class CookieExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;; charset=utf-8;");
		
		Cookie[] cookies = request.getCookies();
		boolean isShow = true;
		
		if(cookies != null) {
			
			for(int i = 0; i < cookies.length; i++) {
				
				Cookie cookie = cookies[i];
				
				if("show".equals(cookie.getName())) {
					
					if("false".equals(cookie.getValue())) 
						
						isShow = false;
				}
			}
		}
		
		if(isShow) {
			
			response.getWriter().println("<div>");
			response.getWriter().println("공지입니다<br>");
			response.getWriter().println("<input type='checkbox' id='chk'>");
			response.getWriter().println("30초 동안 팝업 보이지 않기");
			response.getWriter().println("</div>");
		}
		
		response.getWriter().println("<p>글씨</p>");
		response.getWriter().println("<script>");
		response.getWriter().println("	if(document.querySelector('#chk')) {");
		response.getWriter().println("		document.querySelector('#chk').addEventListener('click', function(event) {");
		response.getWriter().println("			console.log(\"event.target.checked : \" + event.target.checked);");
		response.getWriter().println("			if(event.target.checked) {");
		response.getWriter().println("				document.cookie = 'show=false';");
		response.getWriter().println("			}");
		response.getWriter().println("		});");
		response.getWriter().println("	}");
		response.getWriter().println("</script>");
		
	}
}
