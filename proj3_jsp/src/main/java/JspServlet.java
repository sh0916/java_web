

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspServlet
 */
@WebServlet("/jsp")
public class JspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		// sendRedirect => 응답이오면 다른쪽으로 가라고 알려줌
//		response.sendRedirect("param.jsp?id=" + id);
		
		// forward => 응답을 넘겨줘서 넘겨받은 곳에서 다시 요청한곳으로 보내줌
//		request.getRequestDispatcher("param.jsp?id=" + id).forward(request, response);
		
		// 어차피 request 를 전달하고 jsp 는 거기서 id 값을 꺼낼 수 있다
//		request.getRequestDispatcher("param.jsp").forward(request, response);
		
		// setAttribute => (key, value)
		request.setAttribute("id2", id);
		
		List<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("sung");
		list.add("hyun");
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("param.jsp").forward(request, response);
		
		// session
		// 	서버에서 관리
		// 		일반적인 생명주기
		//		신규 브라우저의 접속시 생성
		//		마지막 접속 20분 후에 소멸
		// cookie
		//	브라우저가 관리-보안에 취약
		//		만료일 있는 경우 만료일까지
		//		클라이언트(브라우저)에 살아있음
		//		만료일이 없는 경우(세션쿠키) 브라우저를 끄면 사라짐
	}

}
