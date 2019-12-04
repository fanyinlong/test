package com.zhiyou.model;

import java.util.Date;

public class Emp {

	private Integer EMPNO;
	private String ENAME;
	private String JOB;
	private Integer MGR;
	private Date HIREDATE;
	private Double SAL; 
	private Double COMM;
	private Integer DEPTNO;
	public Integer getEMPNO() {
		return EMPNO;
	}
	public void setEMPNO(Integer eMPNO) {
		EMPNO = eMPNO;
	}
	public String getENAME() {
		return ENAME;
	}
	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public Integer getMGR() {
		return MGR;
	}
	public void setMGR(Integer mGR) {
		MGR = mGR;
	}
	public Date getHIREDATE() {
		return HIREDATE;
	}
	public void setHIREDATE(Date hIREDATE) {
		HIREDATE = hIREDATE;
	}
	public Double getSAL() {
		return SAL;
	}
	public void setSAL(Double sAL) {
		SAL = sAL;
	}
	public Double getCOMM() {
		return COMM;
	}
	public void setCOMM(Double cOMM) {
		COMM = cOMM;
	}
	public Integer getDEPTNO() {
		return DEPTNO;
	}
	public void setDEPTNO(Integer dEPTNO) {
		DEPTNO = dEPTNO;
	}
	
	@Override
	public String toString() {
		return "Emp [EMPNO=" + EMPNO + ", ENAME=" + ENAME + ", JOB=" + JOB + ", MGR=" + MGR + ", HIREDATE=" + HIREDATE
				+ ", SAL=" + SAL + ", COMM=" + COMM + ", DEPTNO=" + DEPTNO + "]";
	}
	
	
}
