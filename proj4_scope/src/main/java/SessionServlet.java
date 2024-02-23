

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/session")
public class SessionServlet extends HttpServlet {
	
//	application
//	같은 tomcat에 사용 가능
	
//	session
//	같은 브라우저에서는 계속 사용 가능
	
//	request
//	요청때 생겨서 응답때 사라짐
	
//	page
//	딱 그 jsp 안에서만 사용 가능
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 새로운 세션이면 세션을 생성해서 돌려줌
		HttpSession session = request.getSession();
		
		if(session.isNew()) {	// isNew() => 새로운 세션인지 확인
			System.out.println("처음 보는 브라우저");
		} else {
			System.out.println("아까 왔던 브라우저");
		}
		System.out.println(session.getId());
		
		// 새로운 세션이면 => null
//		HttpSession session = request.getSession(false);
		
		String id = request.getParameter("id");
//		if(id.equals("admin"))
		if("admin".equals(id)) {
			
			// 세션은 30분동안 유지
			session.setAttribute("isLogon", true);
		}
	}

}
