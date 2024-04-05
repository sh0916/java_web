package com.spring.ex01;

import java.sql.Date;

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
	int sal;
	int comm;
	int deptno;
	
	int lv;
	int rnum;
	
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
	@Override
	public String toString() {
		return "EmpDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgr=" + mgr + ", hiredate="
				+ hiredate + ", sal=" + sal + ", comm=" + comm + ", deptno=" + deptno + ", lv=" + lv + ", rnum=" + rnum
				+ "]";
	}

}
