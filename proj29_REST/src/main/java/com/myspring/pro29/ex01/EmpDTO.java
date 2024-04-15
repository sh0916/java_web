package com.myspring.pro29.ex01;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class EmpDTO {
//	EMPNO	NUMBER(4,0)
//	ENAME	VARCHAR2(10 BYTE)
//	JOB	VARCHAR2(9 BYTE)
//	MGR	NUMBER(4,0)
//	HIREDATE	DATE
//	SAL	NUMBER(7,2)
//	COMM	NUMBER(7,2)
//	DEPTNO	NUMBER(2,0)
	
	int empno;
	String ename;
	String job;
	int mgr;
	Date hiredate;
	int sal = -1;
	int comm;
	int deptno;
	
	int lv;
	int rnum;
	
	String type;
	String keyword;
	
	String orderColumn;
	String orderType;
	
	String[] chks;
	
	/**
	 * @return the empno
	 */
	public int getEmpno() {
		return empno;
	}
	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}
	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}
	/**
	 * @return the mgr
	 */
	public int getMgr() {
		return mgr;
	}
	/**
	 * @param mgr the mgr to set
	 */
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}
	/**
	 * @return the hiredate
	 */
	public Date getHiredate() {
		return hiredate;
	}
	/**
	 * @param hiredate the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	/**
	 * @return the sal
	 */
	public int getSal() {
		return sal;
	}
	/**
	 * @param sal the sal to set
	 */
	public void setSal(int sal) {
		this.sal = sal;
	}
	/**
	 * @return the comm
	 */
	public int getComm() {
		return comm;
	}
	/**
	 * @param comm the comm to set
	 */
	public void setComm(int comm) {
		this.comm = comm;
	}
	/**
	 * @return the deptno
	 */
	public int getDeptno() {
		return deptno;
	}
	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	/**
	 * @return the lv
	 */
	public int getLv() {
		return lv;
	}
	/**
	 * @param lv the lv to set
	 */
	public void setLv(int lv) {
		this.lv = lv;
	}
	/**
	 * @return the rnum
	 */
	public int getRnum() {
		return rnum;
	}
	/**
	 * @param rnum the rnum to set
	 */
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * @return the orderColumn
	 */
	public String getOrderColumn() {
		return orderColumn;
	}
	/**
	 * @param orderColumn the orderColumn to set
	 */
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}
	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the chks
	 */
	public String[] getChks() {
		return chks;
	}
	/**
	 * @param chks the chks to set
	 */
	public void setChks(String[] chks) {
		this.chks = chks;
	}
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + ", lv=" + lv + ", rnum=" + rnum
				+ "]";
	}

}
