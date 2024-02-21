package org.zerock.w1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sample")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SampleServlet() {
        System.out.println("생성자");
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doget 실행");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		out.println("<h1>");
		out.print("Hello Servlet");
		out.write("</h1>");
		out.println("!");
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("doPost 실행");
//		doGet(request, response);
//	}

}
