package sec03.ex01.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/session")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존 세션이 없으면 null 을 return
		HttpSession session2 = request.getSession(false);
		
		// 기존 세션이 없으면 새로 만들어서 return
		HttpSession session1 = request.getSession();
		
		System.out.println("session2 : " +session2);
		
		System.out.println("session1 : " + session1);
		// 새로 생성된 세션인지 기존에 생성된 세션인지 판별(true/false)
		System.out.println("session1.isNew() : " + session1.isNew());
		// 세션에 할당된 교유 식별자를 String 타입으로 반환
		System.out.println("session1.getId() : " + session1.getId());
		// 생성된 세션을 유지하기 위해 설정된 세션 유지 시간을 int 로 반환
		System.out.println("session1.getMaxInactiveInterval() : " + session1.getMaxInactiveInterval());
		// 지금말고 마지막에 접속했던 시간을 반환
		System.out.println("session1.getLastAccessedTime() : " + session1.getLastAccessedTime());
		
		// 접속했던 세션이면 그세션 출력
		String old_id = (String)session1.getAttribute("id");  
		System.out.println("old_id : " + old_id);
		
		String id = request.getParameter("id");
		session1.setAttribute("id", id);
		
		// 중복 로그인 막기
//		session1.setAttribute("time", "유효 시간");
//		String id = request.getParameter("id");
//		// DB 에서 로그인 체크
//		session1.setAttribute("id", id);
//		if(session1.isNew ()) {
//			list.add(session1);
//		}
//		// for
//		HttpSession session = (HttpSession)list.get(0);
//		String old_id = (String)session.getAttribute("id");
		
		String url = response.encodeUrl("session");
		System.out.println("url : " + url);
		response.getWriter().println("<a href='" + url + "'>session 으로 이동</a>");
	}	
}
