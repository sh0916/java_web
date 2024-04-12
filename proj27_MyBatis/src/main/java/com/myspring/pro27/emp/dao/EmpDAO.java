package com.myspring.pro27.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.pro27.emp.dto.EmpDTO;

@Repository
public class EmpDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<EmpDTO> selectEmpList() {
		
		List<EmpDTO> list = sqlSession.selectList("mapper.emp.selectEmp");
		return list;
	}
}
