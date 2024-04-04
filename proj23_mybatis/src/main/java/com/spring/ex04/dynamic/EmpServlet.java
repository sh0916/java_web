package com.spring.ex04.dynamic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/dynamic")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDAO empDAO = new EmpDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("texdt/html; charset=utf-8;");
		
		EmpDTO dto = new EmpDTO();
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		String sort = request.getParameter("sort");
		
		List<String> empnoList = null;
		String[] empnos = request.getParameterValues("empno");
		for(int i = 0; i < empnos.length; i++) {
			System.out.println("empnos[i] : " + empnos[i]);
			empnoList.add(empnos[i]);
		}
		
		/*
		 * type
		 * 1 : ename  : 이름
		 * 2 : sal >= : 연봉(이상)
		 */
//		if("1".equals(type)) {
//			dto.setEname(keyword);			
//		} else if("2".equals(type)) {	
//			try {				
//				int sal = Integer.parseInt(keyword);
//				dto.setSal(sal);		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if("4".equals(type)) {
//			dto.setJob(keyword);
//		} else if("5".equals(type)) {
//			dto.setEname(keyword);
//			dto.setJob(keyword);
//		}
		dto.setType(type);
		dto.setKeyword(keyword);
		
		if(!"".equals(sort) && sort != null) {			
			dto.setSort(sort);
		}
		
		List<SqlSession> list = empDAO.getEmpList(dto);
		System.out.println("list.size() : " + list.size());
		
		request.setAttribute("empList", list);
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		request.setAttribute("sort", sort);
		
		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}
}
