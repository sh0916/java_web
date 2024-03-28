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
	public List<EmpDTO> selectEmp(int start, int end) {
		
		Connection con = conDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		String query = " SELECT * FROM (" +
					    " 				SELECT rownum rnum, t1.* FROM (" +
					    " 					WITH emp_recu (lv, empno, mgr, ename) AS (" +
					    " 					SELECT 1 AS lv, empno, mgr, ename FROM emp4 WHERE mgr IS NULL " +
					    " 					UNION ALL " +
					    " 					SELECT er.lv + 1 AS lv, e.empno, e.mgr, e.ename FROM emp_recu er " +
					    " 					LEFT OUTER JOIN emp4 e ON e.mgr = er.empno WHERE e.mgr IS NOT NULL) " +
					    " 					SEARCH DEPTH FIRST BY empno SET sort_empno " +
					    " 					SELECT * FROM emp_recu ORDER BY sort_empno" +
					    "				) t1" +
					    ") t2 WHERE rnum >= ? AND rnum <= ?";
		
		try {
			
//			ps = con.prepareStatement(query);
			ps = new LoggableStatement(con, query);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			System.out.println( ((LoggableStatement) ps).getQueryString() );
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {	
				EmpDTO dto = new EmpDTO();
				
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setLv(rs.getInt("lv"));
				dto.setRnum(rs.getInt("rnum"));
				
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
	
	// 전체 개수 조회
	public int selectTotalEmp() {
	
		int totalCount = -1;	
		
		Connection con = conDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = " SELECT count(*) AS cnt FROM emp4";
		
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while( rs.next() ) {	
				EmpDTO dto = new EmpDTO();
				
				totalCount = rs.getInt("cnt");
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
		
		return totalCount;
	}
}
