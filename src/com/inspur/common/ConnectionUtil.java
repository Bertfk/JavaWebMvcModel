package com.inspur.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��ͨ�ļ�(�������ݿ�)
 * @author Administrator
 *
 */
public class ConnectionUtil {

	/**
	 * �õ����ݿ����Ӷ���
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.�õ����ݿ����Ӷ���
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
	 * ጷ����ݿ���Դ(����ϵselect)
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
	 * �ͷ����ݿ���Դ(����ϵ����insert&update&delete)
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
