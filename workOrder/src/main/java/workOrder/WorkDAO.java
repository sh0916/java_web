package workOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	void insert(WorkDTO workDTO) {
		
		Connection con = dbSet();
		PreparedStatement ps = null;
		
		String title = workDTO.getTitle();
		String detail = workDTO.getDetail();
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date hiredate = null; 
		
		try {
			
			hiredate = sdf.parse(sdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			String query = " INSERT INTO workOrderTable(sequence, title, detail, hiredate)"
						+ " VALUES(workOrderSequence.NEXTVAL, ?, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI'))";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, title);
			ps.setString(2, detail);
			String hiredateString = sdf.format(hiredate);
		    ps.setString(3, hiredateString);
			
		    ps.executeUpdate();
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
		}
	}
	
	void update(WorkDTO workDTO) {
		
		Connection con = dbSet();
		PreparedStatement ps = null;
		
		int seq = workDTO.getSeq();
		String title = workDTO.getTitle();
		String detail = workDTO.getDetail();
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date hiredate = null; 
		
		try {
			
			hiredate = sdf.parse(sdf.format(now));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
			String query = " UPDATE workOrderTable"
						+ " SET title=?, detail=?, hiredate=TO_DATE(?, 'YYYY-MM-DD HH24:MI')"
						+ " WHERE sequence=?";
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, title);
			ps.setString(2, detail);
			String hiredateString = sdf.format(hiredate);
		    ps.setString(3, hiredateString);
		    ps.setInt(4, seq);
			
		    ps.executeUpdate();
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
		}
	}
	
	void delete(int seq) {
		
		Connection con = dbSet();
		PreparedStatement ps = null;
				
		try {
			
			String query = " DELETE workOrderTable WHERE sequence=?";
			ps = con.prepareStatement(query);
			
			ps.setInt(1, seq);
			
			ps.executeUpdate();
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
		}
	}
}
