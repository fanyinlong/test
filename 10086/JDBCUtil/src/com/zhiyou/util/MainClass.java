package com.zhiyou.util;

import java.util.List;

import com.zhiyou.model.Dept;
import com.zhiyou.model.Emp;
import com.zhiyou.model.User;

public class MainClass {

	public static void main(String[] args) {
		List<Emp> list = JDBCUtil.dbDQL("select * from emp", Emp.class);
		for (Emp emp : list) {
			System.out.println(emp);
		}
		System.out.println("*****************************************");
		List<Dept> list2 = JDBCUtil.dbDQL("select * from dept", Dept.class);
		for (Dept dept : list2) {
			System.out.println(dept);
		}
		System.out.println("*****************************************");
		String sql="select * from user where username=? and password =?";
		List<User> list3 = JDBCUtil.dbDQL(sql, User.class, "qq",123);		
		for (User user : list3) {
			System.out.println(user);
		}		
		JDBCUtil.dbDML("insert into user (name) values(?)", "Íú²Æ");
		User u = new User(1,"Ð¡»¨",500,"ÄÐ","haha","123213");
		JDBCUtil.dbDML("insert into user  values(?,?,?,?,?,?)", u.getId(),u.getName(),u.getAge(),u.getSex(),u.getUsername(),u.getPassword());
		
	}
}
