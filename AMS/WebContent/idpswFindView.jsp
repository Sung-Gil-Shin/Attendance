<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="vo.UserData" %>
    <%@page import = "java.sql.*" %>    
    <%@page import="dao.LoginDAO"%>
    <%@page import="action.*" %>
    <%@page import="svc.IdpswFindService" %>
    <% request.setCharacterEncoding("UTF-8"); %><!-- jsp에서 post형식으로 값 전달시 한글깨짐을 방지 -->
    <%
	IdpswFindService idpswFindService = new IdpswFindService();/* 객체생성 */
	String email, name;/* 각 스트링 값을 위한 변수 선언 */
	int socialNumPre, socialNumPost;/* 정수값을 위한 변수 선언 */
	email = request.getParameter("email");/* 여기서부터 각 변수에 값 할당 */
	name = request.getParameter("name");
	socialNumPre = Integer.parseInt(request.getParameter("socialNumPre"));
	socialNumPost = Integer.parseInt(request.getParameter("socialNumPost"));
	
	String returnValue = idpswFindService.idpswView(email, name, socialNumPre, socialNumPost);/* 객체에 값 전달 */
	
	String info[] = returnValue.split(",");/* 반환값 에서 특수 기호 ',' 를 기준으로 잘라서 배열에 저장  */
	String id = info[0];/* 각 배열값 변수에 저장 */
	String pass = info[1];
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
id : <%=id %><br/>
pass : <%=pass %>
</body>
</html>