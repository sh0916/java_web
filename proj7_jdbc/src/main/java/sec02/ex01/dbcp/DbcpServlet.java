package sec02.ex01.dbcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/dbcp"} )
public class DbcpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbcpDAO dbcpDAO = new DbcpDAO();
		List<DbcpDTO> list = dbcpDAO.listEmp();
		
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("member.jsp").forward(request, response);
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		response.setContentType("text/html; charset=utf-8");
		
		DbcpDTO dbcpDTO = new DbcpDTO();
		dbcpDTO.setEmpno(empno);
		
		DbcpDAO dbcpDAO = new DbcpDAO();
		DbcpDTO dto = dbcpDAO.info(dbcpDTO);
//		request.setAttribute("dto", dto);
		response.getWriter().println(dto);
//		request.getRequestDispatcher("member.jsp").forward(request, response);
		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<style>td{ border: 1px solid black; width: 150px; padding: 3% }</style>");
//		out.println("<table>");
//			out.println("<tr>");
//				out.println("<td>");
//					out.println(dto.getEmpno());
//				out.println("</td>");
//				out.println("<td>");
//					out.println(dto.getEname());
//				out.println("</td>");
//				out.println("<td>");
//					out.println(dto.getJob());
//				out.println("</td>");
//				out.println("<td>");
//					out.println(dto.getMgr());
//				out.println("</td>");
//				out.println("<td>");
//					out.println(dto.getHiredate());
//				out.println("</td>");
//				out.println("<td>");
//					out.println(dto.getSal());
//				out.println("</td>");
//				out.println("<td>");
//					out.println(dto.getComm());
//				out.println("</td>");
//			out.println("</tr>");
//		out.println("</table>");
	}
}
