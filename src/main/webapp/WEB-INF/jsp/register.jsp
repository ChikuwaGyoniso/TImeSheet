<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</body>
</html>