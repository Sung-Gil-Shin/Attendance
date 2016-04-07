package dao;

import static jdbc.JdbcUtil.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			System.out.println(e + "=>����");
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
			System.out.println(e + "=> �ݱ� ����");
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

	public boolean login(String id,String passwd) {
		
		System.out.println(id);
		System.out.println(passwd);
		ResultSet rs = null;
		PreparedStatement ps = null;
		System.out.println("test123");
		String sql = "SELECT * FROM userdata WHERE id = ? AND passwd=?";
		boolean loginSuccess = false;
		try {		
			System.out.println("test");
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, passwd);		
			rs = ps.executeQuery();
			
			
			if (rs.next()) {			
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

}
