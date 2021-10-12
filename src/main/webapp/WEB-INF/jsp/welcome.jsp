<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
<link rel="stylesheet" href="/TimeSheetApp/css/LoginscreenDesign.css">
</head>
<h1>タイムシート</h1>
<body>
	<h3 class="greet">ようこそ！</h3>
	<form action="/TimeSheetApp/LoginServlet" method="post">
		<p>ユーザーID</p>
		<input type="text" name="userId"><br>
		<p>パスワード</p>
		<input type="password" name="pass"><br>
		<button type="submit">ログイン</button>
	</form>
	<br>
	<div style="text-align: center;">
		<a href="/TimeSheetApp/RegisterServlet" class="button">新規ユーザー</a>
	</div>
</body>
</html>