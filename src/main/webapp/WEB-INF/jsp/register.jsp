<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/TimeSheetApp/css/RegisterscreenDesign.css">
<link rel="shortcut icon" href="/TimeSheetApp/img/favicon (1).ico">
<title>TimeSheet</title>
</head>
<div class="heading" data-en="TimeSheet">
	<span></span>
</div>
<h1>ユーザー登録</h1>
<body>
	<form action="/TimeSheetApp/RegisterServlet" method="post">
		<table>
			<tr>
				<th>ユーザーID：</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>パスワード:</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<th>メールアドレス：</th>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<th>名前:</th>
				<td><input type="text" name="name"></td>
			</tr>
		</table>
		<section>
			<button type="submit" class="btn">登録</button>
		</section>
	</form>
	<div style="text-align: center;">
		<c:choose>
			<c:when test="${not empty errorMsg}">
				<p>${errorMsg }</p>
			</c:when>
			<c:otherwise>
				<p>${successMsg}</p>
			</c:otherwise>
		</c:choose>
	</div>
	<div style="text-align: center">
		<a href="/TimeSheetApp/WelcomeServlet" class="button">トップへ</a>
	</div>
</body>

</html>