package com.spring.member.dao;

import javax.sql.DataSource;

public class MemberDAO {

	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
