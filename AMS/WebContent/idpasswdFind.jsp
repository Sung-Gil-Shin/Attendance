<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
      <title>find</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/find.css" type="text/css" rel="stylesheet" />
<script src="../js/jquery-1.10.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
// window로드 됐을때, id가 btnFindUid / btnFindPW 인 것을 클릭하면 해당 함수 실행
 $(window).load(function() {
  $("#btnFindUid").click(btnFindUid);
  $("#btnFindPW").click(btnFindPW);
 });
 
// btnFindUid를 클릭했을 때 실행되는 함수내용.
 function btnFindUid(event) {
 
  // id가 Email인 객체를 Email이라는 변수에 저장.
  var Email = $("#Email");
 
  // 변수 Email의 value가 공백("")이면 alert창(경고창) 띄우고 return false를 함.
  if (Email.val() == "") {
   alert("이메일을 입력하세요");
   return;
  }
 
  var name = $("#name");
  if (name.val() == "") {
   alert("이름을 입력하세요");
   return;
  }
 
  // 해당 값들을 findIDResult.htm의 주소로 변수 Email과 name의 값들을 controller에 전달,
  // 전달한 후 받은 익명의 function으로 controller로 부터 받은 결과값(result변수 값)을 alert창을 통해 출력.
  $.post("findIDResult.htm", {
   Email : Email.val(),
   name : name.val()
  }, function(data) {
   alert(eval(data).result);
  });
 }
 
 function btnFindPW(event) {
  var id = $("#id");
  if (id.val() == "") {
   alert("아이디를 입력하세요");
   return;
  }
 
  var name = $("#pwname");
  if (name.val() == "") {
   alert("이름을 입력하세요");
   return;
  }
 
  var PwQ = $("#PwQ");
  if (PwQ.val() == "") {
   alert("질문을 선택하세요");
   return;
  }
 
  var PwA = $("#PwA");
  if (PwA.val() == "") {
   alert("답변을 입력하세요");
   return;
  }
 
  $.post("findPWResult.htm", {
   id : id.val(),
   name : name.val(),
   PwQ : PwQ.val(),
   PwA : PwA.val()
  }, function(data) {
   alert(eval(data).result);
  });
 }
 
</script>
</head>
<body>
<div class="leftt">
   <form name="form1" action="idpasswdFind.ams" method="post">
    <fieldset>
     <legend class="hidden"> ID/비밀번호 찾기 </legend>
     <ul id="findID">
      <li>아이디&비밀번호 찾기</li>
      <li><label>· E-mail </label><input type="email" id="Email" name="email" /></li>
      <li><label>· 이름 </label> <input type="text" id="name" name="name" /></li>
      <li><label>· 주민등록번호 </label> <input type="number" id="name" name="socialNumPre" />
      <label>-</label><input type="number" id="name" name="socialNumPost" /></li>
      <li>
       <input type="submit" name="btnFindUid" id="btnFindUid" value="아이디 비밀번호 찾기" />
      </li>
     </ul>
    </fieldset>
   </form>
  </div>
 




  </body>
</html>