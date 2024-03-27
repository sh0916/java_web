package sec03.brd08.paging;

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
	
private Connection conDB() {
		
	Connection con = null;
		
		try {
			
			Context	ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			con = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	// 목록 조회
	public List<EmpDTO> selectEmp() {
		
		Connection con = conDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		String query = "SELECT * FROM emp3";
		
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while( rs.next() ) {	
				EmpDTO dto = new EmpDTO();
				
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
}
