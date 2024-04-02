package com.spring.ex01;

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
	
	public List<EmpDTO> selectAllEmpList() {
		
		List<EmpDTO> empList = null;
		
		// getInstance() 만 호출해도 EmpDAO.sqlMapper 에 담기게 되는데
		// 책에서는 return 받아서 쓰도록 되어있어서 큰의미는 없다
		// sqlMapper 는 그냥 사용하거나
		// 지역변수와 겹치는 경우 this.sqlMapper 보다는 EmpDAO.sqlMapper 로 쓰는게 더 좋다
		
		// SqlMapConfig.xml 을 읽어서
		// DB 접속 정보까지만 얻어옴
		sqlMapper = getInstance();
		
		// DB 접속
		SqlSession sqlSession = sqlMapper.openSession();
		empList = sqlSession.selectList("mapper.emp.selectAllEmpList");
		System.out.println("empList.size() : " + empList.size());
		
		return empList;
	}
	
	public String selectEname() {
		
		String ename = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				SqlSession sqlSession = sqlMapper.openSession();
				ename = sqlSession.selectOne("mapper.emp.selectEname");
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ename;
	}
	
	public Map<String, Object> selectEmpMap() {
		
		Map<String, Object> scottMap = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				SqlSession sqlSession = sqlMapper.openSession();
				scottMap = sqlSession.selectOne("mapper.emp.selectEmpMap");
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return scottMap;
	}
	
	public EmpDTO selectEmpResult() {
		
		EmpDTO empDTO = null;
		
		try {
			sqlMapper = getInstance();
			
			if(sqlMapper != null) {				
				SqlSession sqlSession = sqlMapper.openSession();
				empDTO = sqlSession.selectOne("mapper.emp.selectEmpResult");
			} else {
				System.out.println("DB 접속 실패");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return empDTO;
	}
}
