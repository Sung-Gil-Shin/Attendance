package action;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.SignUpService;
import vo.ActionForward;
import vo.UserData;

public class SignUpAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		UserData user = new UserData();
		
		SignUpService signUpService = new SignUpService();
		boolean registSuccess = signUpService.signUpUser(user);
		
		ActionForward forward = null;
		if(registSuccess){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("LogInMain.jsp");
			
		}
	
		return forward;
	}
}
