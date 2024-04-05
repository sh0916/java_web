package com.spring.ex04.dynamic;

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
	
	public List getEmpList(EmpDTO dto) {
		List list = null;
		try {
			sqlMapper = getInstance();
			if(sqlMapper != null) {
				SqlSession sqlSession = sqlMapper.openSession();
				// select 결과가 없으면 null
//				list = sqlSession.selectList("mapper.emp.dynamic.selectEmp", dto);
				list = sqlSession.selectList("mapper.emp.dynamic.selectEmp2", dto);
			} else {
				System.out.println("DB 접속 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
