package com.myspring.pro27.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.pro27.emp.dao.EmpDAO;
import com.myspring.pro27.emp.dto.EmpDTO;

@Service
public class EmpService {

	@Autowired
	private EmpDAO empDAO;
	
	public List<EmpDTO> listEmp() {
		
		return empDAO.selectEmpList();
	}
}
