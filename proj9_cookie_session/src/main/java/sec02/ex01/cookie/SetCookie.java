package sec02.ex01.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/set")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8;");		
		
		// 셋팅값을 주지 않거나 음수로 설정하면 세션쿠키가 된다
		// 즉 브라우저 메모리에만 저장된다
		// 즉 브라우저의 모든 탭을 끄면 사라진다
		Cookie c = new Cookie("key", "value");
		c.setMaxAge(-1);	// 초단위
		response.addCookie(c);
		
		Cookie c2 = new Cookie("key2", "한글");
		c2.setMaxAge(10);	// 초단위
		response.addCookie(c2);
		
		System.out.println("쿠키 셋팅 완료");
	}
 


}
