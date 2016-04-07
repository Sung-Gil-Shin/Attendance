package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.IdpwdAction;
import action.LogInMainAction;
import action.LoginAction;
import action.SignUpAction;
import vo.ActionForward;

/**
 * Servlet implementation class LoginFrontController
 */
@WebServlet("*.ams")
public class LoginFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
		//URL : http://localhost:8088/boardProject/boardWriteForm.bo
		//requestURI : /boardProject/boardWriteForm.bo
		
		String contextPath = request.getContextPath();
		// /boardProject
		
		String command = requestURI.substring(contextPath.length());
		
    	Action action = null;
		ActionForward forward = null;
		if(command.equals("/signUp.ams")){
			action = new SignUpAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/login.ams")){
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/idpasswdFind.ams")){
			action = new IdpwdAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getUrl());
			}
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

}
