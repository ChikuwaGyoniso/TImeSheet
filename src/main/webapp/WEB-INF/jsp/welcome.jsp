<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
<link rel="stylesheet" href="/TimeSheetApp/css/LoginscreenDesign.css">
</head>
<header>
	<h1>タイムシート</h1>
</header>
<body>
	<div style="text-align: center;">
		<form action="/TimeSheetApp/LoginServlet" method="post">
			<p>ユーザーID</p>
			<input type="text" name="userId" size="21"><br>
			<p>パスワード</p>
			<input type="password" name="pass" size="21"><br>
			<button type="submit" class="login">ログイン</button>
		</form>
	</div>
	<br>
	<div style="text-align: center;">
		<a href="/TimeSheetApp/RegisterServlet" class="button">新規ユーザー</a>
	</div>
</body>
</html>