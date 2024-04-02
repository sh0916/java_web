package com.spring.ex03.param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/param")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpDAO empDAO = new EmpDAO();
		
		String empno = request.getParameter("empno");
		EmpDTO dto = empDAO.selectEmpByEmpno(empno);
		
		System.out.println("7788 조회 결과");
		System.out.println(dto);
	}
}
