

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 쿠키 쓰기
		// 쿠키생성 => key, value
		Cookie cookie = new Cookie("test1", "1234");
		response.addCookie(cookie);
		
		// 쿠키읽기 => 10초만 유지후 삭제
		cookie.setMaxAge(10);
		
		Cookie cookie2 = new Cookie("test2", "한글");
		response.addCookie(cookie2);
		
		String encode = URLEncoder.encode("한글2", "utf-8");
		System.out.println(encode);
		Cookie cookie3 = new Cookie("test3", encode);
		response.addCookie(cookie3);		
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			
			for(int i = 0; i < cookies.length; i++) {
				
				String name = cookies[i].getName();	// key 값
				System.out.println("쿠키 이름 : " + name);
				
				String value = cookies[i].getValue();
				URLDecoder.decode(value, "utf-8");
				System.out.println("쿠키 값 : " + value);
				
			}
		}
	}

}
