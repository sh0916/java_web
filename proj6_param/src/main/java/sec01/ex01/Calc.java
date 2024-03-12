package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		System.out.println("num1 : "+ num1);
		int n1 = Integer.parseInt(num1);

		String op = request.getParameter("op");
		System.out.println("op : "+ op);

		String num2 = request.getParameter("num2");
		System.out.println("num2 : "+ num2);
		int n2 = Integer.parseInt(num2);
		
		int result = 0;
		if("+".equals(op)) {
			result = n1 + n2;
		} else if("-".equals(op)) {
			result = n1 - n2;
		} else if("*".equals(op)) {
			result = n1 * n2;
		} else if("/".equals(op)) {
			result = n1 / n2;
		} else if("%".equals(op)) {
			result = n1 % n2;
		}
		
		response.getWriter().println( result );
	}

}
