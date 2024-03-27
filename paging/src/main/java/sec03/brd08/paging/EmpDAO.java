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
	public List<EmpDTO> selectEmp(int choPage) {
		
		Connection con = conDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		String query = "SELECT * FROM (";
				query += " SELECT rownum rnum, t1.* FROM (";
				query += " SELECT emp3.* FROM emp3 ORDER BY empno";
				query += 								") t1";
				query += 			")";
				query += " WHERE rnum >= ( (10 * ?) - (10 - 1) ) AND rnum <= (10 * ?)";
				System.out.println(query);
		
		try {
			System.out.println("DAOChoPage :" + choPage);
			ps = con.prepareStatement(query);
			ps.setInt(1, choPage);
			ps.setInt(2, choPage);
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
	
	public int bordCount() {
		
		Connection con = conDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT COUNT(*) count FROM emp3";
		int count = 0;
		
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while( rs.next() ) {	
				EmpDTO dto = new EmpDTO();
				
				count = rs.getInt("count");
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
		
		return count;
	}
}
