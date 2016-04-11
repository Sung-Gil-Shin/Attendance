package svc;

import static jdbc.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.LoginDAO;
import vo.UserData;

public class IdpswFindService {

	public String idpswView(String email, String name, int SocialNumPre, int SocialNumPost) {
		String reValue = null;
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		reValue = loginDAO.findidpswView(email, name, SocialNumPre, SocialNumPost);
		return reValue;
	}

}
