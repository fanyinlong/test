package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.Emp;

// EMP 的DAO 接口
public interface EmpDAO {
	// 增
	void add(Emp e);
	// 删
	void delete(Emp e);
	// 改
	void update(Emp e); 
	// 查
	List<Emp> selectAll();
	
}
