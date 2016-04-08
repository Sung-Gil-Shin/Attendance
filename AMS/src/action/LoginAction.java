package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.LoginService;
import vo.ActionForward;
import vo.UserData;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserData user = new UserData();
		user.setId(request.getParameter("id"));
		user.setPasswd(request.getParameter("passwd"));
		
		LoginService loginService = new LoginService();
		boolean loginSuccess = loginService.LoginUser(user);
		
		
		ActionForward forward = null;
		if(loginSuccess){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("Main.jsp");  
			
		}else{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('login fail Action')");
			out.println("</script>");
		}
		

		
		return forward;
	}

}
