package com.spring.ex04.dynamic;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dynamic")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmpDAO empDAO = new EmpDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		
		EmpDTO dto = new EmpDTO();
		
		// 검색
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		
		// 정렬
		String orderColumn = request.getParameter("orderColumn");
		String orderType = request.getParameter("orderType");
		
		/* type
		 * 1 : ename  : 이름
		 * 2 : sal >= : 연봉(이상)
		 */
//		if("1".equals(type)) {
//			dto.setEname(keyword);
//		} else if("2".equals(type)) {
//			try {
//				int sal = Integer.parseInt(keyword);
//				dto.setSal(sal);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if("4".equals(type)) {
//			dto.setJob(keyword);
//		}
		
		
		// 부분검색(checkbox) 관련
		String[] chks = request.getParameterValues("chk");
		if(chks != null) {
			for(String chk : chks) {
				System.out.println("chk: "+ chk);
			}
		}
		
		
		dto.setType(type);
		dto.setKeyword(keyword);
		
		dto.setOrderColumn(orderColumn);
		dto.setOrderType(orderType);
		
		dto.setChks(chks);
		
// DB 조회
		List list = empDAO.getEmpList(dto);
		System.out.println("list.size() : "+ list.size());
		
		
// jsp에 전달할 것 정리		
		request.setAttribute("list", list);
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		request.setAttribute("orderColumn", orderColumn);
		request.setAttribute("orderType", orderType);
		
		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}
}
