package com.inspur.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 共通文件(连接数据库)
 * @author Administrator
 *
 */
public class ConnectionUtil {

	/**
	 * 得到数据库连接对象
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.得到数据库连接对象
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:inspur01", "scott",
					"tiger");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 釋放数据库资源(检索系select)
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放数据库资源(更新系操作insert&update&delete)
	 * @param conn
	 * @param stmt
	 */
	public static void close(Connection conn,Statement stmt){
		try {
			if (stmt != null) {
				stmt.close();
				stmt = null;
			}

			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
