package dao;


import static jdbc.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;


import vo.UserData;

public class LoginDAO {
	private static LoginDAO loginDAO;
	Connection con;
	Statement st;
	PreparedStatement ps;
	ResultSet rs;

	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";

	String jid = "java";
	String jpsw = "java";

	private LoginDAO() {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url, jid, jpsw);
		} catch (Exception e) {
			System.out.println(e + "=>실패");
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

	public void db_close() {

		try {

			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (st != null)
				st.close();

		} catch (SQLException e) {
			System.out.println(e + "=> 닫기 오류");
		}

	}

	public int insertUser(UserData userData) {
		int result = 0;
		String id = userData.getId();
		String passwd = userData.getPasswd();
		String name = userData.getName();
		int socialNumPre = userData.getSocialNumPre();
		int socialNumPost = userData.getSocialNumPost();
		String email = userData.getEmail();
		int phoneNum = userData.getPhoneNum();

		try {
			String sql = "INSERT INTO UserData (id,passwd,name,socialNumPre,socialNumPost,email,phoneNum,userNum,loginFlag,depNum,Permission,currentStatus) VALUES(?,?,?,?,?,?,?,UserData_seq.nextval,'f',0,0,'f')";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);
			ps.setString(3, name);
			ps.setInt(4, socialNumPre);
			ps.setInt(5, socialNumPost);
			ps.setString(6, email);
			ps.setInt(7, phoneNum);

			result = ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e + "=> memberInsert fail");

		} finally {
			db_close();
		}
		return result;

	}

	public boolean login(UserData userData) {

		ResultSet rs = null;
		PreparedStatement ps = null;
		ResultSet rs2 = null;
		PreparedStatement ps2 = null;
		String sql = "SELECT * FROM userdata WHERE id = ? AND passwd=?";
		String sql2 = "update userdata set loginflag ='t',currentstatus='t' WHERE id = ? AND passwd=?";
		
		boolean loginSuccess = false;
		try {		
			ps = con.prepareStatement(sql);
			ps.setString(1, userData.getId());
			ps.setString(2, userData.getPasswd());	
			rs = ps.executeQuery();
			
			if (rs.next()) {
			
	
				ps2 = con.prepareStatement(sql2);
				ps2.setString(1, userData.getId());
				ps2.setString(2, userData.getPasswd());	
				rs2 = ps2.executeQuery();
				
				loginSuccess = true;
			}else {
				loginSuccess = false;
			}

		} catch (Exception e) {
			System.out.println(e + "=> login fail");
		} finally {
			db_close();
		}
		return loginSuccess;
	}


	public boolean findIdpsw(UserData userData) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "SELECT * FROM userdata WHERE email=? AND name=? AND socialNumPre=? AND socialNumPost=?";
		boolean findSuccess = false;
		
		try {
			ps =con.prepareStatement(sql);
			ps.setString(1, userData.getEmail());
			ps.setString(2, userData.getName());		
			ps.setInt(3, userData.getSocialNumPre());		
			ps.setInt(4, userData.getSocialNumPost());		
			rs = ps.executeQuery();
			if (rs.next()) {	
				ArrayList<String> result = new ArrayList<String>();
				
				findSuccess = true;
				String id=rs.getString("id");
				String passwd=rs.getString("passwd");
				
			}else {
				findSuccess = false;
			}
		} catch (Exception e) {
			System.out.println(e + "=> find fail");
		}finally {
			db_close();
		}
		
		return findSuccess;
	}

	public UserData findidpswView(UserData userData) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "SELECT * FROM userdata WHERE email=? AND name=? AND socialNumPre=? AND socialNumPost=?";
		try {
			ps =con.prepareStatement(sql);
			ps.setString(1, userData.getEmail());
			ps.setString(2, userData.getName());		
			ps.setInt(3, userData.getSocialNumPre());		
			ps.setInt(4, userData.getSocialNumPost());		
			rs = ps.executeQuery();
		
			if (rs.next()) {			
				userData.setId(rs.getString("id")); 
				userData.setPasswd(rs.getString("passwd"));
				System.out.println(rs.getString("id"));
			}else{
				
			}
		} catch (Exception e) {
			System.out.println(e + "=> find View fail");
		}finally {
			db_close();
		}
		
		return userData;
	}

}
