package org.zerock.w1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/param")
public class ParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 들어오는 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		
		// 내보내는 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8");
		
		// 브라우저에서 보낸 값을 확보
		
		// key 에 해당하는 값이 없으면 null
		String key = request.getParameter("key");
		System.out.println("key : " + key);
		
		// input 에 값이 없으면 ""이게 오는 거고 null 은 아님
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		
		PrintWriter out = response.getWriter();
		out.println("key : [" + key + "]");
		out.println("<br>");
		out.println("id : [" + id + "]");
		
		// 키 game 이 여러개인 경우
		// getParameter 는 첫번째 값 하나만 가져옴
		String game = request.getParameter("game");
		System.out.println("game : " + game);
		out.println("<br>");
		out.println("game 단독 : [" + game + "]");
		
		String[] games = request.getParameterValues("game");
		if(games != null) {
			
			for(String g : games) {
				System.out.println("games : " + g);
				out.println("game 반복 : [" + g + "]<br>");
			}
		} else {
			System.out.println("선택한 게임이 없습니다<br>");
		}
		
		Enumeration en = request.getParameterNames();
		while(en.hasMoreElements()) {	// 다음 요소가 있는가?
			
			String name = (String)en.nextElement();	// 다음 요소 가져오기
			System.out.println("name : " + name);
			
			String[] values = request.getParameterValues(name);
			if(values != null) {
				
				for(String g : values) {
					System.out.println("values : " + g);
					out.println("values 반복 : [" + g + "]<br>");
				}
			} else {
				System.out.println("선택한 게임이 없습니다<br>");
			}
		}
		
	}

}
