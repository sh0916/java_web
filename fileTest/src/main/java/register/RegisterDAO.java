package register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class RegisterDAO {

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
	
	void regi(RegisterDTO loginDTO) {
		
		Connection con = conDB();
		PreparedStatement ps = null;
		System.out.println(loginDTO.toString());
		String userId = loginDTO.getUserId();
		String userPass = loginDTO.getUserPass();
		String imgName = loginDTO.getImgName();
		
		String query =  " INSERT INTO regi(user_id, user_pass, img_name)"
					+ " VALUES(?, ?, ?)";
		
		try {
			
			ps = con.prepareStatement(query);
			
			ps.setString(1, userId);
			ps.setString(2, userPass);
			ps.setString(3, imgName);
			
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
