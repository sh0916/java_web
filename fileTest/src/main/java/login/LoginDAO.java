package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {

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
	
	LoginDTO info(LoginDTO loginDTO) {
		
		Connection con = conDB();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String userId = loginDTO.getUserId();
		String userPass = loginDTO.getUserPass();
		
		String query = "SELECT * FROM regi"
					+ " WHERE user_id='" + userId + "' AND user_pass='" + userPass + "'";
		
		try {
			
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			if( rs.next() ) {	
				String imgName = rs.getString("img_name");
				
				loginDTO.setImgName(imgName);
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
		
		return loginDTO;
	}
}
