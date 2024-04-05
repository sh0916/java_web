package com.spring.emp.service;

import java.util.List;

import com.spring.emp.dao.EmpDAO;
import com.spring.emp.dto.EmpDTO;

public class EmpServiceImpl implements EmpService {

	private EmpDAO empDAO;
	
	EmpServiceImpl() {
		
		System.out.println("EmpServiceImpl 생성");
	}
	
	public void setEmpDAO(EmpDAO empDAO) {
		
		System.out.println("EmpServiceImpl > setEmpDAO 호출");
		this.empDAO = empDAO;
	}
	
	@Override
	public List<EmpDTO> getEmpList() {
		
		return empDAO.selectEmp();
	}
}
