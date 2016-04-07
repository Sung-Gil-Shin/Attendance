package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.UserData;

public class LogInMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		

		UserData user = new UserData();
		user.setId(request.getParameter("id"));
		user.setPasswd(request.getParameter("passwd"));
		user.setName(request.getParameter("name"));
		user.setSocialNumPre(Integer.parseInt(request.getParameter("socialNumPre")));
		user.setSocialNumPost(Integer.parseInt(request.getParameter("socialNumPost")));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNum(request.getParameter("phoneNum"));
		user.setPermission(Integer.parseInt(request.getParameter("permission")));
		user.setDepNum(Integer.parseInt(request.getParameter("depNum")));
		user.setCurrentStatus(false);
		user.setLoginFlag(false);
		user.setUserNum(Integer.parseInt(request.getParameter("userNum")));
		
		
		ActionForward forward = new ActionForward();
		forward.setUrl("LogInMain.jsp");
		return forward;
	}

}
