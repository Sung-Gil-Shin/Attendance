package svc;

import static jdbc.JdbcUtil.commit;
import static jdbc.JdbcUtil.getConnection;
import static jdbc.JdbcUtil.rollback;

import java.sql.Connection;

import dao.LoginDAO;
import vo.UserData;
import static jdbc.JdbcUtil.*;

public class SignUpService {

	public boolean signUpUser(UserData user) {
		boolean signUpSuccess=false;
		Connection con = getConnection();
		LoginDAO loginDAO = LoginDAO.getInstance();
		loginDAO.setConnection(con);
		int insertCount = loginDAO.insertUser(user);
		if(insertCount > 0){
			signUpSuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		return signUpSuccess;
	}

}


