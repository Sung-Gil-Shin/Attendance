package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;
import vo.UserData;

public class IdpwdViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserData userData = new UserData();
		userData.setEmail(request.getParameter("email"));
		userData.setName(request.getParameter("name"));
		userData.setSocialNumPre((Integer.parseInt(request.getParameter("socialNumPre"))));
		userData.setSocialNumPost((Integer.parseInt(request.getParameter("socialNumPost"))));
		
		return forward;
	}

}
