package kr.or.human.emp.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.human.emp.dao.EmpDAO;
import kr.or.human.emp.dto.EmpDTO;
import kr.or.human.emp.view.EmpView;


@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 깨짐 방지
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		// 전달받은 값(Parameter) 확보
		String ename = request.getParameter("ename");
		String strDeptno = request.getParameter("deptno");
		int deptno = -1;
		
		try {
			deptno = Integer.parseInt(strDeptno);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		// 결과를 받아서
//		List list = empDAO.selectEmp(ename, deptno);
		
		//empDTO 에 담아서 보내기
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEname(ename);
		empDTO.setDeptno(deptno);
		
		// DB 담당에게 전달하고
		EmpDAO empDAO = new EmpDAO();
		
		List list = empDAO.selectEmp(empDTO);
		System.out.println(list);
		
		// view 담당에게 전달  
		EmpView empView = new EmpView();
		StringBuffer sb = empView.drawList(list);
		
		response.getWriter().println(sb);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		
		String ename = request.getParameter("ename");
		String strEmpno = request.getParameter("empno");
		int empno = -1;
		
		try {
			empno = Integer.parseInt(strEmpno);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEname(ename);
		empDTO.setEmpno(empno);
		
		EmpDAO empDAO = new EmpDAO();
		int result = empDAO.updateEmp2(empDTO);
		System.out.println("업데이트 결과 : " + result);
		
		response.sendRedirect("emp");
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
