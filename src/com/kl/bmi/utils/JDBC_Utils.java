package com.kl.bmi.utils;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

/**
 * jdbc������
 * 
 * @author ������
 *
 */

public class JDBC_Utils {
	
	private static final String driver ="com.mysql.jdbc.Driver";
	
	private static final String url ="jdbc:mysql://localhost:3306/bmi";
	
	private static final String uName = "root";
	
	private static final String uPwd = "root";@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}public JDBC_Utils() {
		// TODO Auto-generated constructor stub
	}
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException("��ȡ�����쳣������");
		}	
     }
	
	/**
	 * ��ȡ����
	 * @return һ�����Ӷ���
	 *
	 */
		public static Connection getConnection(){
			try {
				Connection connection = DriverManager.getConnection(url,uName,uPwd);
			    return connection;
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new RuntimeException("��ȡ�����쳣������");
			}	
		}
		
		/**
		 * ��ɾ�ķ���
		 * @param sql
		 * @param params
		 * @return ���ͣ�����0 success��
		 */
		public static int executeUpdate(String sql,Object...params) {
			Connection connection = getConnection();
			PreparedStatement ps = null;
			try {
			    ps = connection.prepareStatement(sql);
			    for (int i = 0; i < params.length; i++) {					
			    	ps.setObject(i+1, params[i]);	
				}
			    int i = ps.executeUpdate();
			    return i;
			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("�����쳣������");
			}finally {
				close(null, ps, connection);
			}
			
		}
		/**
		 * �ر���
		 * @param resultSet
		 * @param ps
		 * @param con
		 */
		public static void close(ResultSet resultSet,PreparedStatement ps,Connection con) {
			
			if (resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
