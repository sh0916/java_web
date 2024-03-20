package kr.or.human.emp.view;

import java.sql.Date;
import java.util.List;

import kr.or.human.emp.dto.EmpDTO;


public class EmpView {

	public StringBuffer drawList(List list) {
		
		StringBuffer sb = new StringBuffer();
		
		// StringBuffer 타입을 toString() 으로 String 타입으로 변경해줌
//		String str = sb.toString();
		
		sb.append("<table border=1>");
		
		for(int i = 0; i < list.size(); i++) {
			
			// list 안의 Map 타입의 값을 다시 Map 타입으로 변경해서 꺼냄
//			Map map = (Map)list.get(i);
//			int empno = (int)map.get("empno");
//			String ename = (String)map.get("ename");
//			Date hiredate = (Date)map.get("hiredate");
			
			EmpDTO dto = (EmpDTO)list.get(i);
			int empno = dto.getEmpno();
			String ename = dto.getEname();
			Date hiredate = dto.getHiredate();
			
			
			sb.append("	<tr>");
			sb.append("		<td>");
			sb.append(empno);
			sb.append("		</td>");
			sb.append("		<td>");
			sb.append(ename);
			sb.append("		</td>");
			sb.append("		<td>");
			sb.append(hiredate);
			sb.append("		</td>");
			sb.append("	</tr>");
		}
		
		sb.append("</table>");
		System.out.println(sb);
		return sb;
	}
	
}
