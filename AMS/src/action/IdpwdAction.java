package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class IdpwdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		int socialNumPre = (Integer.parseInt(request.getParameter("socialNumPre")));
		int socialNumPost = (Integer.parseInt(request.getParameter("socialNumPost")));
		
		
		return null;
	}

}
