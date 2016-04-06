package dao;

import static jdbc.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vo.UserData;

public class LoginDAO {
	private static LoginDAO loginDAO;
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;

	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	
	String id = "java";
	String psw = "java";
	
	private LoginDAO() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,id,psw);
		} catch (Exception e) {
			 System.out.println(e+"=>실패");	 
		}
	}
	public void setConnection(Connection con) {
		this.con = con;		
	}

	public static LoginDAO getInstance() {
		if (loginDAO == null) {
			loginDAO = new LoginDAO();
		}
		return loginDAO;
	}
	
	public void db_close(){
	       
        try {
           
            if (rs != null ) rs.close();
            if (ps != null ) ps.close();      
            if (st != null ) st.close();
       
        } catch (SQLException e) {
            System.out.println(e+"=> 닫기 오류");
        }      
       
    }

	public int insertUser(UserData userData) {
		int result = 0;
		try {
			String sql = "INSERT INTO UserData VALUES(?,?,?,?,?,?,?,?,?,UserData_seq.nextVAL,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, userData.getId());
			ps.setString(2, userData.getPasswd());
			ps.setString(3, userData.getName());
			ps.setInt(4, userData.getSocialNumPre());
			ps.setInt(5, userData.getSocialNumPost());
			ps.setString(6, userData.getEmail());
			ps.setInt(7, userData.getPhoneNum());
			ps.setInt(8, 0);
			ps.setInt(9, 0);
			ps.setString(10, "F");
			ps.setString(11, "F");
			result = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e + "=> memberInsert fail");

		} finally {
			db_close();
		}
		return result;

	}

}
