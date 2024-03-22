package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDAO {

	Connection dbInfo() {
		
		Connection con = null;
		
		try {
			
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			con = dataFactory.getConnection();
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
	List<EmpDTO> select() {
		
		Connection con = dbInfo();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		String query = "SELECT * FROM emp2";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				String empno = rs.getString("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int sal = rs.getInt("sal");
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setJob(job);
				empDTO.setSal(sal);
				
				list.add(empDTO);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			

			if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (ps != null) {
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		}
		return list;
	}
}
