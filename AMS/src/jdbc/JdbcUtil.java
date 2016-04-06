package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class JdbcUtil {	
	
	
	
	public static Connection getConnection(){
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			//���� ����Ǵ� ���� ��ü�� Context
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			//Resource ���ǿ� ���� Context�� ����
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
	         con = ds.getConnection();
			 con.setAutoCommit(false);		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	} // DB�۾��Ҷ� ������ �̹��� ������.
	public static void close(Connection con){
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		
	public static void commit(Connection con){
		try {
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con){
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
