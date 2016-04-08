package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.IdpswFindService;
import vo.ActionForward;
import vo.UserData;

public class IdpwdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		UserData userData = new UserData();
		userData.setEmail(request.getParameter("email"));
		userData.setName(request.getParameter("name"));
		userData.setSocialNumPre((Integer.parseInt(request.getParameter("socialNumPre"))));
		userData.setSocialNumPost((Integer.parseInt(request.getParameter("socialNumPost"))));
		
		
		IdpswFindService idpswFindService = new IdpswFindService();
		boolean IdpswFindSuccess = idpswFindService.idpswFind(userData);
		UserData user = idpswFindService.idpswView(userData);
		
		ActionForward forward = null;
		if(IdpswFindSuccess){
			request.setAttribute("id", user.getId());
			request.setAttribute("passwd", user.getPasswd());
			
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("idpswFindView.jsp");  
			
		}else{
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('find fail')");
			out.println("</script>");
		}
		

		
		return forward;
	}

}
