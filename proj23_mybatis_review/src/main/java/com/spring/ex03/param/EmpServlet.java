package com.spring.ex03.param;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpDAO empDAO = new EmpDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
//		EmpDAO empDAO = new EmpDAO();

		String empno = request.getParameter("empno");
//		String empno = "7788";
		EmpDTO dto = empDAO.selectEmpByEmpno(empno);
		
		System.out.println("empno로 조회 결과");
		System.out.println(dto);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("action : "+ action);
//		EmpDAO empDAO = new EmpDAO();

		if("actionInsert".equals(action)) {
			
			String ename = request.getParameter("ename");

			int empno = -1;
			int sal = -1;
			int deptno = -1;
			String strEmpno = request.getParameter("empno");
			String strSal = request.getParameter("sal");
			String strDetpno = request.getParameter("deptno");
			
			try {
				
				empno = Integer.parseInt(strEmpno);
				sal = Integer.parseInt(strSal);
				deptno = Integer.parseInt(strDetpno);
				
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setSal(sal);
				dto.setDeptno(deptno);
				
//				EmpDAO empDAO = new EmpDAO();
				int result = empDAO.insertEmp(dto);
				System.out.println("insert 결과 : "+ result);
				
				response.sendRedirect("emp.do");
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else if("actionDetail".equals(action)) {
			String empno = request.getParameter("empno");
			System.out.println("actionDetail : empno : "+ empno);
			
			EmpDTO dto = empDAO.selectEmpByEmpno(empno);
			System.out.println(dto);
			
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("test03/empForm.jsp").forward(request, response);
		} else if("actionUpdate".equals(action)) {
			
			String ename = request.getParameter("ename");

			int empno = -1;
			int sal = -1;
			int deptno = -1;
			String strEmpno = request.getParameter("empno");
			String strSal = request.getParameter("sal");
			String strDetpno = request.getParameter("deptno");
			
			try {
				
				empno = Integer.parseInt(strEmpno);
				sal = Integer.parseInt(strSal);
				deptno = Integer.parseInt(strDetpno);
				
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setSal(sal);
				dto.setDeptno(deptno);

				int result = empDAO.updateEmp(dto);
				System.out.println("update 결과 : "+ result);
				
				response.sendRedirect("emp.do");
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
