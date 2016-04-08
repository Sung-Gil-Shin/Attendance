package svc;

import static jdbc.JdbcUtil.commit;
import static jdbc.JdbcUtil.getConnection;
import static jdbc.JdbcUtil.rollback;

import java.sql.Connection;

import dao.LoginDAO;
import vo.UserData;

public class LoginService {

	public boolean LoginUser(UserData userData) {
		boolean loginSuccess = false;
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		boolean insertCount = loginDAO.login(userData);
		if (insertCount) {
			loginSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		return loginSuccess;
	}
}
