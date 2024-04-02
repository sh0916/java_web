package com.spring.ex01;

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
@WebServlet("/emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmpDAO empDAO = new EmpDAO();
		
		// 전체 조회
		List<EmpDTO> empList = empDAO.selectAllEmpList();
		request.setAttribute("empList", empList);	
		
		// empno = 7788 인 ename 만 조회
		String ename = empDAO.selectEname();
		request.setAttribute("ename", ename);	
		
		Map<String, Object> map = empDAO.selectEmpMap();
		request.setAttribute("map", map);
		
		EmpDTO empDTO = empDAO.selectEmpResult();
		request.setAttribute("empDTO", empDTO);
		
		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}
}
