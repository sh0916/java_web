package com.spring.ex01;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		
		EmpDAO empDAO = new EmpDAO();
		
		// select emp4
		List<EmpDTO> empList = empDAO.selectAllEmpList();
//		for(int i=0; i<empList.size(); i++) {
//			EmpDTO empDTO = empList.get(i);
//			System.out.println("["+ i +"] empno : "+ empDTO.getEmpno() +", ename : "+ empDTO.getEname());
//			response.getWriter().println("["+ i +"] empno : "+ empDTO.getEmpno() +", ename : "+ empDTO.getEname()+"<br>");
//		}
		request.setAttribute("list", empList);
		
		
		// empno=7788인 ename만 조회
		String ename = empDAO.selectEname();
		request.setAttribute("ename", ename);
		
		
		Map map = empDAO.selectEmpMap();
		System.out.println("map : "+ map);

		System.out.println("****************");
		System.out.println( empDAO.selectEmpResult() );
		
		request.getRequestDispatcher("emp.jsp").forward(request, response);
		
		
		
	}

}
