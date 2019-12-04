package com.zhiyou.text;

import java.util.List;

import com.zhiyou.dao.EmpDAO;
import com.zhiyou.dao.impl.EmpDaoImpl;
import com.zhiyou.model.Emp;

public class MainClass {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDaoImpl();
		Emp e = new Emp(); e.setEMPNO(800); e.setENAME("уехЩ");
		//dao.add(e);
		//dao.update(e);
		dao.delete(e);
		List<Emp> list = dao.selectAll();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
}
