package sec01.ex01.jdbc.part;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@112.148.46.134:51521:xe";
	private String user = "scott4_4";
	private String password = "tiger";
	private Connection con;
	
	private void connDB() {
		
		try {
			
			// Class.forName : String 변수로 class 생성한다
			// 드라이버 : 서로 다른 것들(java, oracle)이 소통할 수 있게 해주는 것
			// 오라클 드라이버 로딩
			Class.forName(this.driver);
			// OracleDriver drive = new OracleDriver();
			
			// DB 접속
			this.con = DriverManager.getConnection(this.url, this.user, this.password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<EmpDTO> listEmp() {
		
		connDB();

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
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
				
				EmpDTO empDTO = new EmpDTO();
				empDTO.setEmpno(empno);
				empDTO.setEname(ename);
				empDTO.setSal(sal);
				
				list.add(empDTO);
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
		
		return list;
	}
}
