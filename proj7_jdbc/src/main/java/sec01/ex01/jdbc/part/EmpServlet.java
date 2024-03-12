package sec01.ex01.jdbc.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("/emp doGet 실행");
		response.setContentType("text/html; charset=utf-8");
		
		EmpDAO empDAO = new EmpDAO();
		List<EmpDTO> list = empDAO.listEmp();
		
		System.out.println("총 개수 : " + list.size());
		
		for(int i = 0; i < list.size(); i++) {
			EmpDTO empDTO = (EmpDTO)list.get(i);
			int empno = empDTO.getEmpno();
			String ename = empDTO.getEname();
			int sal = empDTO.getSal();
			
			response.getWriter().println("<div>"
											+ " empno : " + empno
											+ " ename : " + ename
											+ " sal : " + sal	
										+ "</div>"
										);
		}
	}

}
