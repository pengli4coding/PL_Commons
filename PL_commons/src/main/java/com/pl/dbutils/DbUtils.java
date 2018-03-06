package com.pl.dbutils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbUtils {
	/**
	 * 
	 * @Description:获取数据库连接Connection
	 * @author 小立立
	 * @date 2018年3月6日 上午11:15:54
	 * @param propName
	 * @return
	 */
	public static Connection getConn(String propName) {
		InputStream in = DbUtils.class.getClassLoader().getResourceAsStream(propName);
		Properties prop = new Properties();
		Connection conn = null;
		try {
			prop.load(in);
			String driverClass = prop.getProperty("driverClass");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			// 注册驱动
			Class.forName(driverClass);
			// 如果username和password为空的情况是sqlite数据，这样的连接也是可以连接的
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * @Description:获取PreparedStatement
	 * @author 小立立
	 * @date 2018年3月6日 上午11:15:40
	 * @param sql
	 * @param propName
	 * @return
	 */
	public static PreparedStatement getPstmt(String sql, String propName) {
		Connection conn = getConn(propName);
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * 
	 * @Description:关闭需要更新数据操作的相关资源（一般涉及到PreparedStatement）
	 * @author 小立立
	 * @date 2018年3月6日 上午10:48:44
	 * @param ps
	 */
	public static void closeUpdateRes(PreparedStatement ps) {
		if (ps != null) {
			try {
				Connection conn = ps.getConnection();
				ps.close();
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @Description:关闭需要更新数据操作的相关资源（一般涉及到ResultSet）
	 * @author 小立立
	 * @date 2018年3月6日 上午10:50:19
	 * @param rs
	 */
	public static void closeQueryRes(ResultSet rs) {
		if (rs != null) {
			Statement pstmt;
			try {
				pstmt = rs.getStatement();
				if (pstmt != null) {
					Connection conn = pstmt.getConnection();
					rs.close();
					pstmt.close();
					if (conn != null) {
						conn.close();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
