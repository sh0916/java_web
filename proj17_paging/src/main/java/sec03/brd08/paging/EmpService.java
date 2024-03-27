package sec03.brd08.paging;

import java.util.List;

public class EmpService {

	List<EmpDTO> listEmp() {
		
		EmpDAO empDAO = new EmpDAO();
		List<EmpDTO> list = empDAO.selectEmp();
		
		return list;
	}
}
