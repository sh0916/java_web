package com.spring.emp.dao;

import java.util.List;

import com.spring.emp.dto.EmpDTO;

public interface EmpDAO {

	public List<EmpDTO> selectEmp();
}
