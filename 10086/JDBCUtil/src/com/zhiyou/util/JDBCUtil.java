package com.zhiyou.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtil {
	// 驱动名
	public static final String DRIVER_NAME="com.mysql.jdbc.Driver";
	// 数据库账号
	public static final String USER_NAME="root";
	// 数据库密码
	public static final String PASS_WORD="123456";
	//数据库名称
	public static final String DB_NAME="test";
	//数据库的URL
	public static final String URL="jdbc:mysql:///"+DB_NAME;
	
	static {// 如果有某些代码只需要在类被加载的时候执行一次,可以放到静态块中		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得数据库连接
	 * @return	Connection
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con=DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 数据库通用增,删,改方法
	 * 方法参数为：SQL,及SQL中的占位符参数
	 */
	public static boolean dbDML(String sql,Object...objects){
		Connection con = getConnection();
		PreparedStatement ps=null;
		try {
			ps = con.prepareStatement(sql);
			//  把参数放到对应的占位符之中,经过这一步所有的参数都在占位符之中了sql 已经完整
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]);
			}
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(con,ps);
		}
	}
	
	public static <E>List<E> dbDQL(String sql,Class<E> class1,Object...objects){
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<E> list = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			//  传入参数,完善sql语句
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i+1, objects[i]);
			}
			// 获得数据库中所有的列名称
			ResultSetMetaData data = ps.getMetaData();
			// 声明一个字符串数组,长度为数据库表中列的数量
			String [] names = new String [data.getColumnCount()];			
			for (int i = 0; i < names.length; i++) {
				//   获得每一列的名称,然后把值赋值给字符串数组names,data的下标从1开始
				String name=data.getColumnLabel(i+1);
				names[i]=name;
			}
			rs = ps.executeQuery();
			while(rs.next()) { // 循环行
				// 根据传入的class获取一个实例对象
				E o = class1.newInstance();
				// 循环数据库列名称    (数据库列名称与model属性名称保持一致)
				for (String string : names) {	//循环列
					//  第一行数据 所有值
					Object value = rs.getObject(string);
					Field field = class1.getDeclaredField(string);
					// 公开属性权限
					field.setAccessible(true);
					field.set(o, value);
				}
				list.add(o);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list;
	}
	
	
	
	
	/**
	 * 关闭 数据库连接
	 * @param con
	 */
	private static void close(Connection con) {
		try {
			if (con!=null) {
				con.close();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 关闭 PreparedStatement
	 * @param con
	 */
	private static void close(PreparedStatement ps) {
		try {
			if (ps!=null) {
				ps.close();
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭 ResultSet
	 * @param con
	 */
	private static void close(ResultSet set) {
		try { 
			if (set!=null) {
				set.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * DML 时调用的close()
	 * @param con
	 * @param ps
	 */
	private static void close(Connection con,PreparedStatement ps) {		
		close(ps);
		close(con);
	}
	/**
	 * DQL时调用的close
	 * @param con
	 * @param ps
	 * @param set
	 */
	public static void close(Connection con,PreparedStatement ps,ResultSet set) {
		close(set);
		close(ps);
		close(con);
	}
}
