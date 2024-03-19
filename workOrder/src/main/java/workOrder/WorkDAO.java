package workOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class WorkDAO {

	Connection dbSet() {
		
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
	
	List<WorkDTO> select() {

		Connection con = dbSet();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<WorkDTO> list = new ArrayList<WorkDTO>();
				
		try {
			
			String query = " SELECT * FROM workOrderTable";

			ps = con.prepareStatement(query);
			rs = ps.executeQuery(); 

			while( rs.next() ) {
				
				int seq = rs.getInt("sequence");
				String title = rs.getString("title");
				String detail = rs.getString("detail");
				Date hiredate = rs.getDate("hiredate");
				
				WorkDTO workDTO = new WorkDTO();
				
				workDTO.setSeq(seq);
				workDTO.setTitle(title);
				workDTO.setDetail(detail);
				workDTO.setHiredate(hiredate);
				
				list.add(workDTO);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	void insert() {
		
		Connection con = dbSet();
		PreparedStatement ps = null;
		
		try {
			
			String query = " INSERT INTO workOrderTable(sequence, title, detail, hiredate)"
						+ " VALUES(workOrderSequence.NEXTVAL, ?, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI'))";
			
			ps = con.prepareStatement(query);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
