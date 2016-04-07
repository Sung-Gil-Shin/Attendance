package action;

import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.SignUpService;
import vo.ActionForward;
import vo.UserData;

public class SignUpAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		UserData user = new UserData();
		user.setId(request.getParameter("id"));
		user.setPasswd(request.getParameter("passwd"));
		user.setName(request.getParameter("name"));
		user.setSocialNumPre(Integer.parseInt(request.getParameter("socialNumPre")));
		user.setSocialNumPost(Integer.parseInt(request.getParameter("socialNumPost")));
		user.setEmail(request.getParameter("email"));
		user.setPhoneNum(Integer.parseInt(request.getParameter("phoneNum")));

		SignUpService signUpService = new SignUpService();
		boolean registSuccess = signUpService.signUpUser(user);

		ActionForward forward = null;
		if (registSuccess) {

			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setUrl("LogInMain.jsp");

		} else {

			PrintWriter out = response.getWriter();
			response.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('signUp fail')");
			out.println("</script>");
		}

		return forward;
	}
}
