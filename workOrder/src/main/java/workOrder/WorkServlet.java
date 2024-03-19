package workOrder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WorkServlet
 */
@WebServlet("/work")
public class WorkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		WorkDAO workDAO = new WorkDAO();
		System.out.println("get 들어옴");
		List<WorkDTO> list = workDAO.select();
		
		request.setAttribute("list", list);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String type = request.getParameter("type");
		
		if("add".equals(type)) {
			
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
//			Date now = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			Date hiredate = sdf.parse(sdf.format(now));
			
			WorkDTO workDTO = new WorkDTO();
			workDTO.setTitle(title);
			workDTO.setDetail(detail);
//			workDTO.setHiredate(now);)
			System.out.println("담김");
			
			WorkDAO workDAO = new WorkDAO();
			workDAO.insert(workDTO);
		} else if("update".equals(type)) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			
			WorkDTO workDTO = new WorkDTO();
			workDTO.setSeq(seq);
			workDTO.setTitle(title);
			workDTO.setDetail(detail);
			
			WorkDAO workDAO = new WorkDAO();
			workDAO.update(workDTO);
		} else if("delete".equals(type)) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			WorkDAO workDAO = new WorkDAO();
			workDAO.delete(seq);
		}
		
		response.sendRedirect("work");
	}

}
