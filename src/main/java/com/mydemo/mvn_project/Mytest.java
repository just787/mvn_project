package com.mydemo.mvn_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mytest {
	public static void main(String[] args) throws SQLException {
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}

		// 连接MySql数据库
		String url = "jdbc:mysql://192.168.1.157:3306/slb_cfg";
		String username = "root";
		String password = "123456";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}

		/*
		 * 创建一个Statement •要执行SQL语句，必须获得java.sql.Statement实例，Statement实例分为以下3
		 * 种类型： 1、执行静态SQL语句。通常通过Statement实例实现。
		 * 2、执行动态SQL语句。通常通过PreparedStatement实例实现(预编译过,适合执行重复多次的语句,且可防止sql注入)。
		 * 3、执行数据库存储过程。通常通过CallableStatement实例实现。
		 */
		String slq = "SELECT * from slb_cfg.`user` WHERE userid = ? AND `name` = ?;";
		PreparedStatement pstmt = null;
		pstmt = con.prepareStatement(slq);
		// 设置参数
		pstmt.setString(1, "wdl");
		pstmt.setString(2, "wdl1");

		// 查询得到结果
		ResultSet rs = null;
		rs = pstmt.executeQuery();

		// 遍历结果
		while (rs.next()) {
			System.out.println(
			        rs.getString(1) + "--" + rs.getString(2) + "--" + rs.getString(3) + "--" + rs.getString(4));
		}

		// 关闭连接
		if (rs != null) { // 关闭记录集
			rs.close();
		}
		if (pstmt != null) { // 关闭声明
			pstmt.close();
		}
		if (con != null) { // 关闭连接对象
			con.close();
		}
	}
}
