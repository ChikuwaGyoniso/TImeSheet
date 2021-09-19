<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
</head>
<body>
  <form action="/TimeSheetApp/RegisterServlet" method="post">
  ユーザーID：<input type="text" name="userId"><br>
  パスワード:<input type="password" name="pass"><br>
  メールアドレス：<input type="text" name="mail"><br>
  名前：<input type="text" name="name"><br>
  <input type="submit" value="登録">
  </form>
	<c:choose>
		<c:when test="${not empty errorMsg}">
			<p>${errorMsg }</p>
		</c:when>
		<c:otherwise>
			<p>${successMsg}</p>
		</c:otherwise>
	</c:choose>
		<a href="/TimeSheetApp/WelcomeServlet">トップへ</a>
</body>
</html>