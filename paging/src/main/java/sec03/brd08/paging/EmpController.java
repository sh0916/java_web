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
		
		int choPage = 1;
		
		if(request.getParameter("choPage") != null) {
			choPage = Integer.parseInt(request.getParameter("choPage"));
		}
		System.out.println("choPage : " + choPage);
		
		EmpService empService = new EmpService();
		List<EmpDTO> list = empService.listEmp(choPage);
		int totalPage = empService.bordCount();
		
		request.setAttribute("list", list);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("emp.jsp").forward(request, response);
	}

}
