package com.zhiyou.dao.impl;

import java.util.List;

import com.zhiyou.dao.EmpDAO;
import com.zhiyou.model.Emp;
import com.zhiyou.util.JDBCUtil;

public class EmpDaoImpl implements EmpDAO{

	@Override
	public void add(Emp e) {
		String sql="insert into emp(empno) values(?)";
		JDBCUtil.dbDML(sql, e.getEMPNO());
	}

	@Override
	public void delete(Emp e) {
		String sql="delete from emp where empno=?";
		JDBCUtil.dbDML(sql, e.getEMPNO());
	}

	@Override
	public void update(Emp e) {
		String sql="update emp set ename =? where empno=?";
		JDBCUtil.dbDML(sql, e.getENAME(),e.getEMPNO());
	}

	@Override
	public List<Emp> selectAll() {
		// TODO Auto-generated method stub
		return JDBCUtil.dbDQL("select * from emp", Emp.class);
	}

}
