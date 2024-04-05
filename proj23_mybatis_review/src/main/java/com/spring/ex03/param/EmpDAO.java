package com.spring.ex03.param;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	/*
	 * static : JVM(java.exe, 부팅)이 실행될때 
	 * 			new하지 않고도 메모리에 바로 올라감
	 * static메소드에서는 static만 사용할 수 있음
	 * 가능하면 사용할때 클래스.변수 형태로 쓰자
	 */
	private static SqlSessionFactory sqlMapper = null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper == null) {
			try {
				String res = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(res);
//				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				sqlMapper = ssfb.build(reader);
				
				reader.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sqlMapper;
	}
	
	public EmpDTO selectEmpByEmpno( String empno ) {
		EmpDTO dto = null;
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				// select 결과가 없으면 null
				dto = (EmpDTO) sqlSession.selectOne("mapper.emp.param.selectEmpByEmpno", empno);
			} else {
				System.out.println("DB 접속 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	public int insertEmp( EmpDTO dto ) {
		int result = -1;
		SqlSession sqlSession = null;
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
				sqlSession = sqlMapper.openSession();
				// select 결과가 없으면 null
				result = sqlSession.insert("mapper.emp.param.insertEmp", dto);
				sqlSession.commit();
			} else {
				System.out.println("DB 접속 실패");
			}
			
		}catch (Exception e) {
			if(sqlSession != null) {
				sqlSession.rollback();
			}
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	public int updateEmp( EmpDTO dto ) {
		int result = -1;
		SqlSession sqlSession = null;
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
//				sqlSession = sqlMapper.openSession(true);	// 자동 commit
				sqlSession = sqlMapper.openSession();
				// select 결과가 없으면 null
				result = sqlSession.insert("mapper.emp.param.updateEmp", dto);
//				result = sqlSession.insert("mapper.emp.param.seqWithInsert", dto);
//				System.out.println(dto.getId2());// insert에서 썻던 내용이 출력됨
				sqlSession.commit();
			} else {
				System.out.println("DB 접속 실패");
			}
			
		}catch (Exception e) {
			if(sqlSession != null) {
				sqlSession.rollback();
			}
			e.printStackTrace();
			
		}
		
		return result;
	}
}
