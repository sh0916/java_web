package sec03.brd08.paging;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/emp")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// controller :
		// - 요청에 따라서 service 호출
		// 	 service 의 결과물을 어떤 view 로 보낼지 결정
		
		// service : 
		// - dao 호출 담당
		// - dao 호출 담당
		
		// dao :
		// - DB 담당
		
		// jsp :
		// - view 담당
		
		int pageNum = 1;		// 현재 페이지
		int countPerPage = 5;	// 한 페이지당 표시수
		
		// 오류 발생시 초기값을 사용하게 된다
		try {			
			String tmp_pageNum = request.getParameter("pageNum");
			
			if(tmp_pageNum != null) {
				pageNum = Integer.parseInt(tmp_pageNum);
			}
			
			String tmp_countPerPage = request.getParameter("countPerPage");
			
			if(tmp_countPerPage != null) {
				countPerPage = Integer.parseInt(tmp_countPerPage);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		EmpService empService = new EmpService();
		int totalCount = empService.getTotalEmp();
		List<EmpDTO> list = empService.listEmp(pageNum, countPerPage);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}

}
