package com.spring.emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.emp.dto.EmpDTO;

public class EmpDAOImpl implements EmpDAO {

	private SqlSession sqlSession;
	
	EmpDAOImpl() {
		
		System.out.println("EmpDAOImpl 생성");
	}

	public void setSqlSession(SqlSession sqlSession) {
		
		System.out.println("EmpDAOImpl  > setSqlSession 호출");
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<EmpDTO> selectEmp() {
		
		// DB 연결 준비
		// DB 연결
		// SQL 실행
		// 결과 확보
		return sqlSession.selectList("mapper.emp.selectEmp");
	}
}
