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
	EmpDAO empDAO = new EmpDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empno = request.getParameter("empno");
		EmpDTO dto = empDAO.selectEmpByEmpno(empno);
		
		System.out.println("7788 조회 결과");
		System.out.println(dto);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		System.out.println("action : " + action);
		
		if("actionInsert".equals(action)) {
			String ename = request.getParameter("ename");
			int empno = -1;
			int sal = -1;
			int deptno = -1;
			String strEmpno = request.getParameter("empno");
			String strSal = request.getParameter("sal");
			String strDeptno = request.getParameter("deptno");
			
			try {
				empno = Integer.parseInt(strEmpno);
				sal = Integer.parseInt(strSal);
				deptno = Integer.parseInt(strDeptno);
				
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setSal(sal);
				dto.setDeptno(deptno);
				
				int result = empDAO.insertEmp(dto);
				System.out.println("insert 결과 : " + result);
				
				response.sendRedirect("emp.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if("actionDetail".equals(action)) {
			String empno = request.getParameter("empno");
			System.out.println("empno : " + empno);
			
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
			String strDeptno = request.getParameter("deptno");
			System.out.println("ename : " + ename);
			try {
				empno = Integer.parseInt(strEmpno);
				sal = Integer.parseInt(strSal);
				deptno = Integer.parseInt(strDeptno);
				
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setSal(sal);
				dto.setDeptno(deptno);
				System.out.println("dto : " + dto);
				// TODO update 로 변경 : 완료
				int result = empDAO.updateEmp(dto);
				System.out.println("update 결과 : " + result);
				
				response.sendRedirect("emp.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if("actionDelete".equals(action)) {
			int empno = -1;
			String strEmpno = request.getParameter("empno");
			
			try {
				empno = Integer.parseInt(strEmpno);
				System.out.println("empno : " + empno);

				int result = empDAO.deleteEmp(empno);
				System.out.println("delete 결과 : " + result);
				
				response.sendRedirect("emp.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
