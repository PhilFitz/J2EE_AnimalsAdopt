package com.wkl.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static String url = "jdbc:mysql://39.106.36.212:3306/content?serverTimezone=GMT";
	static String username = "root";
	static String password = "Root!!2019";
//	static String url = "jdbc:mysql://localhost:3306/content?serverTimezone=GMT";
//	static String username = "root";
//	static String password = "123456";
	static  Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs;
	
	public static void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("init [SQL驱动程序初始化成功！]");
		} catch (Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	
	public static int addDelUpd(String sql) {
		int i = 0;
		try {
			ps = conn.prepareStatement(sql);
			i = ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("数据库增删改异常！");
			e.printStackTrace();
		}
		return i;
	}
	
	public static ResultSet select(String sql) {
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		}catch (Exception e) {
			System.out.println("数据库查询异常！");
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void closeConn() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("数据关闭异常！");
			e.printStackTrace();
		}
	}
}
