package com.inspur.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inspur.common.ConnectionUtil;

/**
 * ��½
 * @author Administrator
 *
 */
public class LoginDao {
	
	private Connection conn;
	
	private PreparedStatement pstmt;
	
	private ResultSet rs;
	
	/**
	 * �û���֤
	 * @param loginId 
	 * @param loginPass
	 * @return
	 */
	public boolean login(String loginId,String loginPass){
		
		boolean flag=false;//�Ƿ��½�ɹ��ı�־
		String sql="select loginpass from t_user where loginId=?";
		
		conn=ConnectionUtil.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				//��½ID��ȷ
				String pass=rs.getString("loginpass");
				//������ȷ
				if(loginPass.equals(pass)){
					flag=true;
				}
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionUtil.close(conn, pstmt, rs);
		}
		
		return flag;
		
	}
	
//	public static void main(String[] args) {
//		boolean flag=new LoginDao().login("1","12345");
//		System.out.println(flag?"��½�ɹ�":"��½ʧ��");
//	}
}
