package com.spring.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// Bean 으로 등록
// 보통 DAO 클래스에서 사용
@Repository
public class MemberDAOImpl2 implements MemberDAO {

	MemberDAOImpl2() {
		
		System.out.println("MemberDAOImpl2 생성자");
	}
	
	@Override
	public List selectMember() {
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		return list;
	}

}
