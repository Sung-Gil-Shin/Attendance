<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>여긴 회원가입이다 ㅇㅋㅋㅋ</h2>
<form method="post" action="signUp.ams">
<label>아이디</label><input type="text" name = "id" value = "${UserData.id }"><br>
<label>비밀번호</label><input type="password" name = "passwd" value = "${UserData.passwd }"><br>
<label>이름</label><input type="text" name = "name" value = "${UserData.name}"><br>
<label>주민등록번호</label><input type="text" name = "socialNum_pre" value = "${UserData.socialNum_Pre}">
<label>-</label><input type="text" name = "socialNum_post" value = "${UserData.socialNum_Post}"><br>
<label>이메일</label><input type="email" name = "email" value = "${UserData.email}"><br>
<label>전화번호</label><input type="text" name = "phoneNum" value = "${UserData.phoneNum}"><br>
<input type="submit" value="가입"/>
</form>
</body>
</html>