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
		
		WorkDAO workDAO = new WorkDAO();
		System.out.println("get 들어옴");
		List<WorkDTO> list = workDAO.select();
		
		request.setAttribute("list", list);
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String formattedDate = sdf.format(now);
		System.out.println(formattedDate);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		
		if("add".equals(type)) {
			
			String title = request.getParameter("title");
			String detail = request.getParameter("detail");
			
			WorkDTO workDTO = new WorkDTO();
			workDTO.setTitle(title);
			workDTO.setDetail(detail);
			
			WorkDAO workDAO = new WorkDAO();
			
		}
	}

}
