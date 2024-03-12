package sec02.ex01.dbcp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import sec02.ex01.dbcp.DbcpDTO;

public class DbcpDAO {
	
	private Connection con;

	private void connDB() {
		
		try {
			
			Context	ctx = new InitialContext();
			
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			try {
				
				this.con = dataFactory.getConnection();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<DbcpDTO> listEmp() {
		
		long begin = System.currentTimeMillis();
		
		connDB();

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<DbcpDTO> list = new ArrayList<DbcpDTO>();
		
		try {
			
			// SQL 준비
			String query = "SELECT * FROM emp2";
			
			ps = con.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();
			
			// 결과 활용
			// ResultSet rs : 조회된 결과 전체 => 2차원 배열 느낌
			// rs.next() 를 하고난 rs 는 다음줄 덩어리 => 1차원 배열 느낌
			while(rs.next()) {
				
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");

				System.out.println("empno : " + empno);
				
				DbcpDTO dbcpDTO = new DbcpDTO();
				dbcpDTO.setEmpno(empno);
				dbcpDTO.setEname(ename);
				dbcpDTO.setSal(sal);
				
				list.add(dbcpDTO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(this.con != null) {
				
				try {
					
					this.con.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("걸린 시간 : " + (end - begin));
		
		return list;
	}
	
	DbcpDTO info(DbcpDTO dbcpDTO) {
		
		int empno = dbcpDTO.getEmpno();
		
		connDB();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM emp2 WHERE empno = " + empno;
		
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int empno2 = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("deptno");
				int comm = rs.getInt("comm");
				
				dbcpDTO.setEmpno(empno2);
				dbcpDTO.setEname(ename);
				dbcpDTO.setJob(job);
				dbcpDTO.setMgr(mgr);
				dbcpDTO.setHiredate(hiredate);
				dbcpDTO.setSal(sal);
				dbcpDTO.setComm(comm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dbcpDTO;
	}
}
