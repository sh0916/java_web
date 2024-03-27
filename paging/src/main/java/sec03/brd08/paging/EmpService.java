package sec03.brd08.paging;

import java.util.List;

public class EmpService {
	
	int pageNum = 10;
	int choPage = 1;
	
	List<EmpDTO> listEmp() {
		
		return listEmp(this.choPage);
	}

	List<EmpDTO> listEmp(int choPage) {
		
		EmpDAO empDAO = new EmpDAO();
		List<EmpDTO> list = empDAO.selectEmp(choPage);
		
		return list;
	}
	
	int bordCount() {
		
		EmpDAO empDAO = new EmpDAO();
		int count = empDAO.bordCount();
		
		int totalPage = count / this.pageNum;
		
		if( !(count % this.pageNum == 0) ) {
			totalPage += 1;
		}
		
		return totalPage;
	}
}
