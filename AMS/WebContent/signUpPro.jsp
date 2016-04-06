<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.*"%>
<%@ page import="dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>

	<jsp:useBean id="userData" class="vo.UserData"></jsp:useBean>
	<jsp:setProperty property="*" name="vo" />
	<jsp:useBean id="dao" class="dao.LoginDAO"></jsp:useBean>
<%
    if(dao.insertUser(userData)>0){
   
        out.print("<script>");
        out.print("alert('가입을 축하드립니다.');");  
        out.print("location.href='memberSelect.jsp';");        
        out.print("</script>");
     }else{
       
        out.print("<script>");
        out.print("alert('회원가입이 정상적으로 완료되지 않았습니다.');");  
        out.print("history.back();");          
        out.print("</script>");
    }
 %>
</body>
</html>