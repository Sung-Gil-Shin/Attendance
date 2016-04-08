package svc;

import static jdbc.JdbcUtil.*;
import java.sql.Connection;

import dao.LoginDAO;
import vo.UserData;

public class IdpswFindService {


	public boolean idpswFind(UserData userData) {
		boolean findSuccess = false;
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean findflag = loginDAO.findIdpsw(userData);
		
		if (findflag) {
			findSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		return findSuccess;
	}

	public UserData idpswView(UserData userData) {
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		UserData idpswView =
				loginDAO.findidpswView(userData);
		
		return idpswView;
	}

}
