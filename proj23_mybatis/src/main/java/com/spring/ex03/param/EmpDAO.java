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
	 * static : JVm(java.exe, 부팅) 이 실행될때
	 * 			new 하지 않고도 메모리에 바로 올라감
	 * static 메소드에서는 static 만 사용할 수 있음
	 * 가능하면 사용할때 클래스.변수 형태로 쓰자
	 */
	
	/*
	 * getInstance() 를 static 에 올려두는 이유는
	 * 메모리에 잡아두고 하나의 getInstance() 만 사용하기 위함(싱글톤)
	 */
	
	private static SqlSessionFactory sqlMapper = null;
	
	// 주석
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
	
	public EmpDTO selectEmpByEmpno(String empno) {
		
		EmpDTO empDTO = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				SqlSession sqlSession = sqlMapper.openSession();
				
				// select 결과가 없으면 null
				empDTO = sqlSession.selectOne("mapper.emp.param.selectEmpByEmpno", empno);
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return empDTO;
	}
	
	public int insertEmp(EmpDTO dto) {
		
		int result = -1;
		SqlSession sqlSession = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				sqlSession = sqlMapper.openSession();
				
				result = sqlSession.insert("mapper.emp.param.insertEmp", dto);
				
				// SQL 이 성공했을 경우 commit
				sqlSession.commit();
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			
			if(sqlSession != null) {								
				// SQL 이 실패했을 경우 rollback
				sqlSession.rollback();
			}
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int updateEmp(EmpDTO dto) {
		
		int result = -1;
		SqlSession sqlSession = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				
				// true 를 넣어주면 자동 commit 이 된다 대신 rollback 이 불가능하다
//				sqlSession = sqlMapper.openSession(true);
				sqlSession = sqlMapper.openSession();
				
				result = sqlSession.insert("mapper.emp.param.updateEmp", dto);
				
				// SQL 이 성공했을 경우 commit
				sqlSession.commit();
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			
			if(sqlSession != null) {								
				// SQL 이 실패했을 경우 rollback
				sqlSession.rollback();
			}
			
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteEmp(int empno) {
		
		int result = -1;
		SqlSession sqlSession = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				sqlSession = sqlMapper.openSession();
				
				result = sqlSession.insert("mapper.emp.param.deleteEmp", empno);
				
				// SQL 이 성공했을 경우 commit
				sqlSession.commit();
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			
			if(sqlSession != null) {								
				// SQL 이 실패했을 경우 rollback
				sqlSession.rollback();
			}
			
			e.printStackTrace();
		}
		
		return result;
	}
}
