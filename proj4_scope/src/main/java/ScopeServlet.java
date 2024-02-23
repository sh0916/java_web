

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/scope")
public class ScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("세팅 시작");
		
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		request.setAttribute("request", "request 에 바인딩");
		session.setAttribute("session", "session 에 바인딩");
		application.setAttribute("application", "context 에 바인딩");
		
		List list = new ArrayList();
		
		Map map = new HashMap();
		map.put("empno", 1234);
		map.put("ename", "abcd");
		list.add(map);
		
		map = new HashMap();
		map.put("empno", 1234);
		map.put("ename", "abcd");
		list.add(map);
		
		session.setAttribute("members", list);
	}

}
