package kr.or.human;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.human.emp.dao.EmpDAO;
import kr.or.human.emp.dto.EmpDTO;
import kr.or.human.emp.view.EmpView;


@WebServlet("/init")
public class DDLTestServlet extends HttpServlet {
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
		empDTO.setDeptno(empno);
	}
	
	void controller(HttpServletRequest request, HttpServletResponse response) {
		
		// 한글 깨짐 방지
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
				
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";		
		String user = "scott4_4";
		String password = "tiger";
		
		try {
			
			// 드라이버 로딩
			// Class.forName : String 변수로 class 생성
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			
			// DB 접속
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection 생성 성공");
			
//			String name = "SCOTT";
			String name = request.getParameter("name");
			
			// SQL 작성
			String query = "";
			query += " CREATE TABLE emp2";
			query += " AS SELECT"
					+ " *";
			query += " FROM"
					+ " emp";

			
			// SQL 실행 준비
			PreparedStatement ps = con.prepareStatement(query);

			
			// SQL 실행, ResultSet 로 결과 확보
			int result = ps.executeUpdate();
			System.out.println("create table result : " + result);
			
			// select : executuQuery()
			//			return : ResultSet
			// 그 외  : executeUpdate(
			//			return : int(몇개의 row 가 영향을 받았는지)
			
			// DB 값을 활용
			// 		ResultSet 에는 모든 줄이 담겨져 있음
			// 		re.next() : 다음줄이 있는지 여부
			// 		next() 실행 후에 ResultSet 에는 다음줄이 담김
			
			
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
