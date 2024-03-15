package loginSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDAO {
	
	private Connection con;
	private boolean loginChk = false;

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
	
	boolean userInfo(LoginDTO loginDTO) {
		
		connDB();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT * FROM userInfo";
		
		try {
			
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String user_id = rs.getString("user_id");
				String user_pass = rs.getString("user_pass");
				System.out.println("user_id" + user_id);
				if(user_id.equals(loginDTO.getUserId()) || user_pass.equals(loginDTO.getUserPass())) {
					
					loginChk = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(loginChk);
		return loginChk;
	}
}
