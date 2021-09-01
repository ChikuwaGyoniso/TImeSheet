<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TimeSheet</title>
</head>
<body>
	<p>
		ようこそ
		<c:out value="${userId}" />
		さん
	</p>
	<!-- 現在は推移のみ -->
	<a href="/TimeSheetApp/WelcomeServlet">トップへ</a>
</body>
</html>