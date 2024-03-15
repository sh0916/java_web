package bank;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/bank")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BankBook balance = new BankBook();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("balance", balance);
		RequestDispatcher dispatch = request.getRequestDispatcher("bank.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		System.out.println(type);
		
		int bal = balance.getBalance();
		int amount = Integer.parseInt(request.getParameter("amount"));			
		
		Savings save = new Savings();
		
		int result = 0;
		
		if("deposit".equals(type)) {
			
			result = save.deposit(amount, bal);	
			
		} else if("withdrawal".equals(type)) {

			result = save.withdrawal(amount, bal);
		}
		
		balance.setBalance(result);
		
		request.setAttribute("balance", balance);
		RequestDispatcher dispatch = request.getRequestDispatcher("bank.jsp");
		dispatch.forward(request, response);
	}

}
